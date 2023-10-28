import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HeapTest {

  //<editor-fold desc="insert() related tests">
  @Test
  fun `insert when empty heap`() {
    val heap = Heap()
    heap.insert(1)
    assertArrayEquals(intArrayOf(1).toTypedArray(), heap.heap.toArray())
  }

  @Test
  fun `insert when heap has elements`() {
    val heap = Heap()
    heap.insert(1)
    heap.insert(2)
    heap.insert(3)
    assertArrayEquals(intArrayOf(3,1,2).toTypedArray(), heap.heap.toArray())
  }

  @Test
  fun `insert when heap has elements in sorted order`() {
    val heap = Heap()
    heap.insert(3)
    heap.insert(2)
    heap.insert(1)
    assertArrayEquals(intArrayOf(3,2,1).toTypedArray(), heap.heap.toArray())
  }

  @Test
  fun `insert when new element needs to be in the middle`() {
    val heap = Heap()
    heap.insert(10)
    heap.insert(8)
    heap.insert(6)
    heap.insert(4)
    heap.insert(2)
    heap.insert(9)
    assertArrayEquals(intArrayOf(10,8,9,4,2,6).toTypedArray(), heap.heap.toArray())
  }
  //</editor-fold>

  //<editor-fold desc="remove() related tests">
  @Test
  fun `remove when empty heap`(){
    val heap = Heap()
    assertNull(heap.remove())
  }

  @Test
  fun `remove when only 1 element heap`(){
    val heap = Heap()
    heap.insert(1)
    assertEquals(1, heap.remove())
    assertEquals(0, heap.heap.size)
  }

  @Test
  fun `remove when only 2 elements heap`(){
    val heap = Heap()
    heap.insert(5)
    heap.insert(1)
    assertEquals(5, heap.remove())
    assertEquals(1, heap.heap.size)
  }

  @Test
  fun `remove when more than 1 element heap`(){
    val heap = Heap()
    heap.insert(1)
    heap.insert(2)
    heap.insert(3)
    heap.insert(4)
    heap.insert(5)
    assertEquals(5, heap.remove())
    assertEquals(4, heap.heap.size)
  }
  //</editor-fold>
}
