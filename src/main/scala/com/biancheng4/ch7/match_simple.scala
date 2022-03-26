package com.biancheng4.ch7

//简单的match类型
object match_simple {

  def main(args: Array[String]): Unit = {
    val firstFood: String = if (!args.isEmpty) args(0) else "xxx"
    //简单匹配, _表示未知的变量
    firstFood match {
      case "good" => println("A")
      case "just soso" => println("B")
      case "bad" => println("C")
      case _ => println("D")
    }
    //简单的返回值
    val getChar = "good" match {
      case "good" => "A"
      case "just soso" => "B"
      case "bad" => "C"
      case _ => "D"
    }
    println(getChar)
  }

}
