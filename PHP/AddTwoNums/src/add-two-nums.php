<?php
include "AddTwoNums.php";
use org\horbola\leetcode\php\addtwonums\AddTwoNums;




main();

function main(){
    for (;;){
        echo "\n";

        echo "Please enter two of numbers to add them in reverse order from their linked list";
        echo "if you want to close the program, please press 'c', to continue to run press Enter";

        $input = readline("enter your name\n");
        if ($input === 'c')
            break;
        else {
            $arr1 = getArray("first");
            $arr2 = getArray("second");
            callProgram($arr1, $arr2);
        }
    }
}

function getArray($cardinal){
    $length = readline("enter the length of the $cardinal array\n");
    $arr = array();
    for ($i = 0; $i < $length; $i++){
        $msg = "";
        if (count($arr) == 0){
            $msg = "Enter the first element of the $cardinal array";
        }
        else {
            $msg = "Enter the next element of the $cardinal array";
        }
        $arr[] = readline($msg);
    }
    return $arr;
}

function callProgram($arr1, $arr2){
    $twoNums = new AddTwoNums($arr1, $arr2);
    $twoNums->add()->print();
}

