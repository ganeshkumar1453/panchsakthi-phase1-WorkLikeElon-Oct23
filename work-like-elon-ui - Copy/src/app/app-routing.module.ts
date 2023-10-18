import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { YoutubeListComponent } from './youtube-list/youtube-list.component';
import { HomeComponent } from './home/home.component';
import { QuotesComponent } from './quotes/quotes.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path:'youtube', component: YoutubeListComponent},
  {path: 'quotes', component: QuotesComponent},
  {path: '', redirectTo:'home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
