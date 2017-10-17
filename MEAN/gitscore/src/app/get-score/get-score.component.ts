import { ScoreService } from './../score.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-get-score',
  templateUrl: './get-score.component.html',
  styleUrls: ['./get-score.component.css']
})
export class GetScoreComponent implements OnInit {
  @Input() score;

  constructor() { }

  ngOnInit() {
  }

}
