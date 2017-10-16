import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class ScoreService {

  followers = 0;
  public_repos = 0;

  constructor(private _http: Http) { }

  getScore(username) {
    this._http.get('https://api.github.com/users/'+username).subscribe(
      (response) => { 
        this.followers = response.json().followers;
        this.public_repos = response.json().followers;
      },
      (error) => {
        console.log("no");
      }
    )
  }

}
