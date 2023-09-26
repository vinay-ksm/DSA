import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DoublyLinkedListTest {

  //<editor-fold desc="append tests">
  @Test
  fun append() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    Assertions.assertEquals(2, dll.listLength)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(2, dll.tail!!.value)
  }

  @Test
  fun `append when null head and tail`() {
    val dll = DoublyLinkedList(null)
    dll.append(1)
    Assertions.assertEquals(1, dll.listLength)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(1, dll.tail!!.value)
  }
  //</editor-fold>

  //<editor-fold desc="removeLast() tests">
  @Test
  fun `removeLast when more than 2 nodes in the list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val removedNode = dll.removeLast()

    Assertions.assertEquals(3, removedNode!!.value)
    Assertions.assertEquals(2, dll.listLength)
    Assertions.assertEquals(2, dll.tail!!.value)
  }

  @Test
  fun `removeLast when only 2 nodes are in the list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    val removedNode = dll.removeLast()
    Assertions.assertEquals(2, removedNode!!.value)
    Assertions.assertEquals(1, dll.listLength)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(1, dll.tail!!.value)
  }

  @Test
  fun `removeLast when only 1 node is in the list`() {
    val dll = DoublyLinkedList(1)
    val removedNode = dll.removeLast()
    Assertions.assertEquals(1, removedNode!!.value)
    Assertions.assertEquals(0, dll.listLength)
    Assertions.assertNull(dll.head)
    Assertions.assertNull(dll.tail)
  }

  @Test
  fun `removeLast when no nodes are in the lsit`() {
    val dll = DoublyLinkedList(null)
    val removedNode = dll.removeLast()
    Assertions.assertNull(removedNode)
  }
  //</editor-fold>

  //<editor-fold desc="prepend() related tests">
  @Test
  fun `prepend when different head and tail are present`() {
    val dll = DoublyLinkedList(2)
    dll.append(3)
    dll.prepend(1)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(3, dll.tail!!.value)
    Assertions.assertEquals(3, dll.listLength)
  }

  @Test
  fun `prepend when head is not present`() {
    val dll = DoublyLinkedList(null)
    dll.prepend(1)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(1, dll.tail!!.value)
    Assertions.assertEquals(1, dll.listLength)
  }

  @Test
  fun `prepend when only head is and tail is not present`() {
    val dll = DoublyLinkedList(2)
    dll.prepend(1)
    Assertions.assertEquals(1, dll.head!!.value)
    Assertions.assertEquals(2, dll.tail!!.value)
    Assertions.assertEquals(2, dll.listLength)
  }
  //</editor-fold>

  //<editor-fold desc="removeFirst related tests">
  @Test
  fun `removeFirst() when multiple nodes are present`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(4)
    val removedNode = dll.removeFirst()
    Assertions.assertEquals(1, removedNode!!.value)
    Assertions.assertNull(removedNode.next)
    Assertions.assertEquals(2, dll.head!!.value)
    Assertions.assertEquals(4, dll.tail!!.value)
    Assertions.assertEquals(3, dll.listLength)
  }

  @Test
  fun `removeFirst() when only 2 nodes are present`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    val removedNode = dll.removeFirst()
    Assertions.assertEquals(1, removedNode!!.value)
    Assertions.assertNull(removedNode.next)
    Assertions.assertEquals(2, dll.head!!.value)
    Assertions.assertEquals(2, dll.tail!!.value)
    Assertions.assertEquals(1, dll.listLength)
  }

  @Test
  fun `removeFirst() when only 1 node is present`() {
    val dll = DoublyLinkedList(1)
    val removedNode = dll.removeFirst()
    Assertions.assertEquals(1, removedNode!!.value)
    Assertions.assertNull(dll.head)
    Assertions.assertNull(dll.tail)
    Assertions.assertNull(removedNode.next)
  }
  //</editor-fold>

  //<editor-fold desc="get related tests">
  @Test
  fun `get with valid index within range`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)

    val node = dll.getNode(1)
    Assertions.assertEquals(2, node!!.value)
  }

  @Test
  fun `get head`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)

    val node = dll.getNode(0)
    Assertions.assertEquals(1, node!!.value)
  }

  @Test
  fun `get tail`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)

    val node = dll.getNode(2)
    Assertions.assertEquals(3, node!!.value)
  }

  @Test
  fun `get with index out of range`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)

    val node = dll.getNode(3)
    Assertions.assertNull(node)
  }
  //</editor-fold>

  //<editor-fold desc="set() related tests">
  @Test
  fun `set with valid range`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.setNodeValue(0, 0)
    Assertions.assertTrue(result)
    Assertions.assertEquals(0, dll.getNode(0)?.value)
  }

  @Test
  fun `set with invalid range`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.setNodeValue(0, 3)
    Assertions.assertFalse(result)
  }
  //</editor-fold>

  //<editor-fold desc="insert related tests">
  @Test
  fun `insert at index 0`() {
    val dll = DoublyLinkedList(0)
    dll.append(1)
    dll.append(2)
    val result = dll.insert(-1, 0)
    Assertions.assertTrue(result)
    Assertions.assertEquals(-1, dll.head?.value)
    Assertions.assertEquals(0, dll.head?.next?.value)
  }

  @Test
  fun `insert at index listLength`() {
    val dll = DoublyLinkedList(0)
    dll.append(1)
    dll.append(2)
    val result = dll.insert(3, 3)
    Assertions.assertTrue(result)
    Assertions.assertEquals(3, dll.tail?.value)
    Assertions.assertEquals(2, dll.tail?.previous?.value)
  }

  @Test
  fun `insert at middle`() {
    val dll = DoublyLinkedList(1)
    dll.append(3)
    dll.append(4)
    val result = dll.insert(2, 1)
    Assertions.assertTrue(result)
  }

  @Test
  fun `insert at index out of range`() {
    val dll = DoublyLinkedList(1)
    dll.append(3)
    dll.append(4)
    val result = dll.insert(2, 4)
    Assertions.assertFalse(result)
  }
  //</editor-fold>

  //<editor-fold desc="remove() related tests">
  @Test
  fun `remove head`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.remove(0)!!
    Assertions.assertEquals(1, result.value)
    Assertions.assertEquals(2, dll.head?.value)
    Assertions.assertEquals(2, dll.listLength)
  }

  @Test
  fun `remove tail`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.remove(2)!!
    Assertions.assertEquals(3, result.value)
    Assertions.assertEquals(2, dll.tail?.value)
    Assertions.assertEquals(2, dll.listLength)
  }

  @Test
  fun `remove middle`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.remove(1)!!
    Assertions.assertEquals(2, result.value)
    Assertions.assertEquals(2, dll.listLength)
  }

  @Test
  fun `remove out of range`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    val result = dll.remove(3)
    Assertions.assertNull(result)
    Assertions.assertEquals(3, dll.listLength)
  }
  //</editor-fold>

  //<editor-fold desc="swapFirstAndLast() related tests">
  @Test
  fun `more than 2 nodes in the list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(4)
    dll.append(5)
    val result = dll.swapFirstAndLast()
    Assertions.assertTrue(result)
    Assertions.assertEquals(5, dll.head?.value)
    Assertions.assertEquals(1, dll.tail?.value)
  }

  @Test
  fun `exactly 2 nodes in the list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    val result = dll.swapFirstAndLast()
    Assertions.assertTrue(result)
    Assertions.assertEquals(2, dll.head?.value)
    Assertions.assertEquals(1, dll.tail?.value)
  }

  @Test
  fun `exactly 1 node in the list`() {
    val dll = DoublyLinkedList(1)
    val result = dll.swapFirstAndLast()
    Assertions.assertFalse(result)
    Assertions.assertEquals(1, dll.head?.value)
    Assertions.assertEquals(1, dll.tail?.value)
  }

  @Test
  fun `exactly no nodes in the list`() {
    val dll = DoublyLinkedList(null)
    val result = dll.swapFirstAndLast()
    Assertions.assertFalse(result)
  }
  //</editor-fold>

  //<editor-fold desc="reverse() related tests">
  @Test
  fun `when more than 2 nodes are in list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(4)
    dll.append(5)
    dll.reverse()
    Assertions.assertArrayEquals(intArrayOf(5, 4, 3, 2, 1), dll.toArray())
  }

  @Test
  fun `when there are exactly 2 nodes are in list`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.reverse()
    Assertions.assertArrayEquals(intArrayOf(2, 1), dll.toArray())
  }

  @Test
  fun `when there is exactly 1 nodes are in list`() {
    val dll = DoublyLinkedList(1)
    dll.reverse()
    Assertions.assertArrayEquals(intArrayOf(1), dll.toArray())
  }
  //</editor-fold>

  //<editor-fold desc="isPalindrome() related tests">
  @Test
  fun `when even number of nodes which are palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(3)
    dll.append(2)
    dll.append(1)
    Assertions.assertTrue(dll.isPalindrome())
  }

  @Test
  fun `when odd number of nodes which are palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(2)
    dll.append(1)
    Assertions.assertTrue(dll.isPalindrome())
  }

  @Test
  fun `when even number of nodes which are not palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(2)
    dll.append(2)
    dll.append(1)
    Assertions.assertFalse(dll.isPalindrome())
  }

  @Test
  fun `when odd number of nodes which are not palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.append(3)
    dll.append(3)
    dll.append(1)
    Assertions.assertFalse(dll.isPalindrome())
  }

  @Test
  fun `when there are only 2 nodes that are palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(1)
    Assertions.assertTrue(dll.isPalindrome())
  }

  @Test
  fun `when there are only 2 nodes that are not palindrome`() {
    val dll = DoublyLinkedList(1)
    dll.append(-1)
    Assertions.assertFalse(dll.isPalindrome())
  }

  @Test
  fun `when there is only 1 node`() {
    val dll = DoublyLinkedList(1)
    Assertions.assertTrue(dll.isPalindrome())
  }
  //</editor-fold>

  //<editor-fold desc="swapPairs() related tests">
  @Test
  fun `when even number of nodes`() {
    val dll = DoublyLinkedList(1)
    dll.append(2).append(3).append(4).append(5).append(6)
    dll.swapPairs()
    Assertions.assertArrayEquals(intArrayOf(2, 1, 4, 3, 6, 5), dll.toArray())
    Assertions.assertEquals(2, dll.head?.value)
    Assertions.assertEquals(5, dll.tail?.value)
  }

  @Test
  fun `when odd number of nodes`() {
    val dll = DoublyLinkedList(1)
    dll.append(2).append(3).append(4).append(5)
    dll.swapPairs()
    Assertions.assertArrayEquals(intArrayOf(2, 1, 4, 3, 5), dll.toArray())
    Assertions.assertEquals(2, dll.head?.value)
    Assertions.assertEquals(5, dll.tail?.value)
  }

  @Test
  fun `when only 2 nodes`() {
    val dll = DoublyLinkedList(1)
    dll.append(2)
    dll.swapPairs()
    Assertions.assertArrayEquals(intArrayOf(2, 1), dll.toArray())
    Assertions.assertEquals(2, dll.head?.value)
    Assertions.assertEquals(1, dll.tail?.value)
  }

  @Test
  fun `when is only 1 node`() {
    val dll = DoublyLinkedList(1)
    dll.swapPairs()
    Assertions.assertArrayEquals(intArrayOf(1), dll.toArray())
    Assertions.assertEquals(1, dll.head?.value)
    Assertions.assertEquals(1, dll.tail?.value)
  }
  //</editor-fold>

}
