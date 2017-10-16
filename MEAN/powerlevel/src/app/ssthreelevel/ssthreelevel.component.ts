import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-ssthreelevel',
  templateUrl: './ssthreelevel.component.html',
  styleUrls: ['./ssthreelevel.component.css']
})
export class SsthreelevelComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
