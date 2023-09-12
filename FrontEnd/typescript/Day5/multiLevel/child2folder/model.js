"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var car_1 = require("../childfolder/car");
var CarModel = /** @class */ (function (_super) {
    __extends(CarModel, _super);
    function CarModel() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    CarModel.prototype.display = function () {
        console.log("In Car Model class");
    };
    return CarModel;
}(car_1.Car));
var model = new CarModel();
model.display();
console.log(model.name);
