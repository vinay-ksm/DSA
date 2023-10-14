import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GraphTest {

  //<editor-fold desc="addVertex() related tests">
  @Test
  fun `addVertex() when no key present should return true`() {
    val graph = Graph()
    val result = graph.addVertex("A")
    assertTrue(result)
    assertTrue(graph.adjList.containsKey("A"))
  }

  @Test
  fun `addVertex() when key already present should return false`() {
    val graph = Graph()
    graph.addVertex("A")
    val result = graph.addVertex("A")
    assertFalse(result)
    assertTrue(graph.adjList.containsKey("A"))
  }
  //</editor-fold>

  //<editor-fold desc="addEdge() related tests">
  @Test
  fun `addEdge() when both vertices exist`() {
    val graph = Graph()
    val vertex1 = "A"
    val vertex2 = "B"
    graph.addVertex(vertex1)
    graph.addVertex(vertex2)

    val result = graph.addEdge(vertex1, vertex2)
    assertTrue(result)
    assertTrue(graph.adjList["A"]?.size == 1)
    assertTrue(graph.adjList["B"]?.size == 1)
  }

  @Test
  fun `addEdge() when only one of the vertices exist`() {
    val graph = Graph()
    val vertex1 = "A"
    val vertex2 = "B"
    graph.addVertex(vertex1)

    val result = graph.addEdge(vertex1, vertex2)
    assertFalse(result)
    assertTrue(graph.adjList["A"]!!.isEmpty())
  }
  //</editor-fold>

  //<editor-fold desc="removeEdge() related tests">
  @Test
  fun `removeEdge when both vertices are present`() {
    val vertex1 = "A"
    val vertex2 = "B"
    val vertex3 = "C"
    val graph = basicGraph()
    val result = graph.removeEdge(vertex1, vertex3)
    assertTrue(result)
    assertArrayEquals(graph.adjList[vertex1]?.toArray(), arrayOf(vertex2))
    assertArrayEquals(graph.adjList[vertex2]?.toArray(), arrayOf(vertex1, vertex3))
    assertArrayEquals(graph.adjList[vertex3]?.toArray(), arrayOf(vertex2))
  }

  @Test
  fun `removeEdge when one of the vertices is missing`() {
    val graph = Graph()
    val vertex1 = "A"
    val vertex2 = "B"
    graph.addVertex(vertex1)
    graph.addEdge(vertex1, vertex2)
    val result = graph.removeEdge(vertex1, vertex2)
    assertFalse(result)
  }

  @Test
  fun `removeEdge when there is no edge`() {
    val graph = Graph()
    val vertex1 = "A"
    val vertex2 = "B"
    graph.addVertex(vertex1)
    graph.addVertex(vertex2)
    val result = graph.removeEdge(vertex1, vertex2)
    assertTrue(result)
  }
  //</editor-fold>

  //<editor-fold desc="removeVertex() related tests">
  fun `removeVertex() when the vertex is present`() {
    val vertex1 = "A"
    val graph = basicGraph()
    val result = graph.removeVertex(vertex1)
    assertTrue(result)
    assertFalse(graph.adjList.containsKey(vertex1))
    assertArrayEquals(arrayOf("B"), graph.adjList["C"]?.toArray())
    assertArrayEquals(arrayOf("C"), graph.adjList["B"]?.toArray())
  }

  fun `removeVertex() when the vertex is missing`() {
    val vertex1 = "D"
    val graph = basicGraph()
    val result = graph.removeVertex(vertex1)
    assertFalse(result)
  }
  //</editor-fold>

  //<editor-fold desc="helpers">
  private fun basicGraph(): Graph {
    val graph = Graph()
    val vertex1 = "A"
    val vertex2 = "B"
    val vertex3 = "C"
    graph.addVertex(vertex1)
    graph.addVertex(vertex2)
    graph.addVertex(vertex3)
    graph.addEdge(vertex1, vertex2)
    graph.addEdge(vertex2, vertex3)
    graph.addEdge(vertex1, vertex3)
    return graph
  }
  //</editor-fold>
}
