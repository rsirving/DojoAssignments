import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-fightertype',
  templateUrl: './fightertype.component.html',
  styleUrls: ['./fightertype.component.css']
})
export class FightertypeComponent implements OnInit {
  @Input() level;
  constructor() { }

  ngOnInit() {
  }

}
