package com.biancheng4.ch7

//使用递归来替代对应的 continue 和 break 控制流程
object recursion_replace_cb {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("-first.java", "-first2.java", "-first3.java", "first1.java", "first2.java", "first3.java", "first4.java", "current.scala", "ssss")
    val restest = recusionWrite(list)
    val oritest = whileWrite(list)
    println(s"$restest  /   $oritest")
  }

  def recusionWrite(args: List[String]): Boolean = {
    def recuW(i: Int): Int = {
      if (i > args.length) -1
      else if (args(i).endsWith(".scala")) i
      else if (args(i).startsWith("-")) recuW(i + 1)
      else recuW(i + 1)
    }

    val index = recuW(0)
    index != -1
  }

  //原始写法
  def whileWrite(args: List[String]): Boolean = {
    //java语法形式,因为scala里面，没有continue 和 break，所以写不出来
    /*
        int i = 0;
        boolean found = false;
        while (i < args.length) {
            if (args[i].startsWith("-")) {
                i = i + 1;
                continue;
            }
            if (args[i].endsWith(".scala")) {
                found = true;
                break;
            }
            i = i + 1;
        }
        return found;
     */
    //scala的版本
    var i: Int = 0
    var found: Boolean = false
    //判断
    while (i < args.length && !found) {
      if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala"))
          found = true
      }
      i = i + 1
    }
    found
  }
}
