import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class YoutubeService {
  idList: any = []
  timerDuration: any = 0;

  constructor(private http: HttpClient) { }

  getSearchedList(searchString: string) {
    console.log('api', searchString);
    return this.http.get('https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=10&q=' + searchString + '&key=AIzaSyDf1jveFnHBjUQqZqLoTyHJ6UCwVvTPOLg');
  }

  generateVideoId(str: string) {
    // let list:any = [];
    console.log(str, 'genved');
    this.getSearchedList(str).pipe(map((data: any) => {
      data.items.forEach((element: any) => {
        this.idList.push(element.id.videoId);
        console.log(element.id.videoId);
      });
    }))
    console.log(this.idList);
    return this.idList;
  }

  setTimer(timerDuration: any) {
    this.timerDuration = timerDuration;
  }

  getTimerFlag() {
    return this.timerDuration;
  }


  get(key: string, callback: (result: any) => void) {
    chrome.storage.local.get(key, callback);
  }

  set(data: object, callback: () => void) {
    chrome.storage.local.set(data, callback);
  }

  remove(key: string, callback: () => void) {
    chrome.storage.local.remove(key, callback);
  }
}

}
