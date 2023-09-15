import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fordirective',
  templateUrl: './fordirective.component.html',
  styleUrls: ['./fordirective.component.css']
})
export class FordirectiveComponent implements OnInit {

  selected:string = "";

  states:string[] = ["Maharastra", "Assam", "Tamil nadu", "kerala"];

  arrProduct=[


    {
      name: "samsung",
      price: 1234,
      qty: 1
    },

    {
      name:"nothing",
      price:2000,
      qty:1
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }


  onMouseOver(product:any){
    this.selected = product.name;
  }

  onMouseOut(){
    this.selected = "";
  }

}
