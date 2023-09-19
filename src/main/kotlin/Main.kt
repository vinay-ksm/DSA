/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
  val result = mirror("xawhfi vgfhyas uem olswayod pzawhzs ovxrpdg mcmf")
  println(result)
}

fun mirror(text: String): String {
  var result = ""
  val words = text.split(" ")
  val maxLen = (words.maxByOrNull { w -> w.length } ?: "").length
  result += "*".repeat(maxLen + 4) + "\n"
  words.map { w ->
    result += "* ${w.reversed()}"
    result += " ".repeat(maxLen + 1 - w.length) + "*\n"
  }
  result += "*".repeat(maxLen+4) + "\n"
  return result
}
