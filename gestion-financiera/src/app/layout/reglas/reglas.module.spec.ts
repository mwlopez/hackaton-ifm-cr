import { ReglasModule } from './reglas.module';

describe('ReglasModule', () => {
    let reglasModule: ReglasModule;

    beforeEach(() => {
        reglasModule = new ReglasModule();
    });

    it('should create an instance', () => {
        expect(reglasModule).toBeTruthy();
    });
});
