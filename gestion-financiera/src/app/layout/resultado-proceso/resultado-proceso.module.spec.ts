import { ResultadosModule } from './resultado-proceso.module';

describe('ResultadosModule', () => {
    let resultadosModule: ResultadosModule;

    beforeEach(() => {
        resultadosModule = new ResultadosModule();
    });

    it('should create an instance', () => {
        expect(resultadosModule).toBeTruthy();
    });
});
