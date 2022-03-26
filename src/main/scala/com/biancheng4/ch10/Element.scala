package com.biancheng4.ch10

import com.biancheng4.ch10.Element.elem

/**
 * 抽象的类
 */
abstract class Element {
  //内容
  def content: Array[String];

  //高度
  def height: Int = content.length;

  //宽度
  def width: Int = if (height == 0) 0 else content(0).length;

  //一行表示一个内容，增加高度，
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.content ++ that1.content)
  }

  //对于 两行的内容进行合并, 增加宽度
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(for ((line1, line2) <- this1.content zip that1.content) yield line1 + line2)
  }

  //内容显示
  override def toString = content mkString "\n"

  //对于高度不同的两个Element 增加的话， 每一行都需要宽度统一
  private def widen(w: Int): Element = {
    if (w <= this.width) this
    else {
      val left = elem(' ', (w - this.width) / 2, this.height)
      val right = elem(' ', w - this.width - left.width, this.height)
      left beside this beside right
    }
  }

  //对于宽度不同的元素进行拼接的话， 高度需要统一
  private def heighten(h: Int): Element = {
    if (h <= this.height) this
    else {
      val top = elem(' ', this.width, (h - this.height) / 2)
      val bottom = elem(' ', this.width, h - this.height - top.height)
      top above this above bottom
    }
  }
}


/**
 * 伴生类对象，同时也是工厂方法对象
 */
object Element {
  //创建一个ArrayElement的对象
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  //创建一个UniformElement对象
  def elem(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)

  //创建一个LineElement对象
  def elem(line: String): Element = new LineElement(line)

  /**
   * 具体实现某个方法的抽象类，因为scala的命名空间关系，content无参方法实现可以用字段代替
   * @param content
   */
  private class ArrayElement(val content: Array[String]) extends Element

  /**
   * 指定类型的 Element 的子类，用自定字符填充
   */
  private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    override def content: Array[String] = Array.fill(height)(ch.toString * width)
  }


  /**
   * 基于 ArrayElement 的实现类
   * @param s
   */
  private class LineElement(line: String) extends Element {
    override def content: Array[String] = Array(line)
  }
}
