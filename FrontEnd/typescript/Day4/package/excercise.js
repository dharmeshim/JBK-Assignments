"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Table = void 0;
var Table = /** @class */ (function () {
    function Table() {
    }
    Table.prototype.printTable = function (value) {
        for (var i = 1; i <= 10; i++) {
            var multipication = i * value;
            console.log(" ".concat(i, " * ").concat(value, " = ").concat(multipication));
        }
    };
    return Table;
}());
exports.Table = Table;
