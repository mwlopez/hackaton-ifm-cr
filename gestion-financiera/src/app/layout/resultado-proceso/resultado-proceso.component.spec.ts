import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ResultadosComponent } from './resultado-proceso.component';
import { ResultadosModule } from './resultado-proceso.module';

describe('ResultadosComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [ResultadosModule, RouterTestingModule],
        }).compileComponents();
    }));

    it('should create', () => {
        const fixture = TestBed.createComponent(ResultadosComponent);
        const component = fixture.componentInstance;
        expect(component).toBeTruthy();
    });
});
