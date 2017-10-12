import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  date = new Date();
  zone = 'EST';
  EST = this.date;
  CST = this.date.setHours(this.date.getHours()-1);
  MST = this.date.setHours(this.date.getHours()-2);
  PST = this.date.setHours(this.date.getHours()-3);
}
