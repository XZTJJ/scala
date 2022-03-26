package com.biancheng4.ch6

//有理数运算
class Rational(n: Int, d: Int) {
  //前置条件，如果不满条件，则不能创建
  require(d != 0)

  //最大公约数,并且这个字段一定要比后面先出现，因为后面两个字段依赖它
  private val g: Int = gcd(n.abs, d.abs)
  //添加字段
  val number: Int = n / g;
  val denom: Int = d / g;

  //辅助构造函数
  def this(number: Int) = this(number, 1)

  //覆写对应的方法
  override def toString: String = s"$number/$denom"

  // + 运算 scala会自动判断符号的优先级的，* 比+ 优先级更高
  def +(that: Rational): Rational = new Rational(number * that.denom + that.number * denom, denom * that.denom)

  def +(i: Int): Rational = new Rational(number + i * denom, denom)

  // * 运算 scala会自动判断符号的优先级的，* 比+ 优先级更高
  def *(that: Rational): Rational = new Rational(number * that.number, denom * that.denom)

  def *(i: Int): Rational = new Rational(number * i, denom)

  //- 运算
  def -(that: Rational): Rational = new Rational(number * that.denom - that.number * denom, denom * that.denom)

  def -(i: Int): Rational = new Rational(number - i * denom, denom)

  def /(that: Rational): Rational = new Rational(number * that.denom, denom * that.number)

  def /(i: Int): Rational = new Rational(number, denom * i)

  //比较运算，是否比给定的值要小
  def lessThan(that: Rational): Boolean = number * that.denom < that.number * denom

  //最大值
  def max(that: Rational): Rational = if (lessThan(that)) that else this

  //私有方法，求最大公约数
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
