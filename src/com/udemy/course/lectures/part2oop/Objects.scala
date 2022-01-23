package com.udemy.course.lectures.part2oop

object Objects extends App{

  //java class level attributes like stsis all the class will be pointing to this statis variable
  //ie value that constant across all instance is placed in static placing ,will not consume ectra space for every instanized

  //scala doesn't know concept of static
  //equivalent for that is object in scala
  //object can also have methods
  //object will not received parameter for construction
  //scala object is a singleton instance
  //object are only instance of the objname

  object Person{
    val N_EYES=2
    def canFlag =false

    def from(mthr:Person,father:Person)=new Person("baby")
    def apply(mthr:Person,father:Person)=new Person("baby")
  }

  println(Person.N_EYES)
  println(Person.canFlag)

  val mery=Person
  val john=Person
  println(mery==john) //true single this 2 variable points to the same instance
  println(mery.N_EYES)

  //singleton by definition

  //we can write same class for the object
  //object have non varing variable ie static variable
  //if we have both pbject and class with same is called companion class

  class Person(val name:String){ //companion class

  }

  val mery2=Person //will point to person object
  val john2=Person
  println(mery2==john2)
  val mery1=new Person("mery") //will instanize a new object of person
  val john1=new Person("john")
  println(mery1==john1) //2 diff instance is createde
  println(mery.N_EYES)

  val baby=Person.from(mery1,john1) //factory method crating a object
  val baby1=Person(mery1,john1) //inferred as Person.apply(person1,person2)

  //scala application is a scala object  with main function
  //in java to start a application you must have a public static void main method
  //equivalently in scala static means in Object ,a method main must present in object not in class



}
