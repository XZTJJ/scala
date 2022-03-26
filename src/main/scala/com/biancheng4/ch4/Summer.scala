package com.biancheng4.ch4

object Summer {

  def main(args: Array[String]): Unit = {
    val hck  = new ChecksumAccumulator;

      for(arg <- args){
        println(arg+ " : "+ ChecksumAccumulator.calculate(arg))
      }
  }

}
