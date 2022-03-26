package com.biancheng4.ch9

import com.biancheng4.ch9.SimplifyCode.FindFileScalaPro

import java.io.File

//简化代码, 通过查找某个目录下的文件，找出满足文件的列表
//两种不同的实现方式，分别是:JAVA实现方式，SCALA实现方式
object SimplifyCode {
  //找出当前目录的所有文件
  private def filesHers(): Array[File] = (new File("F:\\ProWorkSpace\\IDEA\\scala\\src\\main\\scala\\com\\biancheng4\\ch9")).listFiles

  //打印文件
  private def printFile(array: Array[File]): String = {
    val allFile = for (arr <- array) yield arr.getName
    allFile.mkString("  ")
  }

  def main(args: Array[String]): Unit = {
    val findFileJava: FindFileJava = new FindFileJava
    val findFileScala: FindFileScala = new FindFileScala
    val findFileScalaPro: FindFileScalaPro = new FindFileScalaPro

    println("--------找到已.scala结尾的文件-----------")
    val endWithJava = findFileJava.matcheFileEndWith(".scala")
    val endWithScala = findFileScala.matcheFileEndWith(".scala")
    val endWithScalaPro = findFileScalaPro.matcheFileEndWith(".scala")
    println(s" ${printFile(endWithJava)} \n ${printFile(endWithScala)} \n ${printFile(endWithScalaPro)}")


    println("--------找到包含.scala 的文件-----------")
    val containJava = findFileJava.matcheFileContineWith(".scala")
    val containScala = findFileScala.matcheFileContineWith(".scala")
    val containScalaPro = findFileScalaPro.matcheFileContineWith(".scala")
    println(s" ${printFile(containJava)} \n ${printFile(containScala)} \n ${printFile(containScalaPro)}")
  }

  /*
   *原始的需要经常重复的代码，类似于Java写法
   * 其实大部分的方式逻辑非常类似，只不过调用的方法不同而已，因此需要某种方式简化代码
   */
  private class FindFileJava {
    //找出通过 xxx 结尾的文件
    def matcheFileEndWith(query: String): Array[File] = {
      for (file <- filesHers() if file.getName.endsWith(query)) yield file
    }

    //找出包含 xxx 的文件
    def matcheFileContineWith(query: String): Array[File] = {
      for (file <- filesHers() if file.getName.contains(query)) yield file
    }

    //找出匹配某个正则表达式的文件
    def matcheFileRegerWith(query: String): Array[File] = {
      for (file <- filesHers() if file.getName.matches(query)) yield file
    }
  }

  /*
   * 简化写法，通过传入 函数值 方式来完成简化
   * 注意: 方法作为值的形式传入. 如果代码更多的话，就更加容易看出差别
   */
  private class FindFileScala {
    //私有方法，定义一个函数，让函数值作为值传入
    private def matchFile(query: String, matcher: (String, String) => Boolean): Array[File] = {
      for (file <- filesHers() if matcher(file.getName, query)) yield file
    }

    //找出通过 xxx 结尾的文件
    def matcheFileEndWith(query: String): Array[File] = matchFile(query, _.endsWith(_))

    //找出包含 xxx 的文件
    def matcheFileContineWith(query: String): Array[File] = matchFile(query, _.contains(_))

    //找出匹配某个正则表达式的文件
    def matcheFileRegerWith(query: String): Array[File] = matchFile(query, _.matches(_))
  }


  /**
   * scala的更进一步简化，通过闭包的方式
   * 其实query 在各个matchxxx的方法已经定义了，确实在matchFile中根本无需再次定义了,
   * 因此可以通过闭包传入到 matchFile中， 因为在创建多个 函数值时 ，通过绑定了query的值，所以
   * 不会改变。 如果在创建闭包时没有传入 query的话，就会在绑定上下文query的引用。
   */
  private class FindFileScalaPro {
    //私有方法，定义一个函数，让函数值作为值传入
    private def matchFile(matcher: (String) => Boolean): Array[File] = {
      for (file <- filesHers() if matcher(file.getName)) yield file
    }

    //找出通过 xxx 结尾的文件
    def matcheFileEndWith(query: String): Array[File] = matchFile(_.endsWith(query))

    //找出包含 xxx 的文件
    def matcheFileContineWith(query: String): Array[File] = matchFile(_.contains(query))

    //找出匹配某个正则表达式的文件
    def matcheFileRegerWith(query: String): Array[File] = matchFile(_.matches(query))
  }
}

