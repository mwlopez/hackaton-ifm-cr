import * as crypto from 'crypto-js';
import { SessionStorage } from '../util/session-storage';
import { of } from 'rxjs';
import { delay, finalize, shareReplay, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { EncryptSessionStorage } from 'src/util/secure-session-storage';

export interface CacheConfiguration {
    maxAge?: number;
    maxCacheCount?: number;
    evict?: any;
}

export function CacheResponse (cacheConfig?: CacheConfiguration) {
    return function(target: Object, propertyKey: string, descriptor: TypedPropertyDescriptor<any>) {
        const originalMethod = descriptor.value;
        const map = new Map<string, CacheMessage>();
        descriptor.value = function(...args: any[]) {
            const s =  crypto.MD5(JSON.stringify(args)).toString();
            const c = obtenerDatos(s, map);
            if (c) {
                const cached$ = of(JSON.parse(c));
                return cached$.pipe(delay(0));
            } else {
                const response$ = originalMethod.apply(this, args).pipe(
                    finalize(() => {
                    }),
                    tap(
                        result => {
                            guardarDatos(s, JSON.stringify(result), map);
                        }
                    ),
                    shareReplay()
                );
                return response$;
            }
        };
        return descriptor;
    };
}

export class CacheMessage {
    attributes: any;
    message: any;
}

export function guardarDatos (key: string, value: string, map) {
    if (environment.env === 'prod') {
        const cacheMessage = new CacheMessage();
        cacheMessage.message = environment.env === 'prod' ? EncryptSessionStorage.encrypt(value) : value;
        const target = map.set(key, cacheMessage);
    } else {
        SessionStorage.setItem(key, value);
    }
}

export function obtenerDatos (key, map): any {
    if (environment.env === 'prod') {
        if (map.has(key)) {
            const target = map.get(key);
            return environment.env === 'prod' ? EncryptSessionStorage.decrypt(target.message) : target.message;
        }
        return null;
    } else {
        return SessionStorage.getItem(key);
    }
}