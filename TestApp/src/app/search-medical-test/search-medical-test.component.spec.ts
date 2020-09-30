import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchMedicalTestComponent } from './search-medical-test.component';

describe('SearchMedicalTestComponent', () => {
  let component: SearchMedicalTestComponent;
  let fixture: ComponentFixture<SearchMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
