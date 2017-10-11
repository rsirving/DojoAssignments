import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  colors = [
    "blue", "red", "green", 'cyan', 'orange', 'black', 'darkolivegreen'
  ]
  order = [Math.floor(Math.random()*7), Math.floor(Math.random()*7), Math.floor(Math.random()*7), Math.floor(Math.random()*7), Math.floor(Math.random()*7), Math.floor(Math.random()*7), Math.floor(Math.random()*7)]
}
