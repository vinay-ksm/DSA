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

  //<editor-fold desc="insert() related tests recursively">
  @Test
  fun `insert when there are nodes in the tree recursively`() {
    var bst = BinarySearchTree(47)
    bst.rInsert(76)
    bst.rInsert(21)
    bst.rInsert(18)
    bst.rInsert(27)

    assertEquals(47, bst.root?.value)
    assertEquals(76, bst.root?.right?.value)
    assertEquals(21, bst.root?.left?.value)
    assertEquals(18, bst.root?.left?.left?.value)
    assertEquals(27, bst.root?.left?.right?.value)
  }

  @Test
  fun `insert when there are no nodes in the tree recursively`() {
    var bst = BinarySearchTree(null)
    bst.rInsert(76)
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

  //<editor-fold desc="contains related tests using recursion">
  @Test
  fun `search for a valid value recursively`() {
    val bst = defaultTree()
    val values = arrayOf(47, 76, 21, 18, 27)
    val result = values.all { bst.rContains(it) }
    assertTrue(result)
  }

  @Test
  fun `search for a non existing value recursively`() {
    val bst = defaultTree()
    assertFalse(bst.rContains(99))
  }

  @Test
  fun `search in an empty tree recursively`() {
    val bst = BinarySearchTree(null)
    assertFalse(bst.rContains(99))
  }
  //</editor-fold>

  @Test
  fun `deleteNode when root is null`(){
    val bst = BinarySearchTree(null)
    val result = bst.deleteNode(1)
    assertNull(result)
  }

  @Test
  fun `deleteNode when value is not in the tree`(){
    val bst = defaultTree()
    bst.deleteNode(100)
    assertEquals(5, bst.nodes)
  }

  @Test
  fun `delete a left leaf node`(){
    val bst = defaultTree()
    bst.deleteNode(18)
    assertEquals(4, bst.nodes)
  }

  @Test
  fun `delete a right leaf node`(){
    val bst = defaultTree()
    bst.deleteNode(76)
    assertEquals(4, bst.nodes)
  }

  @Test
  fun `delete a node where left child is null but has a right child`(){
    val bst = defaultTree()
    bst.insert(100)
    assertTrue(bst.contains(76))
    bst.deleteNode(76)
    assertFalse(bst.contains(76))
  }

  @Test
  fun `delete a node where left child is not null but  right child is null`(){
    val bst = defaultTree()
    bst.insert(70)
    assertTrue(bst.contains(76))
    bst.deleteNode(76)
    assertFalse(bst.contains(76))
  }

  @Test
  fun `delete a node which has both left and right child`(){
    val bst = defaultTree()
    assertTrue(bst.contains(21))
    bst.deleteNode(21)
    assertFalse(bst.contains(21))
    assertEquals(27, bst.root!!.left!!.value)
  }

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
