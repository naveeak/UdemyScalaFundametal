package com.udemy.course.exercise

object traitExercise extends App{
  /*
  1. generic trait mypredicate[-T] ===. will have a method to test val typr t passes that condition
  2.generic trait transformer[-a,b] ===> method that convert type a to type b
  3.change in my list
    -map(transformer) ===>mylist of diff type
    -filter(prdicate) ===>mylist
    -flatmap(transfomer a to mylist[b]) ===>mylist[b]
   */

  trait MyCollection[+A]{
    def head():A
    def tail():MyCollection[A]
    def isEmpty():Boolean
    def add[B >: A](ele:B):MyCollection[B]
    def toString():String
    def map[B](transformer:MyTransformer[A,B]):MyCollection[B]
    def flatMap[B](transformer:MyTransformer[A,MyCollection[B]]):MyCollection[B]
    def filter(predicate: MyPredicate[A]):MyCollection[A]
    def ++[B >: A](myCollection: MyCollection[B]):MyCollection[B]
  }

  object EmptyList extends MyCollection[Nothing]{
    override def head(): Nothing = throw new NoSuchElementException

    override def tail(): MyCollection[Nothing] = throw new NoSuchElementException

    override def isEmpty(): Boolean = true

    override def add[B >: Nothing](ele: B): MyCollection[B] = new List[B](ele,EmptyList)

    override def toString: String = "[ ]"

    override def map[B](transformer: MyTransformer[Nothing, B]): MyCollection[B] = EmptyList

    override def flatMap[B](transformer: MyTransformer[Nothing, MyCollection[B]]): MyCollection[B] = EmptyList

    override def filter(predicate: MyPredicate[Nothing]): MyCollection[Nothing] = EmptyList

    def ++[B>:Nothing](myCollection: MyCollection[B]):MyCollection[B]=myCollection
  }

  class List[+A](val headEle:A,val tailList:MyCollection[A]) extends  MyCollection[A]{
    override def head(): A = headEle

    override def tail(): MyCollection[A] = tailList

    override def isEmpty(): Boolean = false

    override def add[B >: A](ele: B): MyCollection[B] = new List[B](ele,this)

    override def toString: String = {
      def toStringHelper(List:MyCollection[A],acc:String=""):String={
          if(List.isEmpty()) acc
          else toStringHelper(List.tail(),acc+" "+List.head().toString)
      }
      "[ "+toStringHelper(this)+" ]"
    }

    override def map[B](transformer: MyTransformer[A, B]): MyCollection[B] = {
      new List(transformer.transform(headEle),tailList.map(transformer))
    }

    override def flatMap[B](transformer: MyTransformer[A, MyCollection[B]]): MyCollection[B] = transformer.transform(headEle) ++ tailList.flatMap(transformer)

    override def filter(predicate: MyPredicate[A]): MyCollection[A] = {
      if(predicate.isPasses(headEle))  new List(headEle,tailList.filter(predicate))
      else tailList.filter(predicate)
    }

    def ++[B>:A](myCollection: MyCollection[B]):MyCollection[B]=new List[B](headEle,tailList.++(myCollection))
  }

  var myList4:List[Int]= new List(1,new List(2,new List(3,EmptyList)))
  var myList5:List[String]= new List("one",new List("two",new List("three",EmptyList)))
  println(myList4)
  println(myList5)

  println(myList4.map(new MyTransformer[Int,Int] {
    override def transform[B <: Int](data: B): Int = data*5
  }))

  println(myList4.filter(new MyPredicate[Int] {
    override def isPasses[B <: Int](data: B): Boolean = {
      data % 2 == 0
    }
  }))

  println(myList4.flatMap(new MyTransformer[Int,MyCollection[Int]] {
    override def transform[B <: Int](data: B): MyCollection[Int] = new List[Int](data,new List[Int](data*2,EmptyList))
  }))


}

trait MyPredicate[-A]{
  def isPasses[B <: A](data:B):Boolean
}

trait MyTransformer[-A,T]{
  def transform[B<:A](data:B):T
}