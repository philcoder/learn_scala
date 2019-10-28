package com.philipp.ch12

import com.philipp.ch12.model.adv.{BasicIntQueue, Doubling, Filtering, Incrementing, Logging, MyQueue}
import com.philipp.ch12.model.basic.{Point, Rectangle}

/**
 Guide lines for trait or not trait:
    -If the behavior will not be reused, then make it a concrete class.
    -If it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into
different parts of the class hierarchy.
    -If you want to inherit from it in Java code, use an abstract class. Since traits with code do not have a
close Java analog, it tends to be awkward to inherit from a trait in a Java class.
    -If you plan to distribute it in compiled form, and you expect outside groups to write classes inheriting
from it, you might lean towards using an abstract class.
    -If you still do not know, after considering the above, then start by making it as a trait.
 */
class Solution {
  def exec()={
    advanced()
  }

  private def advanced()={
    def normalObj()={
      val queue = new BasicIntQueue
      queue.put(10)
      queue.put(20)
      queue.put(15)

      println(s"--- $currentMethodName ---")
      println(queue.get())
      println(queue.get())
    }

    def myQueueWithDoubleTrait()={
      val queue = new MyQueue
      queue.put(10)
      queue.put(-20)
      queue.put(15)

      println(s"--- $currentMethodName ---")
      println(queue.get())
      println(queue.get())
    }

    def stackTraitDynamic() ={
      val queue = new BasicIntQueue with Doubling
      queue.put(10)
      queue.put(20)
      queue.put(15)

      println(s"--- $currentMethodName ---")
      println(queue.get())
      println(queue.get())
    }

    def stackTraits() ={
      //the execution override order is the most right place to left (seq: Logging, Filtering, Incrementing and last Doubling)
      //this execution process is called linearization of class
      val queue = new BasicIntQueue with Doubling with Incrementing with Filtering with Logging
      queue.put(10)
      queue.put(-20)
      queue.put(15)

      println(s"--- $currentMethodName ---")
      println(queue.get())
      println(queue.get())
    }

    normalObj
    myQueueWithDoubleTrait
    stackTraitDynamic
    stackTraits
  }

  private def basic() ={
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(rect.width)
  }

  //third elem on stack trace
  private def currentMethodName() : String = Thread.currentThread.getStackTrace()(2).getMethodName.replace("$1","")
}
