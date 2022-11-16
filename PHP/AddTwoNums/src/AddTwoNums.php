<?php
namespace org\horbola\leetcode\php\addtwonums;

include "Node.php";
include "LinkedList.php";

use org\horbola\leetcode\php\addtwonums\Node;
use org\horbola\leetcode\php\addtwonums\LinkedList;



class AddTwoNums
{
    public $arr1;
    public $arr2;
    public $list1;
    public $list2;
    public $result;

    public function __construct($arr1, $arr2)
    {
        $this->arr1 = $arr1;
        $this->arr2 = $arr2;
    }


    public function add(){
        $list1 = LinkedList::arrayToList($this->arr1);
        $list2 = LinkedList::arrayToList($this->arr2);

        $num1 = $list1->extractReverse();
        $num2 = $list2->extractReverse();

        $this->result = $num1 + $num2;
        return $this;
    }

    public function print(){
        if ($this->result == null)
            echo "Error occurred";
        else
            echo "The result of the two numbers is: $this->result";
    }
}

