import { Component, OnInit } from '@angular/core';
import { TaskService } from './../task.service';

@Component({
  selector: 'app-washington',
  templateUrl: './washington.component.html',
  styleUrls: ['./washington.component.css']
})
export class WashingtonComponent implements OnInit {
  weather;
  
  constructor(private _taskService: TaskService ) { }
  
  ngOnInit() { 
    this._taskService.getWeather('washingtondc', (data)=>{
      this.weather = data;
    });
  }

}
