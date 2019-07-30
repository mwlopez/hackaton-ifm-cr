import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ArchivosComponent } from './archivos.component';
import { ArchivosModule } from './archivos.module';

describe('ArchivosComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [ArchivosModule, RouterTestingModule],
        }).compileComponents();
    }));

    it('should create', () => {
        const fixture = TestBed.createComponent(ArchivosComponent);
        const component = fixture.componentInstance;
        expect(component).toBeTruthy();
    });
});
