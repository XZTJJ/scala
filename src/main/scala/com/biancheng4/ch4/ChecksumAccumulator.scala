package com.biancheng4.ch4

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum: Int = 0;

  def add(b: Byte) = sum = sum + b

  def checkSum() = ~(sum & 0XFF) + 1
}

object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }
  }


}

