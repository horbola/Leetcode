
function RomanToInt(sampStr){
    this.digitVal = {
        'i' : 1,
        'v' : 5,
        'x' : 10,
        'l' : 50,
        'c' : 100,
        'd' : 500,
        'm' : 1000,
    };
    this.sampStr = sampStr;
    this.intVal = 0;
}

RomanToInt.prototype.print = function(){
    console.log(`The integer form of roman: '${this.sampStr}' is: ${this.intVal}`);
}



RomanToInt.prototype.convert = function (){
    let romanString = this.sampStr.toLowerCase();
    const romanMap = new Map();
    for (let i = 0; i < romanString.length; i++){
        romanMap.set( i, this.digitVal[romanString.charAt(i)] );
    }

    let adder = 0;
    while (romanMap.size !== 0){
        const romanIt = romanMap[Symbol.iterator]();
        let firstRoman = romanIt.next().value;
        let secondRoman = romanIt.next().value;

        if ( !(secondRoman && secondRoman[0] && secondRoman[1]) ){
            adder += firstRoman[1];
            break;
        }

        if( (firstRoman[1] > secondRoman[1]) || (firstRoman[1] == secondRoman[1]) ){
            adder += firstRoman[1];
            romanMap.delete(firstRoman[0]);
        }
        else{
            adder += secondRoman[1] - firstRoman[1];
            romanMap.delete(firstRoman[0]);
            romanMap.delete(secondRoman[0]);
        }
    }
    this.intVal = adder;
    return this;
};

module.exports = RomanToInt;
