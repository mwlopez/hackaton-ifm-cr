import { BeneficiosModule } from './beneficios.module';

describe('BeneficiosModule', () => {
    let beneficiosModule: BeneficiosModule;

    beforeEach(() => {
        beneficiosModule = new BeneficiosModule();
    });

    it('should create an instance', () => {
        expect(beneficiosModule).toBeTruthy();
    });
});
