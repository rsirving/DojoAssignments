import { Component, OnInit } from '@angular/core';
import { TaskService } from './../task.service';

@Component({
  selector: 'app-sanjose',
  templateUrl: './sanjose.component.html',
  styleUrls: ['./sanjose.component.css']
})
export class SanjoseComponent implements OnInit {
  weather;

  constructor(private _taskService: TaskService ) { }
  
  ngOnInit() { 
    this._taskService.getWeather('sanjose', (data)=>{
      this.weather = data;
    });
  }

}
