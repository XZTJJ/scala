package com.biancheng4.ch8

//局部函数和 私有函数的区别， 更加推荐私有函数
object localOrPrivateFunction {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("1", "2", "3", "4", "5", "6", "7", "8")
    println(useFunctionWithPrivate(list, 2))
    println(useFunctionWithLocal(list, 2))
  }


  //局部函数的方式
  def useFunctionWithLocal(list: List[String], number: Int): String = {
    //局部函数
    def localFunction(target: String): Boolean = if ((target.toInt) % number == 0) true else false
    val test: List[Any] = for (arg <- list if localFunction(arg)) yield arg
    test.mkString(",")
  }


  //私有函数的方式
  def useFunctionWithPrivate(list: List[String], number: Int): String = {
    val test: List[Any] = for (arg <- list if privateFunction(arg,number)) yield arg
    test.mkString(",")
  }

  private def privateFunction(target: String, number: Int): Boolean = if ((target.toInt) % number == 0) true else false
}
