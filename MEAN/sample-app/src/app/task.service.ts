import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class TaskService {

  tasks = ["drink coffee or tea", "build a web app"];

  constructor(private _http: Http) { }

  retrieveTasks(){
    this._http.get('http(s)://59e6082df99ad90012268304.mockapi.io/testing').subscribe(
      (response) => { console.log(response.json()); },
      (error) => { console.log(error); }
    )
  }

  createTask(task){
    this.tasks.push(task);
  }

}
