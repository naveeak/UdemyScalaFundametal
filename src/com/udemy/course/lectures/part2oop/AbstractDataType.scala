package com.udemy.course.lectures.part2oop

object AbstractDataType extends App{
  //abstract class are class contain unimplemented methods,variable and class for future implementation
  //can't be instanized

  abstract  class Animal {
    val creaturetype:String="Animal"
    def eat:Unit
  }

  //val ani= new Animal //error
  class Dog extends Animal{
    override val creaturetype: String = "k9"

    override def eat: Unit = println("crunch crunch ") //override keyword not needed but better to include

  }

  //trait
  //multiple trait can be impleted to one class
  //can have unimlemented methods
  trait Carnivore{
    val test="can have defined variable"
    def eat(animal:Animal):Unit
  }

  trait coldBlood
  class Crocodile extends Animal with Carnivore with coldBlood {
    override val creaturetype: String = "k10"

    override def eat: Unit = println("kach kach")

    override def eat(animal: Animal): Unit = println(s"i am a carnivore and i am eating ${animal.creaturetype}")
  }

  val croc =new Crocodile
  val dog=new Dog

  croc.eat(dog)

  //trait vs abstract
  /*
  abstract can have both abstract and implemented so as traits too
  1.traits can't have constructor paramter but abstract class can
  2.multiple trait inheritance is possible,but only one abstract class
  3.traits are behavior like carnivore,coldblooded ,abstract about common name

   */

  /*
  scala.Any --->scala.AnyRef(list,string,set)---->scala.Null  <_________|
  |______>scala.AnyVal(int float,Boolean,Float)----------->scala.Nothing

  1.null can be pointed to any instance
  2.nothing caan even point to null pointer
  3.nothing can be used everywhere
   */
}
