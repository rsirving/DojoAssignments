import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class ScoreService {

  score = undefined;

  constructor(private _http: Http) { }

  getScore(username, callback) {
    this._http.get('https://api.github.com/users/'+username).subscribe(
      (response) => {
        let data = response.json();
        this.score = data.followers + data.public_repos;
        callback();
      },
      (error) => {
        this.score = -1;
        callback();
      }
    )
  }

  sendScore(){
    return this.score;
  }

}
