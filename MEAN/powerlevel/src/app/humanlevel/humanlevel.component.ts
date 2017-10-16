import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-humanlevel',
  templateUrl: './humanlevel.component.html',
  styleUrls: ['./humanlevel.component.css']
})
export class HumanlevelComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
