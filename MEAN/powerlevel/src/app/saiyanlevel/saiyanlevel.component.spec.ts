import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaiyanlevelComponent } from './saiyanlevel.component';

describe('SaiyanlevelComponent', () => {
  let component: SaiyanlevelComponent;
  let fixture: ComponentFixture<SaiyanlevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaiyanlevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaiyanlevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
