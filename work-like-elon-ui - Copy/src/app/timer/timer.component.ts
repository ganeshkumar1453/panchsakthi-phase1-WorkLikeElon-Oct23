import { Component } from '@angular/core';
import { YoutubeService } from '../youtube.service';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css']
})
export class TimerComponent {

  status: string = '';
  timerDuration: number = 0;

  constructor(private youtubeService: YoutubeService){
    
  }

  startTimer() {
    console.log("In startTimer Entry")
    if (!isNaN(this.timerDuration) && this.timerDuration > 0) {
      // Replace Chrome-specific code with your logic
      // For example, you can create a timer using RxJS.
      this.status = 'Timer started!...';
      this.youtubeService.setTimer(this.timerDuration);
      sessionStorage.setItem('timer',this.status);
      // Store data using a service or HTTP request if needed.
      chrome.storage.local.get

      chrome.runtime.sendMessage(
        { action: 'yourAction', data: 'Your data here' },
        function (response) {
          // Handle any response from the background script
          console.log('Response from background script:', response);
        }
      );
    } else {
      this.status = 'Please enter a valid duration.';
      this.youtubeService.setTimer(0);
      sessionStorage.setItem('timer','');
    }
  }

  stopTimer() {
    // Replace Chrome-specific code with your logic
    // Store data using a service or HTTP request if needed.
  }

  // setWindowSize() {
  //   // Modify the window size here
  //   window.resizeTo(800, 1600);
  // }
}
