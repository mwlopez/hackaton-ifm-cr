import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { BeneficiosComponent } from './beneficios.component';
import { BeneficiosModule } from './beneficios.module';

describe('BeneficiosComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [BeneficiosModule, RouterTestingModule],
        }).compileComponents();
    }));

    it('should create', () => {
        const fixture = TestBed.createComponent(BeneficiosComponent);
        const component = fixture.componentInstance;
        expect(component).toBeTruthy();
    });
});
