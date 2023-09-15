import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwicthdirectiveComponent } from './swicthdirective.component';

describe('SwicthdirectiveComponent', () => {
  let component: SwicthdirectiveComponent;
  let fixture: ComponentFixture<SwicthdirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SwicthdirectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SwicthdirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
