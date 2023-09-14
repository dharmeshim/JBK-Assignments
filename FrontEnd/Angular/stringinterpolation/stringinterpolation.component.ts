import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stringinterpolation',
  templateUrl: './stringinterpolation.component.html',
  styleUrls: ['./stringinterpolation.component.css']
})
export class StringinterpolationComponent implements OnInit {

  
  name:string = "good name";

  imgg:string='./../assets/pic.png';
  constructor() { }

  ngOnInit(): void {
  }

}
