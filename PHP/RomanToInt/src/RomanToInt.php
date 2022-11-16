<?php

namespace org\horbola\leetcode\php\romantoint;

class RomanToInt
{
    public array $digitVal;
    public $sampStr = "";
    public $intVal = 0;


    public function __construct($sampStr)
    {
        $this->digitVal = array(
            'i' => 1,
            'v' => 5,
            'x' => 10,
            'l' => 50,
            'c' => 100,
            'd' => 500,
            'm' => 1000,
        );
        $this->sampStr = $sampStr;
    }

    public function convert(): self {
        $romanString = mb_strtolower($this->sampStr);
        $roman = array();
        $i = 0;
        for ($i; $i < strlen($romanString); $i++){
            $roman[] = array($i => $this->digitVal[ $romanString[$i] ]);
        }

        $adder = 0;
        while (sizeof($roman) != 0) {
            $firstInnerArray = array_shift($roman);

            if (sizeof($roman) == 0){
                $adder += $firstInnerArray[ array_key_first($firstInnerArray) ];
                break;
            }

            $secondInnerArray = array_shift($roman);

            $firstVal = $firstInnerArray[ array_key_first($firstInnerArray) ];
            $secondVal = $secondInnerArray[ array_key_first($secondInnerArray) ];

            echo "first value : $firstVal  secondVal : $secondVal";

            if ($firstVal > $secondVal || $firstVal == $secondVal){
                $adder += $firstVal;
                array_unshift($roman, $secondInnerArray);
            }
            else {
                $adder += ($secondVal - $firstVal);
            }
        }
        $this->intVal = $adder;
        return $this;
    }

    public function print(){
        if ($this->intVal == 0){
            echo "Error occurred";
        }
        echo "The integer form of roman: $this->sampStr is: $this->intVal";
    }
}
