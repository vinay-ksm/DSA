class Stack(val value: Int?) {
  var height: Int = 0
  var top: StackNode? = null

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
  fun push(value: Int): Stack {
    val node = StackNode(value, top)
    top = node
    height++
    return this
  }

  /**
   * Method to pop top most node
   */
  fun pop(): StackNode? {
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

data class StackNode(var value: Int?, var next: StackNode?)

fun main() {
  val stack = Stack(1)
  stack.push(2).push(3).push(4)
  stack.pop()
  stack.printStack()
}
