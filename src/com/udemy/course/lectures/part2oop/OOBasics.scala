package com.udemy.course.lectures.part2oop

object OOBasics extends App{

  val person =new Person("john",26) //actual person
  println(person)
 // println(person.age) //error
 val person1 =new Person1("john",26) //actual person
  println(person1.age)

  val person2 =new Person2("john",26) //actual person
  println(person2.x)
  person2.greet("Dany")
  person2.greet


}
//template of a entity
class Person(name:String,age:Int) //definition plus constructor can access  age by personobj.age
//above class name and age are paramter not fields to make it fields use as like below

class Person1(name:String,val age:Int) //definition plus constructor
//now age is field not parameter

class Person2(name:String,val age:Int =0){ //instead of multiple constructor you can do this
  val x=10 //field
  println("person class is instanized") //evaluated while instanizing the class
  //methods
  def greet(name:String)={
    //using only name take only passed vale
    //use this.name for access objects name
      println(s"HI $name by ${this.name}")
  }

  //overloading method  with methods parameter type set ie diff signature  but also return type
  def greet={
    println(s"HI $name by ${this.name}") //here no method parameter as name so objects name is infered
  }

  //multiple constructor
  def this(name:String)={
    this(name,0) //this must be another constructor
  }

  def this()=this("hi") //instead of this apply the default parameter to the main class definition
}

/*
novela nd writer class
writer 1 name ,surename yob,full name (method ==?1 and sure naem
name yor author(writer)  age of author at release
is written by author
copy new of year  ==> new year of relaease with new yor

 */
/*
counter class
rcv a int
count methid
method to increment and decrement by 1==return a new counter
overload inc and dec counter methid ==> new counter
 */

