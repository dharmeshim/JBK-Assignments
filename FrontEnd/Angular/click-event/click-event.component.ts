import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-click-event',
  templateUrl: './click-event.component.html',
  styleUrls: ['./click-event.component.css']
})
export class ClickEventComponent implements OnInit {

  handleClick(data:string){
    console.log(data);
  }
 
  constructor() { }

  
  ngOnInit(): void {
  }

}
