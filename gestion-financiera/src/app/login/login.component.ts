import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';
import { EncryptSessionStorage } from 'src/util/secure-session-storage';
import { SessionStorage } from 'src/util/session-storage';
import {UsuarioService} from '../../service/usuario.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    loginUser = {'user': '', 'pass': ''};

    constructor(
      public router: Router,
      private loginsvc: UsuarioService
    ) {}

    ngOnInit() {}

    onLoggedin() {
        // const u = {'user': 'mlopez', 'pass': '1234', };
        this.loginsvc.loginUser(this.loginUser).toPromise().then( r => {
        }).catch( er => {
            console.log(er);
        });

        SessionStorage.setItem('publickey', '74a69d2e-9220-48');
        EncryptSessionStorage.setContexto(this.loginUser);
        localStorage.setItem('isLoggedin', 'true');
        this.router.navigate(['/dashboard']);
    }
}
