import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  quotation = {
    quote: "",
    author: ""
  };
  quoteList = [];
  onSubmit(){
    this.quoteList.push(this.quotation);
    this.quotation = {
      quote: "",
      author: ""
    }
  }
}
