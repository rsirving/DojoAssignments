import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SsfourlevelComponent } from './ssfourlevel.component';

describe('SsfourlevelComponent', () => {
  let component: SsfourlevelComponent;
  let fixture: ComponentFixture<SsfourlevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SsfourlevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SsfourlevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
