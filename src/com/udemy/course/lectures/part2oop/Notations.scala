package com.udemy.course.lectures.part2oop

object Notations extends  App{

  class Person(val name:String,val favoriteMovie:String,val age:Int=18){
    def likes(movie:String):Boolean= movie equals favoriteMovie
    def hangoutWith(person:Person):String=s"${this.name} is with ${person.name}"
    def +(person:Person):String=s"${this.name} is with ${person.name}"
    def +(add:String):Person=new Person(s"$name $add",favoriteMovie)
    def unary_! :String = s"what the heck"
    def isAlive:Boolean=true
    def apply():String= "Hi i am AK"
    def unary_+ :Person=new Person(name, favoriteMovie, age+1)
    def learns(sub:String):String = s"$name learns $sub"
    def learnsScala:String = learns("scala")
    def apply(n:Int)=s"$name watched $favoriteMovie $n times"
  }

  val merry=new Person("meeeerry","interstellar")
  println(merry.likes("s3"))
  println(merry likes "interstellar")
  //syntatic sugar
  //infix notation or operator notation onyl works with methods with one parameter
  //"operator notation"

  val jerry=new Person("jerry","interstellar")
  println(merry hangoutWith jerry)  //here hangout is like a operator +,-,/,*
  println(merry + jerry) //+ is a method valid marry.+(jerry) ie 1+2 is similar to 1.+(2)

  //akka has ! ?
  //prefix notation unary operator
  val x = -1
  val x_equivalent = 1.unary_- //similar to -1
  println(1.unary_~)
  //uninary only works with [- + ! ~]
  //you can call a method in a class with unary_! as !classobj
  // 1.unary_- unary_- is a method we can call it by -1

  println(!merry) //or merry.unary_!

  //postfix notation
  //only works with methods without parameter
  println(merry.isAlive)
  //equivalent to
  println(merry isAlive)

  //apply
  //no paramter apply method
  //we don't need to specify a fun apply to call ie obj() will call the apply function
  println(merry.apply())
  println(merry()) //similar to  merry.apply()

  /*
 1.overload + with "the rocker star" ==. new person(name+rockerstart)
 2.+merry onel age is increment age+1
 3.add a learn method in the class do person learns scala add another fun and call it by postfix
 4. apply method receive a number returns string

   */

  println((merry + "rock").name) //method overloading with diff method signature
  println((+merry).age)
  println(merry learnsScala)
  println(merry(3))//merry.apply(3)
}
