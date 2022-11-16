
const RomanToInt = require("./RomanToInt.js");
const prompt = require("prompt-sync")();



(function main() {
    for (;;){
        console.log("\n")
        console.log("Please enter the sample string from which to convert the roman to integer")
        console.log("if you want to close the program, please press 'c', to continue to run press Enter");

        const input = prompt();
        if (input === 'c')
            break;
        else {
            callProgram(input);
        }
    }
}());


function callProgram(input) {
    new RomanToInt(input).convert().print();
}
