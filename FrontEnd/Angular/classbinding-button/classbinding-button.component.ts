import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-classbinding-button',
  templateUrl: './classbinding-button.component.html',
  styleUrls: ['./classbinding-button.component.css']
})
export class ClassbindingButtonComponent implements OnInit {


  isItalic = false;
  isColored = false;

  applyStyle() {
    this.isItalic = !this.isItalic;
    this.isColored = !this.isColored;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
