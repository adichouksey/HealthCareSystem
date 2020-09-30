import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMedicalTestComponent } from './list-medical-test.component';

describe('ListMedicalTestComponent', () => {
  let component: ListMedicalTestComponent;
  let fixture: ComponentFixture<ListMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
