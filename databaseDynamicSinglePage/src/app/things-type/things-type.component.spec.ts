import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThingsTypeComponent } from './things-type.component';

describe('ThingsTypeComponent', () => {
  let component: ThingsTypeComponent;
  let fixture: ComponentFixture<ThingsTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThingsTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThingsTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
