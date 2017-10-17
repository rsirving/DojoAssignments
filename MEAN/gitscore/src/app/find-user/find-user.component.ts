import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ScoreService } from './../score.service';

@Component({
  selector: 'app-find-user',
  templateUrl: './find-user.component.html',
  styleUrls: ['./find-user.component.css']
})
export class FindUserComponent implements OnInit {
  @Output() aScoreEventEmitter = new EventEmitter();
  input = {
    username: ""
  }
  constructor(private _scoreService: ScoreService) { }

  ngOnInit() {
  }

  onSubmit() {
    this._scoreService.getScore(this.input.username, () => { this.aScoreEventEmitter.emit() });
  }

}
