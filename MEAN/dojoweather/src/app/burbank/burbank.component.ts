import { Component, OnInit } from '@angular/core';
import { TaskService } from './../task.service';

@Component({
  selector: 'app-burbank',
  templateUrl: './burbank.component.html',
  styleUrls: ['./burbank.component.css']
})
export class BurbankComponent implements OnInit {
  weather;
  
  constructor(private _taskService: TaskService ) { }
  
  ngOnInit() { 
    this._taskService.getWeather('burbank', (data)=>{
      this.weather = data;
      console.log(this.weather);
    });
  }

}
