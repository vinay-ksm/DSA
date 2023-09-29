import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StackTest {
  //<editor-fold desc="push() related tests">
  @Test
  fun `push a new value`() {
    val stack = validStack()
    stack.push(4)
    Assertions.assertEquals(4, stack.height)
    Assertions.assertEquals(4, stack.top?.value)
  }

  @Test
  fun `push a new value on empty`() {
    val stack = Stack<Int>(null)
    stack.push(1)
    Assertions.assertEquals(1, stack.height)
    Assertions.assertEquals(1, stack.top?.value)
  }
  //</editor-fold>

  //<editor-fold desc="pop() related tests">
  @Test
  fun `when more than 1 nodes in the stack`() {
    val stack = validStack(5)
    val result = stack.pop()

    Assertions.assertEquals(5, result?.value)
    Assertions.assertEquals(4, stack.top?.value)
    Assertions.assertEquals(4, stack.height)
  }

  @Test
  fun `when only 1 node in the stack`() {
    val stack = validStack(1)
    val result = stack.pop()

    Assertions.assertEquals(1, result?.value)
    Assertions.assertEquals(null, stack.top?.value)
    Assertions.assertEquals(0, stack.height)
  }

  @Test
  fun `when no nodes in the stack`() {
    val stack = Stack<Int>(null)
    val result = stack.pop()

    Assertions.assertEquals(null, result?.value)
    Assertions.assertEquals(null, stack.top?.value)
    Assertions.assertEquals(0, stack.height)
  }
  //</editor-fold>

  //<editor-fold desc="helpers">
  private fun validStack(nodes: Int = 3): Stack<Int> {
    val stack = Stack(1)
    for (i in 2 until nodes + 1) {
      stack.push(i)
    }
    return stack
  }
  //</editor-fold>
}
