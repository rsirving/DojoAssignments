import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  validation = false;
  problem = false;
  userid = -1;
  user = {
    email: "",
    firstname: "",
    lastname: "",
    password: "",
    passwordconfirm: "",
    address: "",
    city: "",
    lucky: ""
  };
  users = [];
  onSubmit(){
    if (this.user.password === this.user.passwordconfirm){
      this.users.push(this.user);
      this.userid += 1;
      this.validation = true;
      this.problem = false;
      this.user = {
        email: "",
        firstname: "",
        lastname: "",
        password: "",
        passwordconfirm: "",
        address: "",
        city: "",
        lucky: ""
      };
    } else {
      this.problem = true;
    }
  };
}
