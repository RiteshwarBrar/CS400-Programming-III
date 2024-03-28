// --== CS400 Project One File Header ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: Blue
// Group: CD
// TA: Harper
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
public class node<KeyType, ValueType> {
  private KeyType key;
  private ValueType value;

  public node(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  public KeyType getKey() {
    return key;
  }

  public ValueType getValue() {
    return value;
  }
}
