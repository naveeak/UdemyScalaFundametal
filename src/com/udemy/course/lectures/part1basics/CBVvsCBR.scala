package com.udemy.course.lectures.part1basics

object CBVvsCBR extends App{

  def callByValue(x:Long):Unit={//long bc time func returns long
    println("by value "+x) //send once used twice
    println("by value "+x)
  }

  def callByName(x: => Long):Unit={//by  name bc of =>
    println("by name "+x)
    println("by name "+x)
    /*
    similar to
     println("by name "+System.nanoTime())
    println("by name "+System.nanoTime())
     */
  }
  //pass the value into the function
  callByValue(System.nanoTime())//same value print
  //system.nanotime is passed
  callByName(System.nanoTime())//2 diff value


  def infRecursive():Int=1+infRecursive()

  def printFirst(x:Int,y: => Int)=println(x)

  //printFirst(infRecursive(),34) error
  printFirst(34,infRecursive()) //will wprk  ,infRecursive() only executed when it is called ...last execution

}
