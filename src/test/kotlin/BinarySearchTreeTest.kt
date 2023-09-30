import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTreeTest {

  //<editor-fold desc="insert() related tests">
  @Test
  fun `insert when there are nodes in the tree`() {
    var bst = defaultTree()

    assertEquals(47, bst.root?.value)
    assertEquals(76, bst.root?.right?.value)
    assertEquals(21, bst.root?.left?.value)
    assertEquals(18, bst.root?.left?.left?.value)
    assertEquals(27, bst.root?.left?.right?.value)
  }

  @Test
  fun `insert when there are no nodes in the tree`() {
    var bst = BinarySearchTree(null)
    bst.insert(76)
    assertEquals(76, bst.root?.value)
  }
  //</editor-fold>

  //<editor-fold desc="contains related tests">
  @Test
  fun `search for a valid value`() {
    val bst = defaultTree()
    val values = arrayOf(47, 76, 21, 18, 27)
    val result = values.all { bst.contains(it) }
    assertTrue(result)
  }

  @Test
  fun `search for a non existing value`() {
    val bst = defaultTree()
    assertFalse(bst.contains(99))
  }

  @Test
  fun `search in an empty tree`() {
    val bst = BinarySearchTree(null)
    assertFalse(bst.contains(99))
  }
  //</editor-fold>

  //<editor-fold desc="helpers">
  private fun defaultTree(): BinarySearchTree {
    val bst = BinarySearchTree(47)
    bst.insert(76)
    bst.insert(21)
    bst.insert(18)
    bst.insert(27)
    return bst
  }
  //</editor-fold>
}
