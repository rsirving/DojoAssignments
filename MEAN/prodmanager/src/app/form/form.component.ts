import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  product = {
    title: '',
    price: 0,
    image: ''
  };

  constructor( private _taskService: TaskService, private _router: Router ) { }

  ngOnInit() { }

  onSubmit() {
    console.log(this.product);
    this._taskService.addProduct(this.product);
    this._router.navigate(['products']);
  }

}
