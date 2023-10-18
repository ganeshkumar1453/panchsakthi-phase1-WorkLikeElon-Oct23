import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { YouTubePlayerModule } from '@angular/youtube-player';
import { YoutubeListComponent } from './youtube-list/youtube-list.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { QuotesComponent } from './quotes/quotes.component';
import { TimerComponent } from './timer/timer.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    YoutubeListComponent,
    HomeComponent,
    QuotesComponent,
    TimerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    YouTubePlayerModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
