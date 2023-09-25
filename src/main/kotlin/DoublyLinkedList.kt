class DoublyLinkedList(value: Int?) {
  var head: DllNode? = null
  var tail: DllNode? = null
  var listLength: Int = 0

  init {
    if (value != null) {
      val node = DllNode(value, null, null)
      head = node
      tail = node
      listLength++
    }
  }

  /**
   * appends a value to the end of list
   */
  fun append(value: Int) {
    val node = DllNode(value = value, next = null, previous = tail)
    tail?.next = node
    tail = node

    if (head == null) {
      head = node
    }

    listLength++
  }

  /**
   * removes last node from the list
   */
  fun removeLast(): DllNode? {
    if (tail == null) {
      return null
    }

    val previous = tail!!.previous
    val current = tail

    if (previous == null) {
      head = null
      tail = null
    } else {
      tail = previous
      previous.next = null
      current!!.previous = null
    }

    listLength--
    return current
  }

  /**
   * Method to prepend a node to the beginning of the linked list
   */
  fun prepend(value: Int) {
    val node = DllNode(value, null, null)
    if (head == null) {
      head = node
      tail = node
    } else {
      head!!.previous = node
      node.next = head
      head = node
    }
    listLength++
  }

  /**
   * Method to remove first node from the list
   */
  fun removeFirst(): DllNode? {
    if (head == null) {
      return null
    }
    var current = head!!.next
    var nodeToBeRemoved = head
    if (current == null) {
      head = null
      tail = null
    } else {
      head!!.next = null
      current.previous = null
      head = current
    }
    listLength--
    return nodeToBeRemoved
  }

  /**
   * Method to get an element at a particular index
   */
  fun getNode(index: Int): DllNode? {
    if (index >= listLength) {
      return null
    }

    var current = head
    for (j in 0 until index) {
      current = current!!.next
    }
    return current
  }

  /**
   * function to set value at a particular index
   */
  fun setNodeValue(newValue: Int, i: Int): Boolean {
    val node = getNode(i) ?: return false
    node.value = newValue
    return true
  }

  fun insert(value: Int, index: Int): Boolean {
    if (index < 0 || index > listLength) {
      return false
    }

    if (index == 0) {
      prepend(value)
    } else if (index == listLength) {
      append(value)
    } else {
      val newNode = DllNode(value, null, null)
      val currentNode = getNode(index)!!
      val previousNode = currentNode.previous!!
      previousNode.next = newNode
      newNode.previous = previousNode
      newNode.next = currentNode
      currentNode.previous = newNode
    }
    return true
  }

  fun remove(index: Int): DllNode? {
    val node = getNode(index) ?: return null

    if (index == 0) {
      removeFirst()
    } else if (index == listLength - 1) {
      removeLast()
    } else {
      val previousNode = node.previous!!
      val nextNode = node.next!!
      previousNode.next = nextNode
      nextNode.previous = previousNode
      node.next = null
      node.previous = null
      listLength--
    }
    return node
  }

  fun printList() {
    var current = head
    while (current != null) {
      println("value: ${current.value}, isHead: ${head == current}, isTail: ${tail == current}")
      current = current.next
    }
    println("length: ${listLength}")
  }
}

data class DllNode(var value: Int, var next: DllNode?, var previous: DllNode?) {
//
}

fun main() {
  val dll = DoublyLinkedList(1)
  dll.append(2)
  dll.append(3)
  dll.remove(0)
  dll.printList()
}

