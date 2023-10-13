import io.kotest.property.Arb
import io.kotest.property.arbitrary.single
import io.kotest.property.arbitrary.string
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HashTableTest {

  @Test
  fun hash() {
    for (i in 0..1000) {
      assertTrue(HashTable().hash(Arb.string(10).single()) < 7)
      assertFalse(HashTable().hash(Arb.string(10).single()) >= 7)
    }
  }

  @Test
  fun `get and set tests when getting valid key`() {
    val hashTable = HashTable()
    hashTable.set("foo", 0)
    hashTable.set("bar", 1)
    hashTable.set("baz", 2)
    hashTable.set("two", 3)
    hashTable.set("hey", 4)
    hashTable.set("you", 5)
    assertEquals(2, hashTable.get("baz"))
  }

  @Test
  fun `get non-exitent key`() {
    val hashTable = HashTable()
    hashTable.set("foo", 0)
    assertNull(hashTable.get("baz"))
  }

  @Test
  fun keys() {
    val hashTable = HashTable()
    hashTable.set("foo", 0)
    hashTable.set("bar", 1)
    hashTable.set("baz", 2)
    hashTable.set("two", 3)
    hashTable.set("hey", 4)
    hashTable.set("you", 5)
    assertEquals(6, hashTable.keys().size)
  }
}
