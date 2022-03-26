package com.biancheng4.ch7

//简单的for
object For_Simple {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("a", "b", "c", "d")
    val arrays: Array[Int] = Array(1, 2, 3, 4)
    //集合
    for (temp <- list) {
      print(s"$temp ")
    }
    println()
    //数组
    for (temp <- arrays) {
      print(s"$temp ")
    }
    println()
    //范围
    for (temp <- 20 to 25) {
      print(s"$temp ")
    }
    println()
    //范围
    for (temp <- 30 until 35) {
      print(s"$temp ")
    }
    println()

  }

}
