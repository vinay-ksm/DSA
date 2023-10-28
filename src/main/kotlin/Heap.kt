class Heap {
  val heap: ArrayList<Int> = ArrayList()

  /**
   * method to insert a new value to the heap
   */
  fun insert(value: Int): ArrayList<Int> {
    heap.add(value)
    var currentNodePosition = heap.size - 1
    var parent = parent(currentNodePosition)
    while (parent != null && heap[parent] < value) {
      heap[currentNodePosition] = heap[parent]
      heap[parent] = value
      currentNodePosition = parent
      parent = parent(currentNodePosition)
    }
    return heap
  }

  /**
   * method to remove the top node from the heap
   */
  fun remove(): Int?{
    if(heap.size == 0){
      return null
    }
    if (heap.size == 1){
      return heap.removeFirst()
    }
    val top = heap[0]
    heap[0] = heap.removeAt(heap.size - 1)
    val current = heap[0]
    var currentIndex = 0
    var left = leftChild(currentIndex)
    var right = rightChild(currentIndex)
    while((left < heap.size && heap[left] > current) || (right < heap.size && heap[right] > current)){
      if (heap[left] > heap[right]){
        swap(left, currentIndex)
        currentIndex = left
      } else {
        swap(right, currentIndex)
        currentIndex = right
      }
      left = leftChild(currentIndex)
      right = rightChild(currentIndex)
    }

    return top
  }

  private fun parent(i: Int) = (i - 1) / 2

  private fun leftChild(i: Int) = (i * 2) + 1

  private fun rightChild(i: Int) = (i * 2) + 2

  private fun swap(i1: Int, i2: Int ){
    val temp = heap[i1]
    heap[i1] = heap[i2]
    heap[i2] = temp
  }
}

fun streamMax(nums: IntArray): IntArray{
  val result = ArrayList<Int>()
  val maxHeap = Heap()
  for(num in nums){
    maxHeap.insert(num)
    result.add(maxHeap.heap[0])
  }
  return result.toIntArray()
}

fun findKthSmallest(nums: IntArray, k: Int): Int{
  val heap = Heap()
  for(n in nums){
    heap.insert(n)
  }
  while(heap.heap.size > k){
    heap.remove()
  }
  return heap.remove()!!
}

fun main(){
  val result = streamMax(intArrayOf(4,3,2,1))
  for(n in result){
    print("$n")
  }
}
