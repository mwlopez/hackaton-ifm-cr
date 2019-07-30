import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ReglasComponent } from './reglas.component';
import { ReglasModule } from './reglas.module';

describe('ReglasComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [ReglasModule, RouterTestingModule],
        }).compileComponents();
    }));

    it('should create', () => {
        const fixture = TestBed.createComponent(ReglasComponent);
        const component = fixture.componentInstance;
        expect(component).toBeTruthy();
    });
});
