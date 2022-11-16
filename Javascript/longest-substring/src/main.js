
const prompt = require("prompt-sync")();

const LongestSubstring = require("./LongestSubstring.js");


(function main() {
    for (;;){
        console.log("\n")
        console.log("Please enter the sample string from which to extract the longest substring without repeating character")
        console.log("if you want to close the program, please press 'c', to continue to run press Enter");

        const input = prompt();
        if (input === 'c')
            break;
        else {
            callProgram(input);
        }
    }
}());


function callProgram(answer) {
    new LongestSubstring(answer).findLongest().print();
}
