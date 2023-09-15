import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimecheckComponent } from './primecheck.component';

describe('PrimecheckComponent', () => {
  let component: PrimecheckComponent;
  let fixture: ComponentFixture<PrimecheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimecheckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimecheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
