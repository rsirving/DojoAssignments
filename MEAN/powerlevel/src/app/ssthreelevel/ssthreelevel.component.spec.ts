import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SsthreelevelComponent } from './ssthreelevel.component';

describe('SsthreelevelComponent', () => {
  let component: SsthreelevelComponent;
  let fixture: ComponentFixture<SsthreelevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SsthreelevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SsthreelevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
