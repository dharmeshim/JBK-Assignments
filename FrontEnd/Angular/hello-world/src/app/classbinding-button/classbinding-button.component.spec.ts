import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassbindingButtonComponent } from './classbinding-button.component';

describe('ClassbindingButtonComponent', () => {
  let component: ClassbindingButtonComponent;
  let fixture: ComponentFixture<ClassbindingButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassbindingButtonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassbindingButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
