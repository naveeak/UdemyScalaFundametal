package com.udemy.course.lectures.part1basics

object StringOps extends  App{
  val str="Hello  i am AK"
  println(str.charAt(2))
  println(str.substring(2,3))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("i","I"))
  println(str.toLowerCase())
  println(str.length) //takes not parameter so no .length()

  val a ="45"
  val b=a.toInt
  println("a":+a) //:+ appending +: prepending
  println(a+:"a")
  println(str.reverse)
  println(str.take(2)) //take first 2 letter subsctring liuke


  //s interpolated
  val name ="AK"
  val age = 12
  val greeeting = s"hello , i am $name and i am $age and i can do ${age+1}" //inside ${} inside thia we can write a expression
  println(greeeting)

  //f interpolator printf like format
  val speed =1.2f
  val myth = f"$name%s can eat $speed%2.2f idle"
  println(myth) //will print out 1.20 bc of 2.2f
  //2.2f means atleast 2 char or 2 decimal percision
  //%3d int
  //we can use it for type correctness


  //raw interpolator
  println(raw"this newline not printed \n test")
  val s="this newline not printed \n test"
  println(raw"$s") //here new line is printed


}
