package com.udemy.course.lectures.part2oop

object OOPractise extends App{

  val writer=new Writer("john","johnsnm",1978)
  println(writer.fullName)
  println(writer.equals(writer))
  println(writer.equals("test"))
  println(writer.equals(new Writer("john","johnsnm",1979)))

  val novel =new Novel("test",1990,writer)
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(new Writer("john","johnsnm",1979)))
  println(novel.authorAgeAtRelease())
  println(novel.createNewRelease(1992))

  val counterobj=new counter()
  println(counterobj.count)
  //counterobj.count.pri
  val counterobj1=new counter(10)
  println(counterobj1.count)
  println(counterobj1.decrement.count)
  println(counterobj1.increment.count)
}
/*
novela nd writer class
writer 1 name ,surename yob,full name (method ==?1 and sure naem
name yor author(writer)  age of author at release
is written by author
copy new of year  ==> new year of relaease with new yor

 */
/*
counter class
rcv a int
count methid
method to increment and decrement by 1==return a new counter
overload inc and dec counter methid ==> new counter
 */

class Writer( val firstName:String,val sureName:String,val yob:Int){ //without val program fail
  def fullName = s"$firstName $sureName"

  override def equals(obj:Any):Boolean={
    obj match{
      case o:Writer => this.firstName.equals(o.firstName) && this.sureName.equals(o.sureName) && this.yob==o.yob
      case _ => false
    }
  }
}

class Novel(val name:String,val yor:Int,val writer:Writer){

  def isWrittenBy(writer:Writer):Boolean={
    this.writer.equals(writer)
  }

  def createNewRelease(year:Int):Novel={
    new Novel(this.name,year,this.writer)
  }

  def authorAgeAtRelease():Int={
    this.yor - this.writer.yob
  }
}

class counter(val count:Int=0){
  def increment(value:Int):counter = new counter(this.count+value)
  def decrement(value:Int):counter = new counter(this.count-value)
  def increment:counter=increment(1)
  def decrement:counter=decrement(1)
}




