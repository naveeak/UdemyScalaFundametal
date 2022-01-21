package com.udemy.course.lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorial(n:Int):Int={
    if(n<=0) 1
    else {
      println(s"on func call of $n need ${n-1}")
      val result=n*factorial(n-1)
      println(s"release stack variables $n")
      result
    }
  }
 println(factorial(10))
  //println(factorial(10000)) //stackoverflow error

  //recursive func call is placed ina stack frame it is limited can get stack overflow error

  def newFactorial(n:Int):BigInt={
    @tailrec //if func not tailrecursive then complier will throw a error
    def factHelper(x:Int,acc:BigInt):BigInt={
      if (x<=1) acc
      else factHelper(x-1,x*acc)
    }
    factHelper(n,1)
  }

  //println(newFactorial(20000))//not crash why ?

  //works because scala doesn't need to save the intermediate result in a stack but here since here it free to
  //clear existing intermediatory doesn't fails
  //ie current function call is completed in the after else so complier will not store it in stack
  //this type of function is tail recursive

  //if loop needed use tail recursive

  /*
  1.concatenate string in n times
  2.isprime tailrecursive
  3.fibonacci function tail recursice
   */

  def strCon(s:String,n:Int):String={
    @tailrec
    def strConHelper(n:Int,acc:String):String={
      if(n==0) acc
      else strConHelper(n-1,acc+s)
    }

    strConHelper(n,"")
  }

  println(strCon("s",7))

  def primeIdentifier(n:Int):Boolean={
    @tailrec
    def isNotDivisible(d:Int,acc:Boolean):Boolean={
      if(d<=1) acc
      else isNotDivisible(d-1,acc && n%d != 0)
    }
    if(n!=2 && n%2 ==0) false
    else isNotDivisible(n/2,true)
  }

  println(primeIdentifier(97))

  //fibonacci tail recursive

  def fibonacci(n:Int):Int={
    @tailrec
    def fibonacciHelper(index:Int,acc:Int,acc1:Int ):Int={
      if(index >= n) acc1
      else fibonacciHelper(index+1 , acc1 , acc+acc1)
    }
    fibonacciHelper(1,0,1)
  }

  println(fibonacci(8))

}
