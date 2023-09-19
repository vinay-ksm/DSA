class ListNode(var value: Int) {
  var next: ListNode? = null
}

fun reverseLinkedList(head: ListNode?): ListNode? {
  var prev: ListNode? = null
  var current = head

  while (current != null) {
    val nextTemp = current.next
    current.next = prev
    prev = current
    current = nextTemp
  }

  return prev
}

fun printLinkedList(head: ListNode?) {
  var current = head
  while (current != null) {
    print("${current.value} -> ")
    current = current.next
  }
  println("null")
}

fun main() {
  val head = ListNode(1)
  head.next = ListNode(2)
  head.next?.next = ListNode(3)
  head.next?.next?.next = ListNode(4)

  println("Original linked list:")
  printLinkedList(head)

  val reversedHead = reverseLinkedList(head)

  println("Reversed linked list:")
  printLinkedList(reversedHead)
}
