package com.udemy.course.lectures.part2oop

object CaseClasses extends App{

  /*
  need to implement all teh class equals hashcode etc
  boilerplate code avoidance
   */

  case class Person(name:String,age:Int)

  //1.class paramters are fields  person.name is accessa-ible ie if class Person(name:String,age:Int) the it is not
  val jim = new Person("Jim",10)
  println(jim.name)
  //2.Sesnsible to string
  println(jim)
  //equals anh hascode already implemented
  val jim2 = new Person("Jim",10)
  println(jim == jim2)

  val jim3 =jim.copy(age=45) //will be same as jim but diff age
  println(jim3)

  //inbuilt companion object
  val thePerson = Person
  val marry = Person("marry",23) //companion object apply will be behave same as constructor
  //no need to have new while creating case class

  //case class are serializable
  //used in akka

  //case class have extractor pattern
  //used in pattern matching

  case object UnitedKingdom {
    def name :String = "dummy"
  } //similar to case class but no companion object

  /*
  expand mylist use case class whenever possible
   */


}
