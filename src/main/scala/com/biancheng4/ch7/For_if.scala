package com.biancheng4.ch7

object For_if {

  def main(args: Array[String]): Unit = {
    //简单的if过滤
    for (i <- 1 to 10 if i % 2 == 0) {
      print(s"$i ")
    }
    println()
    for (i <- 1 to 10 if i % 2 == 0 && i % 3 == 0) {
      print(s"$i ")
    }
    println()
    //多个if过滤
    for (i <- 1 to 10 if i % 2 == 0 if i % 3 == 0) {
      print(s"$i ")
    }
    println()
  }

}
