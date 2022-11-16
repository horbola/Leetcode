<?php

include "RomanToInt.php";
use org\horbola\leetcode\php\romantoint\RomanToInt;

main();



function main(){
    for (;;){
        echo "\n";

        echo "Please enter the sample string from which to convert the roman to integer";
        echo "if you want to close the program, please press 'c', to continue to run press Enter";

        $input = readline("enter your name\n");
        if ($input === 'c')
            break;
        else {
            callProgram($input);
        }
    }
}

function callProgram($input){
    $romanToInt = new RomanToInt($input);
    $romanToInt->convert()->print();
}

