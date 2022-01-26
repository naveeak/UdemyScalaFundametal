package com.udemy.course.lectures.part2oop

import com.udemy.course.lectures.part2oop.AbstractDataType.Carnivore

object Generics extends  App{
  //wed create a linkedlist for int but what if we need to create for strings we need to create a entire new class
  //but generic came to recue

  //generic class
  class MyList[A] {
    //we can use the type A
  }
  trait MyList1[A] {//trait can also be used
    //we can use the type A
  }

  class MyMap[key,value]{
    //key and value are generic types
  }
  val listOfIntegers=new MyList[Int]
  val listOfStrings=new MyList[String]

  //generic methods
  object MyList{

    //generic methods
    def empty[A]:MyList[A]=new MyList[A]  //with generic the methods can get the type parameter and pass it to a class another method
    //and can also be used to return the type parameter
  }

  val emptyListOfInter=MyList.empty[Int] //list of integer

  //variance problem

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //list[cat] extnds list[animal] ===>Covariance denoted by +A
  class Covariant[+A]
  val animal:Animal =new Cat //covariant
  val animalList:Covariant[Animal] =new Covariant[Cat] //covariant

  //but can we add dog to this list animalList.add(new Dog),,,,yes we can since dog also subclass of animal but it will pollute the list of cats
  //we shouldn't ,we can useinvariant list===>denoted by A
  class Invariant[A]
  //val invariantList:Invariant[Animal]=new Invariant[Cat]//error
  val invariantList:Invariant[Cat]=new Invariant[Cat] //both the place the datatype must be same

  //hell no
  //contravariant denoted by -A
  class Contravariant[-A]
  val contravariantList:Contravariant[Cat] = new Contravariant[Animal] //but this counter inititutive because all animal are not cats

  //but contravariant is suited in this example not above example
  class Trainer[-A]
  val trainer:Trainer[Cat]=new Trainer[Animal] //trainer is animal trainer but he can also train cat
  //usefull in the above scenario


  /*
  bounded types
   */
 //cage can only hold animal so cage class will accept onyl the subtype of animal [<: Animal]
  class Cage[A <: Animal](animal :A)
  val cage  = new Cage[Dog](new Dog)

  class Car
  //val cageOfCar= new Cage[Car](new Car) //error since car not a subclass of animal ie car is not a animal

  //bounded class solves the covariance problem

  class MyList2[+A]{
    //def add(ele:A):MyList[A] = ??? //throws error bc complier not sure it can add dog or cat in animal type
    //to tell it can we have to implement as below
    def add[B >:A](ele:B):MyList[B] = ??? //B is super type of A
    /*
    A= cat             initially it is a list of cat [list of animal internally]
    B =dog [animal]       but once we add dog it become a generic list of animal type B
     */
  }

  /*
  expand mylist to generic
   */

}
