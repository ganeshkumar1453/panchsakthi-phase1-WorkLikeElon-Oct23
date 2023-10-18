import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YoutubeListComponent } from './youtube-list.component';

describe('YoutubeListComponent', () => {
  let component: YoutubeListComponent;
  let fixture: ComponentFixture<YoutubeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [YoutubeListComponent]
    });
    fixture = TestBed.createComponent(YoutubeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
