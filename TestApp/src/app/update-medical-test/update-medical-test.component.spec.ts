import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMedicalTestComponent } from './update-medical-test.component';

describe('UpdateMedicalTestComponent', () => {
  let component: UpdateMedicalTestComponent;
  let fixture: ComponentFixture<UpdateMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
