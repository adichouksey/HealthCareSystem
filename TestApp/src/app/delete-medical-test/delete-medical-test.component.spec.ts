import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteMedicalTestComponent } from './delete-medical-test.component';

describe('DeleteMedicalTestComponent', () => {
  let component: DeleteMedicalTestComponent;
  let fixture: ComponentFixture<DeleteMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
