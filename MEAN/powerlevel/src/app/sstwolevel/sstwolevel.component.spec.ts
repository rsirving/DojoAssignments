import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SstwolevelComponent } from './sstwolevel.component';

describe('SstwolevelComponent', () => {
  let component: SstwolevelComponent;
  let fixture: ComponentFixture<SstwolevelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SstwolevelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SstwolevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
