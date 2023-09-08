export class Table {
    printTable(value: number) {
        for (let i = 1; i <= 10; i++) {
            let multipication = i * value;
            console.log(` ${i} * ${value} = ${multipication}`)
        }
    }
}