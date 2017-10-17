import { Component, OnInit } from '@angular/core';
import { TaskService } from './../task.service';

@Component({
  selector: 'app-dallas',
  templateUrl: './dallas.component.html',
  styleUrls: ['./dallas.component.css']
})
export class DallasComponent implements OnInit {
  weather;
  
  constructor(private _taskService: TaskService ) { }
  
  ngOnInit() { 
    this._taskService.getWeather('dallas', (data)=>{
      this.weather = data;
    });
  }
  
}
  