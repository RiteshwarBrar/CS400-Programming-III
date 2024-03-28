// --== CS400 File Header Information ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: CD
// TA: Harper Cao
// Lecturer: Florian Heimerl
// Notes to Grader: no notes

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestRedBlackTree {

  /**
   * tests the basic addition of nodes along with necessary rotation and re-coloring.
   */
  @Test
  public void RBTbasicTestForColor() {
    RedBlackTree _instance = new RedBlackTree();
    _instance.insert(4);
    _instance.insert(1);
    _instance.insert(8);
    _instance.insert(3);
    assertEquals(_instance.root.toString(), "[4, 1, 8, 3]");
    assertEquals(_instance.root.isBlack, true);
    assertEquals(_instance.root.rightChild.isBlack, true);
    assertEquals(_instance.root.leftChild.rightChild.isBlack, false);
  }

  /**
   * tests the line scenario when when the the parent's sibling node is null
   */
  @Test
  public void RBTblackUncleLineScenario() {
    RedBlackTree _instance = new RedBlackTree();
    _instance.insert(20);
    _instance.insert(12);
    _instance.insert(28);
    _instance.insert(23);
    _instance.insert(22);
    assertEquals(_instance.root.toString(), "[20, 12, 23, 22, 28]");
    assertEquals(_instance.root.rightChild.isBlack, true);
    assertEquals(_instance.root.rightChild.rightChild.isBlack, false);
    assertEquals(_instance.root.rightChild.leftChild.isBlack, false);
  }

  /**
   * tests the triangle scenario when the the parent's sibling node is null. After the triangle
   * scenario enforceRBTreePropertiesAfterInsert() calls it self recursively to resolve the line
   * scenario. Also checks the correctness of re-coloring of nodes when required
   */
  @Test
  public void RBTblackUncleTriangleScenario() {
    RedBlackTree _instance = new RedBlackTree();
    _instance.insert(4);
    _instance.insert(3);
    _instance.insert(5);
    _instance.insert(8);
    _instance.insert(2);
    _instance.insert(7);
    assertEquals(_instance.root.rightChild.isBlack, true);
    assertEquals(_instance.root.rightChild.rightChild.isBlack, false);
    assertEquals(_instance.root.rightChild.leftChild.isBlack, false);
    assertEquals(_instance.root.toString(), "[4, 3, 7, 2, 5, 8]");
  }

  /**
   * 
   */
  @Test
  public void RBTredUncleScenario() {
    RedBlackTree _instance = new RedBlackTree();
    _instance.insert(10);
    _instance.insert(8);
    _instance.insert(15);
    _instance.insert(12);
    _instance.insert(11);
    _instance.insert(13);
    assertEquals(_instance.root.rightChild.isBlack, false);
    assertEquals(_instance.root.rightChild.rightChild.isBlack, true);
    assertEquals(_instance.root.rightChild.leftChild.isBlack, true);
    assertEquals(_instance.root.toString(), "[10, 8, 12, 11, 15, 13]");
  }

}
