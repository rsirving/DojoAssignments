import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FightertypeComponent } from './fightertype.component';

describe('FightertypeComponent', () => {
  let component: FightertypeComponent;
  let fixture: ComponentFixture<FightertypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FightertypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FightertypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
