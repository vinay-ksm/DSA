class LinkedList(private val value: Int?) {
  var head: Node? = null
  var tail: Node? = null
  var length = 0

  init {
    if (value != null) {
      val node = Node(value, null)
      head = node
      tail = node
      length++
    }
  }


  fun append(value: Int) {
    val newNode = Node(value, null)

    if (length == 0) {
      head = newNode
      tail = newNode
    } else {
      tail?.next = newNode
      tail = newNode
    }
    length++

  }

  fun removeLast(): Node? {
    var current: Node? = head

    if (length == 0) {
      return null
    } else if (length == 1) {
      val temp = head
      head = null
      tail = null
      length = 0
      return temp
    } else {
      var temp: Node
      current = head!!.next
      temp = current!!
      var prev = head
      while (current != null) {
        if (current.next == null) {
          tail = prev
          temp = current
          tail!!.next = null
          length--
        }
        prev = current
        current = current.next
      }
      return temp
    }
  }

  fun prepend(value: Int) {
    val node = Node(value, null)
    if (head == null) {
      head = node
      tail = node
    } else {
      node.next = head
      head = node
    }

    length++
  }

  fun removeFirst(): Node? {
    if (length == 0) {
      return null
    } else if (length == 1) {
      head = null
      tail = null
      length = 0
      return null
    } else {
      val temp = head
      head = head!!.next
      temp!!.next = null
      length--
      return head
    }
  }

  fun getNode(index: Int): Node? {
    if (length < index) {
      return null
    }
    var current = head
    var currIndex = 0
    while (currIndex != index) {
      currIndex++
      current = current!!.next
    }
    return current
  }

  fun setNode(index: Int, value: Int): Boolean {
    if (index >= length) {
      return false
    }

    var node = head
    for (i in 0..index) {
      if (i == index) {
        node!!.value = value
        break
      }
      node = node!!.next
    }
    return true
  }

  fun insert(index: Int, value: Int): Boolean {
    if (index < 0 || index > length) {
      return false
    }
    if (index == 0) {
      prepend(value)
      return true
    }
    if (index == length) {
      append(value)
      return true
    }
    val previous = getNode(index - 1)
    val current = getNode(index)
    val newNode = Node(value, current)
    previous!!.next = newNode
    length++
    return true
  }

  fun remove(index: Int): Boolean {
    if (index < 0 || index >= length) {
      return false
    }
    if (index == 0) {
      removeFirst()
      return true
    }

    if (index == length - 1) {
      removeLast()
      return true
    }

    val previous = getNode(index - 1)
    val next = getNode(index + 1)
    previous!!.next = next

    getNode(index)!!.next == null
    length--

    return true
  }

  fun reverse() {
    var prev: Node? = null
    var current = head
    while (current != null) {
      val after = current!!.next
      current.next = prev
      prev = current
      current = after
    }
    val temp = head
    head = tail
    tail = temp
  }

  fun findMiddleNode(): Node? {
    var slow: Node? = head
    var fast: Node? = head
    while (slow?.next != null && fast?.next != null) {
      slow = slow?.next
      fast = fast?.next?.next
    }
    return slow
  }

  fun hasLoop(): Boolean {
    var fast = head?.next?.next
    var slow = head?.next
    while (fast != null || fast?.next != null) {
      if (slow == fast) {
        return true
      }

      slow = slow?.next
      fast = fast.next?.next
    }

    return false
  }

  fun findKthFromEnd(k: Int): Node? {
    var fast = head
    var slow = head
    for (i in 0 until k) {
      if (fast == null) {
        return null
      }
      fast = fast.next
    }

    while (fast != null) {
      fast = fast.next
      slow = slow?.next
    }

    return slow
  }

  fun partitionList(x: Int): LinkedList? {
    if (head == null) {
      return null
    }

    var lessThan = LinkedList(null)
    var greaterThan = LinkedList(null)
    var current = head
    while (current != null) {
      if (current.value < x) {
        lessThan.append(current.value)
      } else {
        greaterThan.append(current.value)
      }
      current = current.next
    }
    lessThan.tail?.next = greaterThan.head
    return lessThan
  }

  fun removeDuplicates() {
    var myIntHashMap: HashSet<Int> = HashSet()
    var current = head ?: return
    myIntHashMap.add(current.value)
    var after = current.next
    while (after != null) {
      if (myIntHashMap.contains(after.value)) {
        if (after == tail) {
          current.next = null
        }
        var newAfter = after.next
        after.next = null
        after = newAfter
      } else {
        myIntHashMap.add(after.value)
        current.next = after
        current = after
        after = after.next
      }
    }

  }

  fun reverseBetween(a: Int, b: Int) {
    var current = head
    var next = head
    var started = false
    var begin: Node? = null
    for (i in 0..b) {
      if (started) {
        current?.next = null
        val tempNext = next?.next
        next?.next = current
        current = tempNext
        next = tempNext?.next
        continue
      }
      if(i+1 == a){
        begin = current
      }
      if (i == a) {
        started = true
      }

      current = next
      next = next?.next
    }
    begin?.next = next
  }

  fun printList() {
    var current: Node? = head
    println("**** printing linked list *****")
    var listLength = 0
    while (current != null) {
      println("${current.value}, isHead:${current == head}, isTail:${current == tail}")
      current = current.next
      listLength++
    }
    println("listLength: $listLength")
  }

}

