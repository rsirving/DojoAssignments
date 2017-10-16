import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  input = {
    level: 0
  }
  output = {
    level: 0
  }
  onSubmit(){
    this.output.level = this.input.level;
  }
}
