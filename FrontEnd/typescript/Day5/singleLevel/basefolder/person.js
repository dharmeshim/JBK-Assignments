"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person = void 0;
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.whoAmI = function () {
        console.log("I am Person, my name is" + this.name);
    };
    return Person;
}());
exports.Person = Person;
