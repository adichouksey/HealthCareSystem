import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMedicalTestComponent } from './add-medical-test.component';

describe('AddMedicalTestComponent', () => {
  let component: AddMedicalTestComponent;
  let fixture: ComponentFixture<AddMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
