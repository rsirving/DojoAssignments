import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-supersaiyanlevel',
  templateUrl: './supersaiyanlevel.component.html',
  styleUrls: ['./supersaiyanlevel.component.css']
})
export class SupersaiyanlevelComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
