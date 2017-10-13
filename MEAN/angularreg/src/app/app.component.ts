import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = {
    email: "",
    firstname: "",
    lastname: "",
    password: "",
    address: "",
    city: "",
    lucky: ""
  };
  users = [];
  onSubmit(){
    console.log(this.user);
    this.users.push(this.user);
    console.log(this.users);
    this.user = {
      email: "",
      firstname: "",
      lastname: "",
      password: "",
      address: "",
      city: "",
      lucky: ""
    };
  };
}
