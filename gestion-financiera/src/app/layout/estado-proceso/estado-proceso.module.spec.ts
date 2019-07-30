import { BeneficiosModule } from './estado-proceso.module';

describe('EstadoModule', () => {
    let estadoModule: EstadoModule;

    beforeEach(() => {
        estadoModule = new EstadoModule();
    });

    it('should create an instance', () => {
        expect(estadoModule).toBeTruthy();
    });
});
