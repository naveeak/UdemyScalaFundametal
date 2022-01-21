package com.udemy.course.lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App{

  def newFactorial(n:Int):BigInt={
    @tailrec //if func not tailrecursive then complier will throw a error
    def factHelper(x:Int,acc:BigInt=1):BigInt={
      if (x<=1) acc
      else factHelper(x-1,x*acc)
    }
    //factHelper(n,1)//without specifying 1 use default parameter
    factHelper(n)
    //factHelper(n,12) also possible
  }

  println(newFactorial(3))


  def savePicture(format:String="jpg",width:Int=1920,height:Int=1080)=print("saving picture")
  //since leading paramter is default complier will confuse
  //savePicture(800,700) //error
  savePicture() //will work
  //savePicture(800)//error
  savePicture(width = 800)
  savePicture(width = 900,height = 900,format = "jpeg")

  /*
   name every parameter
   or pass all the prefix parameters(leading)
   or place the default parameter last
   */

}
