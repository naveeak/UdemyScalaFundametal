package com.udemy.course.exercise

import com.udemy.course.exercise.Test.myList

object Test extends App{
  val myList= new LinkedList()
  println(myList)
  println(myList.isEmpty())
  myList.add(1)
  myList.add(2)
  myList.add(3)
  myList.add(4)
  println(myList)
  println(myList.headEle)
  println(myList.tail())
  println(myList.isEmpty())
  myList.add(4).add(5).add(6).add(7)
  println(myList)
  println(myList.headEle)
  println(myList.tail())
  println(myList.isEmpty())

  var myList2:MyList= new LinkedList2(1,EmptyLinkedList2)
  println(myList2)
  println(myList2.isEmpty())
  myList2 = myList2.add(1)
  myList2.add(2) //will be added since we are adding results in a new instnace hwich is  not assigned to the same list MyList
  myList2.add(3)
  myList2.add(4)
  println(myList2)
  println(myList2.head)
  println(myList2.tail())
  println(myList2.isEmpty())
  myList2 = myList2.add(4).add(5).add(6).add(7)
  println(myList2)
  println(myList2.head)
  println(myList2.tail())
  println(myList2.isEmpty())


}
