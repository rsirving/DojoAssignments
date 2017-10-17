import { Component, OnInit } from '@angular/core';
import { TaskService } from './../task.service';

@Component({
  selector: 'app-seattle',
  templateUrl: './seattle.component.html',
  styleUrls: ['./seattle.component.css']
})
export class SeattleComponent implements OnInit {
  weather;
  
  constructor(private _taskService: TaskService ) { }
  
  ngOnInit() { 
    this._taskService.getWeather('seattle', (data)=>{
      this.weather = data;
    });
  }

}
