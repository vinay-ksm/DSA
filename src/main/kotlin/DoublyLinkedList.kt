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
  fun append(value: Int): DoublyLinkedList {
    val node = DllNode(value = value, next = null, previous = tail)
    tail?.next = node
    tail = node

    if (head == null) {
      head = node
    }

    listLength++
    return this
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

  /**
   * Method to insert a node at a particular index
   */
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

  /**
   * method to remove a node a particular index
   */
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

  /**
   * method to simply swap first and last node within the list
   */
  fun swapFirstAndLast(): Boolean {
    if (listLength < 2) {
      return false
    }

    val headValue = head!!.value
    head!!.value = tail!!.value
    tail!!.value = headValue
    return true
  }

  /**
   * Method to reverse the list
   */
  fun reverse() {
    if (listLength <= 1) {
      return
    }

    var current = head
    while (current != null) {
      val nextNode = current.next
      current.next = current.previous
      current.previous = nextNode
      current = nextNode
    }

    // Swap the head and tail pointers
    val newHead = tail
    tail = head
    head = newHead
  }

  /**
   * Collects all the values of nodes in the list and returns it as an array
   */
  fun toArray(): IntArray {
    var output = IntArray(listLength)
    var current = head
    for (i in 0 until listLength) {
      output[i] = current!!.value
      current = current?.next
    }
    return output
  }

  /**
   * method to check if list elements represent a palindrome
   */
  fun isPalindrome(): Boolean {
    var forward = head
    var backward = tail
    for (i in 0 until (listLength / 2)) {
      if (forward?.value != backward?.value) {
        return false
      }
      forward = forward?.next
      backward = backward?.previous
    }

    return true
  }

  /**
   * Method to swap adjacent nodes
   */
  fun swapPairs() {
    if (listLength < 2) {
      return
    }
    var current = head
    while (current != null && current?.next != null) {
      val tempValue = current.value
      current.value = current.next!!.value
      current.next!!.value = tempValue
      current = current.next?.next
    }
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
  dll.append(4)
  dll.swapPairs()
  dll.printList()
}

