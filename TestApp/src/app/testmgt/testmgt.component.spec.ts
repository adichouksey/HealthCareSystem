import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestmgtComponent } from './testmgt.component';

describe('TestmgtComponent', () => {
  let component: TestmgtComponent;
  let fixture: ComponentFixture<TestmgtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestmgtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestmgtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
