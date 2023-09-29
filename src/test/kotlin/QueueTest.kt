import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QueueTest {

  //<editor-fold desc="enqueue() related tests">
  @Test
  fun `when multiple nodes in queue`() {
    val q = buildQueue()
    q.enqueue(3)
    assertEquals(4, q.length)
    assertEquals(0, q.first?.value)
    assertEquals(3, q.last?.value)
  }

  @Test
  fun `when no nodes in queue`() {
    val q = buildQueue(0)
    q.enqueue(1)
    assertEquals(1, q.length)
    assertEquals(1, q.first?.value)
    assertEquals(1, q.last?.value)
  }
  //</editor-fold>

  @Test
  fun `dequeue when more than 2 nodes in the queue`() {
    val q = buildQueue()
    val result = q.dequeue()
    assertEquals(0, result?.value)
    assertEquals(2, q.length)
    assertEquals(1, q.first?.value)
    assertEquals(2, q.last?.value)
  }

  @Test
  fun `dequeue when there is only 1 node in the queue`() {
    val q = buildQueue(1)
    val result = q.dequeue()
    assertEquals(0, result?.value)
    assertEquals(0, q.length)
    assertNull(q.first)
    assertNull(q.last)
  }

  @Test
  fun `dequeue when there are exactly 2 nodes in the queue`() {
    val q = buildQueue(2)
    val result = q.dequeue()
    assertEquals(0, result?.value)
    assertEquals(1, q.length)
    assertEquals(1, q.first?.value)
    assertEquals(1, q.first?.value)
  }

  @Test
  fun `dequeue when there are no nodes in the queue`() {
    val q = buildQueue(0)
    val result = q.dequeue()
    assertNull(result)
    assertEquals(0, q.length)
    assertNull(q.first)
    assertNull(q.last)
  }

  //<editor-fold desc="helpers">
  private fun buildQueue(nodes: Int = 3): Queue {
    val q = Queue(null)
    for (i in 0 until nodes) {
      q.enqueue(i)
    }
    return q
  }
  //</editor-fold>
}
