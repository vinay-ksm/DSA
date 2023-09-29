class Stack<T>(val value: T?) {
  data class StackNode<T>(var value: T?, var next: StackNode<T>?)

  var height: Int = 0
  var top: StackNode<T>? = null

  init {
    val node = StackNode(value, null)
    if (value != null) {
      height++
      top = node
    }
  }

  /**
   * Method to push a node to the top of the stack
   */
  fun push(value: T): Stack<T> {
    val node = StackNode(value, top)
    top = node
    height++
    return this
  }

  /**
   * Method to pop top most node
   */
  fun pop(): StackNode<T>? {
    if (top == null) {
      return null
    }

    val temp = top
    top = top?.next
    temp!!.next = null
    height--
    return temp
  }

  fun printStack() {
    var current = top
    while (current != null) {
      println("value: ${current.value}, isTop: ${top == current}")
      current = current.next
    }
    println("height: ${height}")
  }
}

fun main() {
  var input = Stack(5)
  input.push(4).push(3).push(1).push(2).push(10).push(6)
  sortStack(input)
}

fun sortStack(original: Stack<Int>) {
  if (original.height < 1) {
    return
  }
  val sorted = Stack(original.pop()?.value)
  while (original.height > 0) {
    var popped = original.pop()!!.value!!
    while (sorted.height > 0  && popped < sorted.top!!.value!!) {
      original.push(sorted.pop()!!.value!!)
    }
    sorted.push(popped)
  }
  

}

fun isBalancedParentheses(str: String): Boolean? {
  val s = Stack<Char>(null)
  for (c in str.toCharArray()) {
    if (c == '(') {
      s.push(c)
    } else {
      val popped = s.pop() ?: return false
    }
  }
  return s.height == 0
}
