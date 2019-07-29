/**
 * Clase utilizada para almacenar datos en el explorador de manera segura utilizando
 * algoritmos de encryptación AES.
 */
import * as crypto from 'crypto-js';
import {SessionStorage} from './session-storage';

export class EncryptSessionStorage {
  constructor() {}

  static encrypt(text: string) {
    const secret = SessionStorage.getItem('publickey');
    return crypto.AES.encrypt(text, secret).toString();
  }
  static decrypt(crypto_text: string) {
    const secret = SessionStorage.getItem('publickey');
    return crypto.AES.decrypt(crypto_text, secret).toString(crypto.enc.Utf8);
  }

  static setItem(key: string, text) {
    SessionStorage.setItem(key, this.encrypt(text));
  }

  static getContexto(): any {
    const ctx = EncryptSessionStorage.getJson('ctx');
    console.log(ctx);
    return ctx;
  }

  static setContexto(ctx: any){
    const c = JSON.stringify(ctx);
    console.log(c);
    EncryptSessionStorage.setItem('ctx', c);
  }

  static getItem(key: string) {
    if (!SessionStorage.getItem(key)) {
      return SessionStorage.getItem(key);
    }
    return this.decrypt(SessionStorage.getItem(key));
  }

  static getJson(key: string) {
    return JSON.parse(EncryptSessionStorage.getItem(key));
  }

  static clearStorage() {
    SessionStorage.clearStorage();
  }

  static removeItem(key: string) {
    SessionStorage.removeItem(key);
  }
}
