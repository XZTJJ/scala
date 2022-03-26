package com.biancheng4.ch7

//  99乘法表打印
object MultiTableFor99 {

  def main(args: Array[String]): Unit = {
    val str: String = mulitTable()
    println(str)
  }

  //99乘法表打印整体
  def mulitTable(): String = {
    val list: IndexedSeq[String] = for (i <- 1 to 10) yield mulitRow(i)
    list.mkString("\n")
  }

  //99乘法表每一行打印
  def mulitRow(n: Int): String = {
    mulitOne(n).mkString
  }

  //具体的每个数相乘
  def mulitOne(n: Int): IndexedSeq[String] = {
    for (i <- 1 to 10) yield {
      //乘数,也就是积
      val muli: String = (i * n).toString
      //空格数
      val space: String = " " * (4 - muli.length)
      space + muli
    }
  }
}
