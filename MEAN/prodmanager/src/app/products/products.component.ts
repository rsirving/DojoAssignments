import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products;

  constructor(private _taskService: TaskService) { }

  ngOnInit() {
    this._taskService.getProducts((data)=>{
      this.products = data;
    });
  }    
}
