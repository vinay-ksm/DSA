import com.sun.tools.javac.Main
import java.util.ArrayList

class Graph {
  val adjList = HashMap<String, ArrayList<String>>()

  /**
   * method to add a new vertex
   */
  fun addVertex(vertex: String): Boolean{
    if(adjList.containsKey(vertex)) return false
    adjList[vertex] = ArrayList<String>()
    return true
  }

  /**
   * method to add an edge between two vertices
   */
  fun addEdge(vertex1: String, vertex2: String): Boolean{
    if(!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) return false

    adjList[vertex1]?.add(vertex2)
    adjList[vertex2]?.add(vertex1)
    return true
  }

  /**
   * method to remove an edge between two vertices
   */
  fun removeEdge(vertex1: String, vertex2: String): Boolean{
    if(!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)){
      return false
    }

    adjList[vertex1]?.remove(vertex2)
    adjList[vertex2]?.remove(vertex1)
    return true
  }

  /**
   * method to remove a vertex
   */
  fun removeVertex(vertex: String): Boolean{
    if(!adjList.containsKey(vertex)) return false

    for(k in adjList){
      k.value.remove(vertex)
    }

    adjList.remove(vertex)
    return true
  }


  fun printGraph(){
    for(k in adjList){
      println("key: $k")
    }
  }
}

fun main(){
  val graph = Graph()
  graph.addVertex("A")
  graph.addVertex("B")
  graph.addVertex("C")
  graph.addEdge("A", "B")
  graph.addEdge("A", "C")
  graph.addEdge("B", "C")
//  graph.removeEdge("A", "B")
  graph.printGraph()
  graph.removeVertex("A")
  graph.printGraph()
}
