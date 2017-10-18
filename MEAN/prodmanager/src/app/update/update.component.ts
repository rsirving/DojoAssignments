import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  updateProduct;

  constructor( private _router: Router, private _route: ActivatedRoute, private _taskService: TaskService ) {
    this._route.paramMap.subscribe( params => {
      console.log(params.get('id'));
      this.updateProduct = this._taskService.getSingleProduct(params.get('id'));
    })
   }

  ngOnInit() { }

  update(){
    this._taskService.updateProduct(this.updateProduct);
    this._router.navigate(['products']);
  }

  delete(){
    this._taskService.removeProduct(this.updateProduct.id);
    this._router.navigate(['products']);
  }

}
