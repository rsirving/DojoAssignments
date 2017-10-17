import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class TaskService {
  url = "http://api.openweathermap.org/data/2.5/weather?q=";
  apikey = "&appid=5f3d76119f045fef0d5ff4adcbc089d6";
    
  constructor(private _http: Http) { }

  getWeather(city, callback){
    this._http.get(this.url + city + this.apikey).subscribe(
      (response) => {
        callback(response.json());
      },
      (error) => {
        console.log("Whoops.");
        callback();
      }
    )
  }

}
