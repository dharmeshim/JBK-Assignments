import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primecheck',
  templateUrl: './primecheck.component.html',
  styleUrls: ['./primecheck.component.css']
})
export class PrimecheckComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  Result = "";
  isPrime: boolean = true;

  onClickPrimeCheck(num: any) {

    let number = parseInt(num)


    let isPrime = true;
    if (number <= 1) {
      isPrime = false;
    } else {
      for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) {
          isPrime = false;
          break;
        }
      }
    }
    if (isPrime) {
      this.Result = 'Number prime number';
    } else {
      this.Result = 'Number is not a prime number';
    }


  }

}
