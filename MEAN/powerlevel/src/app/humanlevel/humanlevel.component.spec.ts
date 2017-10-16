import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HumanlevelComponent } from './humanlevel.component';

describe('HumanlevelComponent', () => {
  let component: HumanlevelComponent;
  let fixture: ComponentFixture<HumanlevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HumanlevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HumanlevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
