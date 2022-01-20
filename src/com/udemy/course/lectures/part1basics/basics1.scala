package com.udemy.course.lectures.part1basics

object basics1 extends App{
  //basics of types and variable
  val x:Int =41
  val y=42 //types are optional  can be infered
  println(x)
  //x=2  val are immutable

  val s:String ="Hello"
  println(s)

  val r:Boolean= false //reserved variable false ,true
  val c:Char ='a' //inisde sinle quote
  val sh:Short=1245 //only small numbers
  val l :Long = 28374982738497L//can be longer but not much .need to end with L to represent as long
  val f: Float =6.6F //if F not mentioned it will double
  val d : Double =33.555

  var v:Int=5
  v=10 //can be altered //side effects


}
