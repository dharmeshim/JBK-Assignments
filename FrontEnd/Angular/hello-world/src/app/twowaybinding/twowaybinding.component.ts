import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-twowaybinding',
  templateUrl: './twowaybinding.component.html',
  styleUrls: ['./twowaybinding.component.css']
})
export class TwowaybindingComponent implements OnInit {


  name:String= "";

  constructor() { }

  ngOnInit(): void {
  }

  onChange(){
    console.log(this.name);
  }

}
