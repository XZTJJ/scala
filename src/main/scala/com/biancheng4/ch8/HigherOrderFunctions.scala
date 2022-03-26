package com.biancheng4.ch8

//一等函数，也就是所谓的一等公民
object HigherOrderFunctions {
  //一等函数
  def main(args: Array[String]): Unit = {
    //比如内部函数
    def localFunction(s: Int): Boolean = if (s % 2 == 0) true else false
    println(localFunction(2))

    //匿名函数
    val anonymousFunction = (x: Int) => if (x % 2 == 0) true else false
    println(anonymousFunction(3))
    println(anonymousFunction)

    //集合中存在的匿名函数
    val list: List[String] = List("1", "2", "3", "4", "5", "6", "15")
    list.foreach(arg => print(s"$arg "))
    println()
    val intList: List[String] = list.filter(arg => arg.toInt % 2 == 0)
    println(intList)
    //占位符写法，这里占位符只能出现一次，不能出现多次
    val int2: List[String] = list.filter(_.length == 1)
    println(int2)
    //占位符代替整个参数列表的写法,这里 _ 直接代替了 (x) 这个参数列表
    list.foreach(print _)
  }

}
