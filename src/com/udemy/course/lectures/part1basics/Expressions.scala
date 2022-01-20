package com.udemy.course.lectures.part1basics

object Expressions extends App{

  val x=1+2 //1+2 is expression evaluate to 3 (int is auto inferred)
  println(2+3*4) //as bodmas
  //order + - * /& ....

  println(1==x)
  //relational operation == != > >= < <=

  println(! (1 == x) ) //!1==x not works ! 1 ==x not works
  //! && ||

  var v =2
  v +=2//works //side effects

  println(v)

  //instruction (DO it kind of order)  vs expression (associate with value)

  //if  is expression but not in java if is instruction
  val a =true
  val b = if (a) 5 else 3 //if return a value whereas java it eill not return
  println(b)
  println(if (a) 5 else 3) //since if is expression we can use it inside a println

  //loops are not recommended as loops only produce side effect
  var i=0
  while(i<10){
    print(i)
    i += 1 //i++ will not work
  }//never use again

  //everything in scala is expression

  val weird = (v=3) //expression v=3 returns unit which is assigned to weird
  println(weird) //returns ()

  //reassigning vales are side effects which returns unit
  //example while, assgning variables,println()
  //in scala side effects are still expression but return unit

  //code blocks

  val codeBlock ={
    val x=10
    val z=x+1
    if (z>1) "hello" else "bye " //this last line is the expression
    //this is a code block   {}entire thing inside this is expression but code blocks can have
    //owm variable which accessible only inside code block not in global scope
  }

  println(codeBlock)

  //diff bt string "hello world"==>string not expression and println("hello world")==> returns unit,side effect
  //value of
  val t ={3>2} //true
  val u= {//returns 42
    if(t) 239 else 900
    42
  }

  println(u)



}
