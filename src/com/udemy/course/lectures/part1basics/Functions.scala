package com.udemy.course.lectures.part1basics

object Functions extends App{

  def fun(a:String,b:Int):String={
    a+" "+b
  }
  println(fun("a",4))

  def paramanterlessFunc():Int=42
  println(paramanterlessFunc()) //works
  println(paramanterlessFunc) //also works

  def repeatedFunc(a:String,b:Int):String={
    if(b == 1) a
    else a +" "+ repeatedFunc(a,b-1)
  }

  println(repeatedFunc("hello",4))
  //if loops need use recursive

  def fun1(a:String,b:Int)={
    a+" "+b
  } //return doesn't need to be specified
  //but in recursive func,return type can't be inferred

  def funct2(a:String):Unit={
    println(a)
  }
  println(funct2("hello"))

  //code block can also have a another function

  def nestedFunct()={
    println("nested function called")
    def innerFun()={
      println("inner fucntion called ")
    }
    innerFun()
  }
  nestedFunct()

  //1.2 paramater name ans age ==> "hi my name is $name and i am $age"
  //factorial 1"2*3*n
  //fibonacci 1,1,2,3,5......
  //if number is prime

  def func2(name:String,age:Int)=println(s"Hi my name is $name and i am $age ")
  func2("ak",22)

  def factorial(n:Int):Int={
    if(n<=0) 1
    else n*factorial(n-1)
  }

  println(factorial(3))

  def fibonacci(n:Int):Int={
    if(n<=2) 1
    else fibonacci(n-2)+fibonacci(n-1)
  }

  println(fibonacci(5))

  def primeIdentifier(n:Int):Boolean={
      def isDivisible(d:Int):Boolean={
        if(d==1) false
        else n%d==0 | isDivisible(d-1)
      }
    if(n!=2 && n%2==0) false
    else !isDivisible(n/2)
  }

  println(primeIdentifier(97))


}
