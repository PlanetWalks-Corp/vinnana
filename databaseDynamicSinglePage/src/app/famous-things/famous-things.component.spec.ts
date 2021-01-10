import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FamousThingsComponent } from './famous-things.component';

describe('FamousThingsComponent', () => {
  let component: FamousThingsComponent;
  let fixture: ComponentFixture<FamousThingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FamousThingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FamousThingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