data class Node(
  var value: Int,
  var next: Node?
) {
//
}

fun main() {
  val myLinkedList = LinkedList(2)
  println("Head: ${myLinkedList.head}")
  println("Tail: ${myLinkedList.tail}")
  println("length: ${myLinkedList.length}")
  myLinkedList.append(3)
  myLinkedList.append(-4)
  myLinkedList.printList()

  println("removing last node ${myLinkedList.removeLast()}")
  myLinkedList.printList()

  myLinkedList.prepend(6)
  myLinkedList.prepend(6)
  myLinkedList.prepend(8)
  myLinkedList.printList()

  println("removing first node ${myLinkedList.removeFirst()}")
  myLinkedList.printList()
  myLinkedList.append(31)
  myLinkedList.append(32)
  myLinkedList.printList()

  println("value at index 0 is ${myLinkedList.getNode(0)}")

  myLinkedList.setNode(0, 10)
  println("value at index 0 after setting is ${myLinkedList.getNode(0)}")
  myLinkedList.printList()

  myLinkedList.insert(0, 1)
  println("linked list after insert 1 at index 0")
  myLinkedList.printList()

  myLinkedList.insert(myLinkedList.length, 100)
  println("linked list after insert 100 at the end")
  myLinkedList.printList()

  myLinkedList.insert(1, 2)
  println("linked list after insert 2 at index 1")
  myLinkedList.printList()

  myLinkedList.insert(myLinkedList.length - 1, 99)
  println("linked list after insert 99 at index last but 1")
  myLinkedList.printList()

  myLinkedList.remove(9)
  myLinkedList.printList()

  myLinkedList.reverse()
  println("printing after reverse")

  myLinkedList.printList()

  println("middle node is ${myLinkedList.findMiddleNode()}")

  myLinkedList.append(123)
  println("middle node is ${myLinkedList.findMiddleNode()}")

  var loopCheck = LinkedList(1)
  loopCheck.append(2)
  loopCheck.append(3)
  loopCheck.append(4)
  loopCheck.append(5)
  loopCheck.append(6)
  loopCheck.printList()
  println("2 element from last ${loopCheck.findKthFromEnd(6)}")

  val partitioned = loopCheck.partitionList(3)
  partitioned?.printList()

  loopCheck.append(1)
  println("before filtering dups")
  loopCheck.printList()
  println("after filtering dups")
  loopCheck.removeDuplicates()
  loopCheck.printList()

  loopCheck.reverseBetween(1,3)
  loopCheck.printList()
}
