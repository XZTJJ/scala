package com.biancheng4.ch7

object try_throw {
  def main(args: Array[String]): Unit = {
    testCatch()
    testThrow()
  }

  def testCatch(): Int = {
    for (i <- 1 to 5) {
      try {
        if (i % 2 == 0) {
          throw new RuntimeException("异常")
        }
      } catch {
        case ex: RuntimeException => {
          println("运行时异常")
          Int.MinValue
        }
        case ex: Exception => {
          println("其他异常")
          Int.MinValue
        }
      }
    }
    1
  }

  //测试抛出异常
  def testThrow(): Int = {
    if (5 % 2 == 0) {
      2
    } else {
      throw new RuntimeException("异常")
    }
  }
}
