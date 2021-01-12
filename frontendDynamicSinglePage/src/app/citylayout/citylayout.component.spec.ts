import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CitylayoutComponent } from './citylayout.component';

describe('CitylayoutComponent', () => {
  let component: CitylayoutComponent;
  let fixture: ComponentFixture<CitylayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CitylayoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CitylayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
