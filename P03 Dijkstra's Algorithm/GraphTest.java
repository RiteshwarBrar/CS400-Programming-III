// --== CS400 File Header Information ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: Blue:CD
// TA: Harper Cao
// Lecturer: Florian Heimerl
// Notes to Grader: none

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

  private CS400Graph<String> graph;

  /**
   * Instantiate graph from last week's shortest path activity.
   */
  @BeforeEach
  public void createGraph() {
    graph = new CS400Graph<>();
    // insert vertices A-F
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertVertex("D");
    graph.insertVertex("E");
    graph.insertVertex("F");
    // insert edges from Week 11. Shortest Path Activity
    graph.insertEdge("A", "B", 6);
    graph.insertEdge("A", "C", 2);
    graph.insertEdge("A", "D", 5);
    graph.insertEdge("B", "E", 1);
    graph.insertEdge("B", "C", 2);
    graph.insertEdge("C", "B", 3);
    graph.insertEdge("C", "F", 1);
    graph.insertEdge("D", "E", 3);
    graph.insertEdge("E", "A", 4);
    graph.insertEdge("F", "A", 1);
    graph.insertEdge("F", "D", 1);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to F.
   */
  @Test
  public void testPathCostAtoF() {
    assertTrue(graph.getPathCost("A", "F") == 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to D.
   */
  @Test
  public void testPathCostAtoD() {
    assertTrue(graph.getPathCost("A", "D") == 4);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to D.
   */
  @Test
  public void testPathAtoD() {
    assertTrue(graph.shortestPath("A", "D").toString().equals("[A, C, F, D]"));
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to F.
   */
  @Test
  public void testPathAtoF() {
    assertTrue(graph.shortestPath("A", "F").toString().equals("[A, C, F]"));
  }

  /**
   * step 9: Checks the distance/total weight cost from the vertex A to E (furthest vertex from A).
   */
  @Test
  public void testPathCostAtoE() {
    assertTrue(graph.getPathCost("A", "E") == 6);
  }

  /**
   * step 10: Checks the ordered sequence of data within vertices from the vertex A to E.
   */
  @Test
  public void testPathAtoE() {
    assertTrue(graph.shortestPath("A", "E").toString().equals("[A, C, B, E]"));
  }

  /**
   * step 11: Checks the distance/total weight cost from the vertex B to F.
   */
  @Test
  public void testPathCostBtoF() {
    assertTrue(graph.getPathCost("B", "F") == 3);
  }

  /**
   * step 12: Checks the predecessor of the vertex E in the shortest path from the vertex C to E.
   */
  @Test
  public void testPathCtoE() {
    assertTrue(graph.shortestPath("C", "E").toString().endsWith("B, E]"));
  }

  // step 13:

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to C. (a path with only
   * two vertices)
   */
  @Test
  public void testPathAtoC() {
    assertTrue(graph.getPathCost("A", "C") == 2);
    assertTrue(graph.shortestPath("A", "C").toString().equals("[A, C]"));
  }

  /**
   * Checks the correctness of the dijkstrasShortestPath() method when a non existing vertex is
   * passed as an argument
   */
  @Test
  public void testPathAtoG() {
    boolean condition = false;
    try {
      graph.getPathCost("A", "G");
    } catch (NoSuchElementException e) {
      condition = true;
    }
    assertTrue(condition);
  }

  /**
   * Checks the correctness of the dijkstrasShortestPath() method when there is no possible paths
   * between two vertices
   */
  @Test
  public void testPathAtoK() {
    boolean condition = false;
    graph.insertVertex("K");
    graph.insertEdge("K", "A", 1);// edge from K to A but not the other way around
    try {
      graph.getPathCost("A", "K");
    } catch (NoSuchElementException e) {
      condition = true;
    }
    assertTrue(condition);
  }

  public static void main(String[] args) {
    String className = MethodHandles.lookup().lookupClass().getName();
    String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
    String[] arguments =
        new String[] {"-cp", classPath, "--include-classname=.*", "--select-class=" + className};
    ConsoleLauncher.main(arguments);
  }

}
