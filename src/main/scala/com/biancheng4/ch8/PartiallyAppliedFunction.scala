package com.biancheng4.ch8

//部分应用函数
object PartiallyAppliedFunction {

  def main(args: Array[String]): Unit = {
    def sum(x: Int, y: Int, z: Int) = x + y + z

    println(sum(1, 2, 3))
    //省略整个参数列表的部分函数
    val partFunc = sum _
    println(partFunc(1, 2, 3))
    println(partFunc)
    //省略了部分参数的 部分函数，因为不能明确sum的函数,也有可能有其他sum，所以需要指定
    val partFunc2 = sum(1, _: Int, 3)
    println(partFunc2(2))
    println(partFunc2)

    val list: List[String] = List("1", "2", "3", "4", "5", "6", "15")
    //完全省略的部分参数，包括下划线，不过省略的地方，需要明确什么类型的函数才行，否则不能省略,
    //因为foreach，确定类型了，并且知道需要一个 A => U的函数
    list.foreach(println)
  }

}
