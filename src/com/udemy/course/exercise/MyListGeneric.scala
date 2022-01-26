package com.udemy.course.exercise

import scala.annotation.tailrec

abstract class MyListG[A] { //if +A add method nee to be modified

  /*
  head ==will return first ele of the list
  tail ==remainder of the list
  isEmpty
  add==>int and return a new list with int added
  toString==>string rep of list
   */

  def head():A
  def tail():MyListG[A]
  def isEmpty():Boolean
  def add(ele:A):MyListG[A]
  def toString():String

}
/*
Linkedlist will have only the head pointer and rest of thing is pointed one another until null is reached
ie 1->2->3->4
each element is a object with value and nextEle object reference only head pointer is stored in th mylist object
 */
class LinkedListG[A](var headEle:ElementG[A]=null) extends MyListG[A]{

  override def head(): A = {
    if(headEle !=null) headEle.value
    else throw new NoSuchElementException
  }

  override def tail(): MyListG[A] = {
    /*
    new list will pointing the head nex element address
     */
    if(headEle.nextEle !=null) new LinkedListG(headEle.nextEle)
    else throw new NoSuchElementException
  }

  override def isEmpty(): Boolean = if(headEle == null) true else false

  override def add(ele: A) : MyListG[A] = {
    @tailrec
    def addHelper[A](ele:ElementG[A]): ElementG[A] ={
      if(ele.nextEle == null) ele
      else addHelper(ele.nextEle)
    }
    if(headEle==null) headEle = ElementG(ele,null)
    else {
      addHelper(headEle).nextEle = ElementG(ele,null)
    }
    this
  }

  override def toString: String = {
    @tailrec
    def toStringHelper[A](ele:ElementG[A],acc:String="["): String ={
      if(ele==null) "[]"
      else if(ele.nextEle == null) acc +" "+ ele.toString+ " ]"
      else {
        toStringHelper(ele.nextEle,acc +" "+ ele.toString)
      }
    }

    toStringHelper[A](headEle)
  }

}

class ElementG[A](val value:A,var nextEle:ElementG[A]){ //calss generic
  override def toString: String = this.value.toString
}

object ElementG {
  def apply[A](value:A,nextEle:ElementG[A]):ElementG[A]=new ElementG[A](value, nextEle) //method generic
}

abstract class MyList2G[+A] { //if +A add method nee to be modified

  /*
  head ==will return first ele of the list
  tail ==remainder of the list
  isEmpty
  add==>int and return a new list with int added
  toString==>string rep of list
   */

  def head():A
  def tail():MyList2G[A]
  def isEmpty():Boolean
  def add[B >:A](ele:B):MyList2G[B]
  def toString():String

}

/*
implementation 2 as done in lecture
 */
object EmptyLinkedList2G extends MyList2G[Nothing]{ //empty is taken as item with nothign so here nothing is extended
  override def head(): Nothing = throw new NoSuchElementException

  override def tail(): MyList2G[Nothing] = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

   def add[B>:Nothing](ele: B): MyList2G[B] = new LinkedList2G(ele,EmptyLinkedList2G) //list changes from a nothign to list of type B

  override def toString: String = "[ ]"
}

class LinkedList2G[+A](head:A,tail:MyList2G[A]) extends MyList2G[A]{
  override def head(): A = head

  override def tail(): MyList2G[A] = tail

  override def isEmpty(): Boolean = false

  override def add[B >: A](ele: B): MyList2G[B] = new LinkedList2G[B](ele,this)

  override def toString: String = {
    @tailrec
    def toStringHelper(list:MyList2G[A],acc:String=""): String ={
      if(list.isEmpty()) acc
      else {
        toStringHelper(list.tail(), list.head().toString+" "+ acc)
      }
    }

    "[ "+toStringHelper(this)+"]"
  }
}

