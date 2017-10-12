import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  estTime = new Date();
  pstTime = new Date();
  cstTime = new Date();
  mstTime = new Date();
  zone = 'EST';
  EST = this.estTime;
  CST = this.cstTime.setHours(this.cstTime.getHours()-1);
  MST = this.mstTime.setHours(this.mstTime.getHours()-2);
  PST = this.pstTime.setHours(this.pstTime.getHours()-3);
}
