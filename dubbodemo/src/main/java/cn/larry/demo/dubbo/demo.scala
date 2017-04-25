package cn.larry.demo.dubbo

object demo {
  def main(args: Array[String]) {
    println("hello")
    val map = Map("a" -> 1, "b" -> 2)
    map.map { case (key, value) => println(value) }
  }

}