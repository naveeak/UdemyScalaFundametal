package com.udemy.course.exercise

import scala.annotation.tailrec

abstract class MyList {

  /*
  head ==will return first ele of the list
  tail ==remainder of the list
  isEmpty
  add==>int and return a new list with int added
  toString==>string rep of list
   */

  def head():Int
  def tail():MyList
  def isEmpty():Boolean
  def add(ele:Int):MyList
  def toString():String

}
/*
Linkedlist will have only the head pointer and rest of thing is pointed one another until null is reached
ie 1->2->3->4
each element is a object with value and nextEle object reference only head pointer is stored in th mylist object
 */
class LinkedList(var headEle:Element=null) extends MyList{

  override def head(): Int = {
    if(headEle !=null) headEle.value
    else throw new NoSuchElementException
  }

  override def tail(): MyList = {
    /*
    new list will pointing the head nex element address
     */
    if(headEle.nextEle !=null) new LinkedList(headEle.nextEle)
    else throw new NoSuchElementException
  }

  override def isEmpty(): Boolean = if(headEle == null) true else false

  override def add(ele: Int): MyList = {
    @tailrec
    def addHelper(ele:Element): Element ={
      if(ele.nextEle == null) ele
      else addHelper(ele.nextEle)
    }
    if(headEle==null) headEle = Element(ele,null)
    else {
      addHelper(headEle).nextEle = Element(ele,null)
    }
    this
  }

  override def toString: String = {
    @tailrec
    def toStringHelper(ele:Element,acc:String="["): String ={
      if(ele==null) "[]"
      else if(ele.nextEle == null) acc +" "+ ele.toString+ " ]"
      else {
        toStringHelper(ele.nextEle,acc +" "+ ele.toString)
      }
    }

    toStringHelper(headEle)
  }

}

class Element(val value:Int,var nextEle:Element){
  override def toString: String = this.value.toString
}

object Element {
  def apply(value:Int,nextEle:Element):Element=new Element(value, nextEle)
}

/*
implementation 2 as done in lecture
 */
object EmptyLinkedList2 extends MyList{
  override def head(): Int = throw new NoSuchElementException

  override def tail(): MyList = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

  override def add(ele: Int): MyList = new LinkedList2(ele,EmptyLinkedList2)

  override def toString: String = "[ ]"
}

class LinkedList2(head:Int,tail:MyList) extends MyList{
  override def head(): Int = head

  override def tail(): MyList = tail

  override def isEmpty(): Boolean = false

  override def add(ele: Int): MyList = new LinkedList2(ele,this)

  override def toString: String = {
    @tailrec
    def toStringHelper(list:MyList,acc:String=""): String ={
      if(list.isEmpty()) acc
      else {
        toStringHelper(list.tail(), list.head().toString+" "+ acc)
      }
    }

    "[ "+toStringHelper(this)+"]"
  }
}

