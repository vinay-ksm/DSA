class HashTable {
  data class HashTableNode(var key: String, var value: Int?, var next: HashTableNode?)

  private val size = 7
  private val dataMap = Array<HashTableNode?>(size) { null }

  /**
   * simple hash method, to enable even distribution of keys across the map
   */
  fun hash(key: String): Int {
    var hash = 0
    val keyChars = key.toCharArray()
    for (i in keyChars.indices) {
      val asciiValue: Int = keyChars[i].code
      hash = (hash + asciiValue * 23) % dataMap.size
    }

    return hash
  }

  /**
   * Method to set a value for a given key
   */
  fun set(key: String, value: Int) {
    val index = hash(key)
    val node = HashTableNode(key, value, null)
    if (dataMap[index] == null) {
      dataMap[index] = node
    } else {
      var current = dataMap[index]
      while (current!!.next != null) {
        current = current.next
      }
      current.next = node
    }
  }

  /**
   * method to get the value for a given key
   */
  fun get(key: String): Int? {
    val index = hash(key)
    var current = dataMap[index]
    while (current != null) {
      if (current.key == key) {
        return current.value
      }
      current = current.next
    }
    return null
  }

  /**
   * method to get all the keys
   */
  fun keys(): List<String> {
    val keys = ArrayList<String>()
    for (i in dataMap.indices) {
      var node = dataMap[i]
      while (node != null) {
        keys.add(node.key)
        node = node.next
      }
    }
    return keys
  }

  fun printTable() {
    for (i in 0 until size) {
      var current = dataMap[i]
      println("$i - ")
      while (current != null) {
        println(" key: ${current.key}, value: ${current.value} ")
        current = current.next
      }
    }
  }
}

fun main() {
  val arr1 = intArrayOf(-1,-2,-3,-4,-5)
  val result = longestConsecutiveSequence(arr1)
  println("$result")
}

fun groupAnagrams(strings: Array<String>): List<List<String>>? {
  val store = mutableMapOf<String, ArrayList<String>>()
  for (string in strings) {
    val sortedString = string.toCharArray().sorted().joinToString("")
    if (store.containsKey(sortedString)) {
      val current = store[sortedString]
      current?.add(string)
      store[sortedString] = current!!
    } else {
      store[sortedString] = arrayListOf(string)
    }
  }

  val result = mutableListOf<List<String>>()
  for ((_, value) in store) {
    result.add(value)
  }

  return result
}

fun twoSum(numbers: Array<Int>, target: Int): Array<Int> {
  if (numbers.size < 2) {
    return Array(1) { 0 }
  }
  val result = Array(2) { 0 }
  val complementStore = HashMap<Int, Int>()
  for (n in numbers.indices) {
    complementStore[numbers[n]] = n
  }

  for (n in numbers.indices) {
    val complement = target - numbers[n]
    if (complementStore[complement] != null) {
      result[0] = n
      result[1] = complementStore[complement]!!
      return result
    }
  }

  return Array(0) { 0 }
}

fun subArraySum(nums: IntArray, target: Int): IntArray {
  val result = intArrayOf()
  val store = HashMap<Int, Int>()
  store[0] = -1
  var sum = 0
  for (i in nums.indices) {
    sum += nums[i]
    if (store.containsKey(sum - target)) {
      return intArrayOf(store[(sum - target)]!! + 1, i)
    } else {
      store[sum] = i
    }
  }
  return result
}

fun removeDuplicates(myList: List<Int>): List<Int> = ArrayList(HashSet(myList))

fun hasUniqueChars(string: String): Boolean = string.toCharArray().toHashSet().joinToString("") == string

fun findPairs(arr1: IntArray, arr2: IntArray, target: Int): List<IntArray> {
  val result = ArrayList<IntArray>()
  val mySet = arr1.toHashSet()

  for (i in arr2) {
    val complement = target - i
    if (mySet.contains(complement)) {
      result.add(intArrayOf(complement, i))
    }
  }

  return result
}

fun longestConsecutiveSequence(nums: IntArray): Int {
  if(nums.isEmpty()){
    return 0;
  }
  var longest = 1

  var mySet = nums.toHashSet()

  for (i in nums) {
    if (mySet.contains(i + 1) && !mySet.contains(i-1)) {
      var done = false
      var temp = i
      var tempLongest = 1
      while (!done) {
        mySet.remove(temp)
        if(mySet.contains(temp + 1)){
          tempLongest++
          temp++
        } else {
          done = true
        }
      }
      if(tempLongest > longest){
        longest = tempLongest
      }
    }
  }

  return longest
}

