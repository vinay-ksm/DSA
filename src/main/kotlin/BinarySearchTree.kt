class BinarySearchTree(value: Int?) {
  data class BSTNode(var value: Int?, var left: BSTNode?, var right: BSTNode?)

  var nodes: Int = 0

  var root: BSTNode? = null

  init {
    if (value != null) {
      val node = BSTNode(value, null, null)
      root = node
      nodes++
    }
  }

  /**
   * method to insert a new node
   */
  fun insert(nodeValue: Int) {
    nodes++
    val node = BSTNode(nodeValue, null, null)
    if (root == null) {
      root = node
      return
    }

    var current = root
    var temp = current

    while (current != null) {
      temp = current
      if (nodeValue < current.value!!) {
        current = current.left
      } else {
        current = current.right
      }
    }

    if (nodeValue < temp!!.value!!) {
      temp.left = node
    } else {
      temp.right = node
    }
  }

  /**
   * method to check if a value exists in the tree
   */
  fun contains(value: Int): Boolean {
    var current = root
    while (current != null) {
      if (value == current.value) {
        return true
      }
      if (value < current.value!!) {
        current = current.left
      } else {
        current = current.right
      }
    }

    return false
  }

  /**
   * method to check if a value exists in the tree recursively
   */
  fun rContains(value: Int): Boolean {
    return rContains(root, value)
  }

  private fun rContains(node: BSTNode?, value: Int): Boolean {
    if (node == null) return false

    if (node.value == value) return true

    if (value < node.value!!) {
      return rContains(node.left, value)
    } else {
      return rContains(node.right, value)
    }
  }

  /**
   * method to insert a new value recursively
   */
  fun rInsert(value: Int) {
    nodes++
    if (root == null) {
      val node = BSTNode(value, null, null)
      root = node
      return
    }
    rInsert(root, value)
  }

  private fun rInsert(currentNode: BSTNode?, value: Int): BSTNode {
    if (currentNode == null) {
      return BSTNode(value, null, null)
    }
    if (value < currentNode.value!!) {
      currentNode.left = rInsert(currentNode.left, value)
    } else if (value > currentNode.value!!) {
      currentNode.right = rInsert(currentNode.right, value)
    }
    return currentNode
  }

  /**
   * Method to delete a node
   */
  fun deleteNode(value: Int): BSTNode? {
    if (root == null) return null
    return rDeleteNode(root!!, value)
  }

  private fun rDeleteNode(node: BSTNode?, value: Int): BSTNode? {
    var currentNode = node ?: return null

    if (value < currentNode.value!!) {
      currentNode.left = rDeleteNode(currentNode.left, value)
    } else if (value > currentNode.value!!) {
      currentNode.right = rDeleteNode(currentNode.right, value)
    } else {
      nodes--
      if (currentNode.left == null && currentNode.right == null) {
        return null
      } else if (currentNode.left == null) {
        currentNode = currentNode.right!!
      } else if (currentNode.right == null) {
        currentNode = currentNode.left!!
      } else {
        val subTreeMin = minimumValueNode(currentNode.right!!)
        currentNode.value = subTreeMin
        currentNode.right = rDeleteNode(currentNode.right, subTreeMin)
      }
    }
    return currentNode
  }

  /**
   * Helper method to return min value from a given node
   */
  fun minimumValueNode(node: BSTNode): Int{
    var currentNode = node
    while(currentNode.left != null){
      currentNode = currentNode.left!!
    }
    return currentNode.value!!
  }

}
