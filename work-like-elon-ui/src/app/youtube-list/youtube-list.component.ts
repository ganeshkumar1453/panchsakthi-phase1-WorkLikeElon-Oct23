import { Component } from '@angular/core';
import { YoutubeService } from '../youtube.service';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-youtube-list',
  templateUrl: './youtube-list.component.html',
  styleUrls: ['./youtube-list.component.css']
})
export class YoutubeListComponent {
  videoList: any[] = [];
  constructor(public youtubeService: YoutubeService, private http: HttpClient){}

  public fetchVideoList(str:string){
    console.log('submit clicked');
    this.videoList = [];
    // this.videoList = this.youtubeService.idList;
    this.http.get('https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=10&q='+ str +'&key=AIzaSyDf1jveFnHBjUQqZqLoTyHJ6UCwVvTPOLg').subscribe((res:any) => {
      console.log(res);
      res.items.forEach((element:any) => {
        this.videoList.push(element.id.videoId);
        console.log(element.id.videoId);
      });
    })
    console.log('verify', this.videoList);
  }

}
