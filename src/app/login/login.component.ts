import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User =new User();

  constructor(private _router:Router,private _service : RegisterService) { }

  ngOnInit(): void {
  }

  onSubmit(){

    this._service.onSubmit(this.user).subscribe(data=>{
      alert("Login successful");
      this._router.navigate(['/home-page'])
     },error=>alert("Invalid"));
    
  }

}