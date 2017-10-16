import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-ssfourlevel',
  templateUrl: './ssfourlevel.component.html',
  styleUrls: ['./ssfourlevel.component.css']
})
export class SsfourlevelComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
