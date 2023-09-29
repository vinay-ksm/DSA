class Queue(val value: Int?) {
  var first: QueueNode? = null
  var last: QueueNode? = null
  var length = 0

  init {
    if (value != null) {
      val node = QueueNode(value, null)
      first = node
      last = node
      length++
    }
  }

  /**
   * method to add a node to the end of queue
   */
  fun enqueue(value: Int) {
    val node = QueueNode(value, null)
    if (length == 0) {
      first = node
      last = node
    } else {
      last?.next = node
      last = node
    }
    length++
  }

  /**
   * method to remove first node from the queue
   */
  fun dequeue(): QueueNode? {
    if (length == 0) {
      return null
    }

    val tempFirst = first
    if (length == 1) {
      first = null
      last = null
    } else {
      val tempFirst = first?.next
      first?.next = null
      first = tempFirst
    }
    length--
    return tempFirst
  }

  /**
   * method to print details about the queue
   */
  fun printQueue() {
    var current = first
    while (current != null) {
      println("value: ${current.value}, isFirst: ${current == first}, isLast: ${current == last}")
      current = current.next
    }
    println("length: $length")
  }

  data class QueueNode(var value: Int?, var next: QueueNode?)
}

fun main() {
  val q = Queue(1)
  q.enqueue(2)
  q.enqueue(3)
  q.dequeue()
  q.dequeue()
  q.dequeue()
  q.printQueue()
}

