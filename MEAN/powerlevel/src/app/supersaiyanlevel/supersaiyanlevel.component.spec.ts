import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupersaiyanlevelComponent } from './supersaiyanlevel.component';

describe('SupersaiyanlevelComponent', () => {
  let component: SupersaiyanlevelComponent;
  let fixture: ComponentFixture<SupersaiyanlevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupersaiyanlevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupersaiyanlevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
