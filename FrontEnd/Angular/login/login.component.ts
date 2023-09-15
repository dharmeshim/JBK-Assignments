import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor() { }

  ngOnInit(): void {
  }


  onClicklog(name:any, password:any ){
    if(name == "dpr" && password=="12345"){
      window.alert("loged in")
    }
  }
}
