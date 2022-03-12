package com.udemy.course.lectures.part2oop

object AnonymousClass extends  App{

  abstract class Animal{
    def eat:Unit
  }

  //Anonymous class
  //on the spot implementation
  val funny:Animal =new Animal{//we created instance on abstract class how ? no we are defining ths class in below code block
    //ie it becomes a class that extends animal but without any name
    //class AnonymousClass$$anon$1 extends Animal{code in code block} automatically inferred
    override def eat = println("ha ha ha ")
  }

  funny.eat
  println(funny) //Anonymous class

  class Person(name:String){
    def sayHi=println(s"Hi i am ${name}")
  }

  ///pass parameter to the super class

  //we can change that for only one instance too
  //both class and abstract class supports anynonmous extending
  val jim = new Person("jim"){
    override def sayHi: Unit = println("i am going to say hi in a different way HIIIIIIII!!")
  }

  jim.sayHi
  val normal=new Person("john")
  normal.sayHi
}
