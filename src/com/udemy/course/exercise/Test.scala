package com.udemy.course.exercise

import com.udemy.course.exercise.Test.myList

object Test extends App{
  val myList= new LinkedList()
  println(myList)
  myList.add(1)
  myList.add(2)
  myList.add(3)
  myList.add(4)
  println(myList)
  println(myList.headEle)
  println(myList.tail())
  println(myList.isEmpty())


}
