import { Component } from '@angular/core';
import { ScoreService } from './score.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  score = undefined; 
  constructor (private _scoreService: ScoreService) { }
  retrieveScore(){
    this.score = this._scoreService.sendScore();
  }
}
