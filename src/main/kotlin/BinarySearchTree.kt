class BinarySearchTree(value: Int?) {
  data class BSTNode(var value: Int?, var left: BSTNode?, var right: BSTNode?)

  var root: BSTNode? = null

  init {
    if (value != null) {
      val node = BSTNode(value, null, null)
      root = node
    }
  }

  /**
   * method to insert a new node
   */
  fun insert(nodeValue: Int) {
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
      if (value < current.value!!){
        current = current.left
      } else {
        current = current.right
      }
    }

    return false
  }
}
