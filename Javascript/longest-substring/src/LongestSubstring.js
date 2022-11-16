
function LongestSubstring(string) {
    this.string = string;
    this.chars = [];
    this.count = 0;
}

LongestSubstring.prototype.findLongest = function () {
    for (let i = 0; i < this.string.length; i++){
        let charSamp = this.string.charAt(i);
        if (this.chars.includes(charSamp)){
            this.count = this.chars.length;
        }
        else {
            this.chars.push(charSamp);
        }
    }
    return this;
}

LongestSubstring.prototype.getCount = function () {
    return this.count;
}

LongestSubstring.prototype.printCharCount = function () {
    console.log(`The longest non repeating substring is: ${this.count}`);
}

LongestSubstring.prototype.print = function () {
    console.log(`The longest non repeating substring is: ${this.string.substring(0, this.count)}`);
}

module.exports = LongestSubstring;

