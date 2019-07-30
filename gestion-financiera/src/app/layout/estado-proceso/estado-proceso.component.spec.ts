import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { EstadoComponent } from './estado-proceso.component';
import { EstadoModule } from './estado-proceso.module';

describe('EstadoComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [EstadoModule, RouterTestingModule],
        }).compileComponents();
    }));

    it('should create', () => {
        const fixture = TestBed.createComponent(EstadoComponent);
        const component = fixture.componentInstance;
        expect(component).toBeTruthy();
    });
});
