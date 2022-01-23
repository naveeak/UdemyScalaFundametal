package com.udemy.course.lectures.part2oop

object InheritanceTraits extends App{
  //scala onyl has single class inheritance
  //only can extends one member

  class Animal{
    val creatureType ="wild"
    def eat = "nom nom nom" //default public
    private def eat1 = "nom nom nom1" //not accesible in subclass
    protected  def eat2 = "nom nom nom2"//only in subclass and in this class
  }

  class Cat extends Animal{
    def accessingProtectedFunc()={
      eat2
      //eat1//error
    }
  }  //only inheritate nonprivate member
  //private non accessable in subclass
  //protected subclass and own class

  val cat = new Cat //subclass of animal
  //animal is a superclass of cat
  println(cat.eat)
 // println(cat.eat1) error
  //println(cat.eat2) error
  println(cat.accessingProtectedFunc)

  class Person(name:String,age:Int){
    def this(name:String)={
      this(name,0)
    }
  }
  //class Adult(name:String,age:Int,Id:String) extends Person //error
  //subclass need to call the parent class constructor
  class Adult(name:String,age:Int,Id:String) extends Person(name,age)
  class Adult1(name:String,age:Int,Id:String) extends Person(name) //this is possibel bc the similar signatured constructor is present in the person class

  //overridding
  class Dog extends Animal{
    override val creatureType: String = "domestic"
    override def eat ="crunch crunch" + super.eat //grtting superclass method and include here
  }

  val dog =new Dog
  println(dog.eat)
  println(dog.creatureType)

  class Dog1(override val creatureType:String) extends Animal{ //we can overrride like this
    //override val creatureType: String = "domestic"
    override def eat ="crunch crunch"
  }

  val dog1 =new Dog1("home")//override value dynamically
  //we can also pass a value to constructor and override in block ie
  /*
   class Dog1( val creatureTypemodifier:String) extends Animal{ //we can overrride like this
    override val creatureType: String = creatureTypemodifier
    override def eat ="crunch crunch"
  }
   */
  println(dog1.eat)
  println(dog1.creatureType)

  //type substitution
  val unknown:Animal= new Dog1("k9")//polymorphism
  println(unknown.eat)//gives override value not animals method return only to the most overriden value

  //overriding changing method definition in subclass
  //overloading multiple method with diff signature

  //super

  //pereventing overrriding
  //use final in method and variable
  //if class is final it can't be inherited
  //seal the class means that extending the class is possible in same only on same file not in other file used in creating a enum




}
