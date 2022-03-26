package com.biancheng4.ch7

object For_nested {

  def main(args: Array[String]): Unit = {
    //for语句嵌套
    for (i <- 1 until 100 if i % 10 == 0; y <- i until i + 10 if y % 3 == 0) {
      print(s"$y ")
    }

    println()
    //for语句嵌套,并且中途插入变量
    for {
      i <- 1 until 100
      if i % 10 == 0
      y <- i until i + 10
      y1 = s"'$y'"
      if y % 3 == 0
    } {
      print(s"${y1} ")
    }
    println()
    //生成新机的结果集
    val arrayList = for {
      i <- 1 until 100
      if i % 10 == 0
      y <- i until i + 10
      if y % 3 == 0
      if y % 2 == 0
    } yield {
      y
    }
    println(arrayList)

  }

}
