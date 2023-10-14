/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
  val result = litres(2.0)
  println(result)
}

fun litres(time: Double) = (time / 2).toInt()

object Opstrings {

  fun rot(strng: String) = strng.reversed()

  fun selfieAndRot(strng: String): String {
    val s1 = strng.split("\n").map { s -> "$s...." }.joinToString("\n")
    return s1 + s1.reversed()
  }

  fun oper(operation: (String) -> String , s: String): String {
    return operation(s)
  }
}
