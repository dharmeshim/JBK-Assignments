import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-propertybinding',
  templateUrl: './propertybinding.component.html',
  styleUrls: ['./propertybinding.component.css']
})
export class PropertybindingComponent implements OnInit {

  name:string = "good name";
  imgg:string='./../assets/pic.png';
  constructor() { }

  ngOnInit(): void {
  }

}
