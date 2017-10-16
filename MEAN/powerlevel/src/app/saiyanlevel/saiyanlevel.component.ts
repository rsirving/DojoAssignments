import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-saiyanlevel',
  templateUrl: './saiyanlevel.component.html',
  styleUrls: ['./saiyanlevel.component.css']
})
export class SaiyanlevelComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
