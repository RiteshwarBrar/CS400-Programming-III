// --== CS400 Project One File Header ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: Blue
// Group: CD
// TA: Harper
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * 
 * @author Riteshwar Singh Brar
 * 
 *         Class that implements appropriate methods to create a hashtable
 * 
 * @param <KeyType>       data type for the key in the key-value pair of an element in the hashtable
 * @param <ValueType>data type for the value in the key-value pair of an element in the hashtable
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private int capacity;// stores the value for the capacity of the array
  private LinkedList<node<KeyType, ValueType>> arr[];
  private int size = 0;// stores the number of elements in the hashtable

  @SuppressWarnings("unchecked")
  /**
   * This is the default constructor that creates an array of size 20
   */
  public HashtableMap() {
    this.capacity = 20;
    arr = new LinkedList[20];
    for (int i = 0; i < capacity; i++) {
      arr[i] = new LinkedList<node<KeyType, ValueType>>();
    }
  }

  @SuppressWarnings("unchecked")
  /**
   * This is a parameterized constructor that creates an array of custom size
   * 
   * @param capacity -the capacity that the user wants to set for the array
   */
  public HashtableMap(int capacity) {
    this.capacity = capacity;
    arr = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      arr[i] = new LinkedList<node<KeyType, ValueType>>();
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  /**
   * This function adds a node to the hashtable
   * 
   * @param key   -for the key to be stored in the hashtable
   * @param value -for the value to be stored in the hashtable
   * @return -true only if the node was added successfully
   */
  public boolean put(KeyType key, ValueType value) {
    if (key == null || this.containsKey(key)) {
      return false;
    } else {
      if (checkLoad()) {
        rehash();
      }
      int index = Math.abs(key.hashCode()) % capacity;
      arr[index].add(new node(key, value));
      size++;
      return true;
    }

  }

  /**
   * This is the helper method for put() which checks if load factor is more than or equal to 80%
   * 
   * @return -true if load factor is more than or equal to 80%
   */
  private boolean checkLoad() {
    double loadFactor = (size + 1) / (double) capacity;

    if (loadFactor >= 0.8) {
      return true;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  /**
   * This is the helper method for put() which implements rehashing when required
   */
  private void rehash() {
    LinkedList<node<KeyType, ValueType>> old[] = arr;
    arr = new LinkedList[capacity * 2];
    for (int i = 0; i < capacity * 2; i++) {
      arr[i] = new LinkedList<node<KeyType, ValueType>>();
    }
    capacity *= 2;
    size = 0;
    
    for (int i = 0; i < capacity / 2; i++) {
      int j = 0;
      while (!old[i].isEmpty() && old[i].get(j) != null) {// reloaction of elements from the older
                                                          // version to the newer version after
                                                          // increment in size
        put(old[i].get(j).getKey(), old[i].get(j).getValue());

        if (old[i].get(j).equals(old[i].getLast())) {// to make sure that loop stops at last node
                                                     // and doesn't go out of bounds
          break;
        }
        j++;
      }
    }

  }

  @Override
  /**
   * This method gets the value in the hashtable for a key passed as a parameter and throws a
   * NoSuchElementException when the given key is not in the hashtable
   * 
   * @param key- the key whose value we need to get
   * @return -the value for the key passed a parameter
   */
  public ValueType get(KeyType key) throws NoSuchElementException {
    int index = Math.abs(key.hashCode()) % capacity;
    int j = 0;

    while (!arr[index].isEmpty() && arr[index].get(j) != null) {
      if (arr[index].get(j).getKey().equals(key))
        return arr[index].get(j).getValue();

      if (arr[index].get(j).equals(arr[index].getLast())) {// to make sure that loop stops at last
                                                           // node and doesn't go out of bounds
        break;
      }
      j++;
    }
    throw new NoSuchElementException();
  }

  @Override
  /**
   * This is a getter method for the number of elements in the Hashtable
   * 
   * @return- the number of elements present in the Hashtable
   */
  public int size() {
    return size;
  }

  @Override
  /**
   * This method checks whether the hashtable contains a particular key value.
   * 
   * @param key -for the key that needs to be checked for
   * @return- true if the key is present in the hashtable else return false
   */
  public boolean containsKey(KeyType key) {
    try {
      get(key);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @Override
  /**
   * This method removes a particular key and its value from the hashtable
   * 
   * @param key- for the key that needs to be removed
   * @return null if the key isn't in the hashtable else returns the removed value
   */
  public ValueType remove(KeyType key) {
    if (!containsKey(key)) {
      return null;
    }
    ValueType temp = get(key);
    int index = Math.abs(key.hashCode()) % capacity;
    int j = 0;

    while (arr[index].get(j) != null) {// traverses the nodes at a particular index then looks for
                                       // the node to be removed
      if (arr[index].get(j).getKey().equals(key)) {
        arr[index].remove(j);
        break;
      }
      if (arr[index].get(j).equals(arr[index].getLast())) {
        break;
      }
      j++;
    }
    size--;
    return temp;
  }

  @SuppressWarnings("unchecked")
  @Override
  /**
   * This method clears up the array and resets all its elements
   */
  public void clear() {
    arr = new LinkedList[capacity];// the array is emptied and each element is made a new empty node

    for (int i = 0; i < capacity; i++) {
      arr[i] = new LinkedList<node<KeyType, ValueType>>();
    }
    size = 0;
  }

}
