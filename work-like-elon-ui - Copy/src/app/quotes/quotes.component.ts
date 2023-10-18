import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-quotes',
  templateUrl: './quotes.component.html',
  styleUrls: ['./quotes.component.css']
})
export class QuotesComponent implements OnInit {
  quoteText: any;
  quoteAuthor: any;
  constructor(private http: HttpClient){}
  quotes:any = [];


  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.fetchDailyQuotes();

  }

  public fetchDailyQuotes(){
    this.http.get('https://type.fit/api/quotes').subscribe((res:any) => {
      console.log('quotes ',res);
      this.quotes = res;
      this.generateRandomQuote();
    });
  }

  generateRandomQuote(){
    let randomWholeNumber = Math.floor(Math.random() * this.quotes.length);
    this.quoteText = this.quotes[randomWholeNumber].text;
    this.quoteAuthor = this.quotes[randomWholeNumber].author;
  }
}
