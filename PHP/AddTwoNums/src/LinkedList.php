<?php

namespace org\horbola\leetcode\php\addtwonums;

class LinkedList
{
    public $head;

    public function __construct()
    {
        $this->head = null;
    }


    public static function arrayToList(array $listItems){
        $list = new self();
        $prevList = null;

        foreach ($listItems as $key => $val){
            if ($key == 0){
                $node = new Node();
                $node->data = $val;
                $prevList = $node;
                $list->head = $node;
            }
            else {
                $node = new Node();
                $node->data = $val;
                $prevList->next = $node;
                $prevList = $node;
            }
        }
        return $list;
    }

    public function pushBack($newElem){
        $newNode = new Node();
        $newNode->data = $newElem;

        if ($this->head == null){
            $this->head = $newNode;
        }
        else {
            $temp = $this->head;
            while ($temp->next != null){
                $temp = $temp->next;
            }
            $temp->next = $newNode;
        }
    }

    public function extractReverse(){
        $digitString = '';
        if ($this->head != null){
            $digitString = $this->head->data;
            $temp = $this->head;

            while ($temp->next != null){
                $temp = $temp->next;
                $digitString = $temp->data.$digitString;
            }
        }
        return $digitString;
    }
}
