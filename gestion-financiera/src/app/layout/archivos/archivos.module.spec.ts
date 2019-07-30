import { ArchivosModule } from './archivos.module';

describe('ArchivosModule', () => {
    let archivosModule: ArchivosModule;

    beforeEach(() => {
        archivosModule = new ArchivosModule();
    });

    it('should create an instance', () => {
        expect(archivosModule).toBeTruthy();
    });
});
