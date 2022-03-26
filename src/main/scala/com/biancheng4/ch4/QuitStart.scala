package com.biancheng4.ch4

object QuitStart extends App {
  for (arg <- args) {
    println(arg + " : " + ChecksumAccumulator.calculate(arg))
  }

}
