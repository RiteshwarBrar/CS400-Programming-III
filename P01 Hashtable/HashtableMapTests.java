import java.util.NoSuchElementException;

// --== CS400 Project One File Header ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: Blue
// Group: CD
// TA: Harper
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
public class HashtableMapTests {

  /**
   * This method checks the functionality of HashtableMap.put()
   * 
   * @return true only if no errors occur while testing put()
   */
  @SuppressWarnings("unchecked")
  public static boolean test1() {
    try {
      @SuppressWarnings("rawtypes")
      HashtableMap hash = new HashtableMap();
      if (!hash.put(13, "Ron")) // making valid entries which should make put() return true
        return false;
      if (!hash.put(12, "Steve"))
        return false;
      if (!hash.put(14, "Tony"))
        return false;
      if (hash.put(null, null)) // making invalid entry(null) which should make put() return false
        return false;
      if (hash.put(13, "Ron"))// making invalid entry(repeat) which should make put() return false
        return false;
    } catch (Exception e) { // catches any unwanted exception if thrown while testing put()
      return false;
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  /**
   * This method checks the functionality of HashtableMap.get()
   * 
   * @return true only if no errors occur while testing get()
   */
  public static boolean test2() {
    try {
      @SuppressWarnings("rawtypes")
      HashtableMap hash = new HashtableMap();
      hash.put(13, "Rhodey");
      hash.put(12, "Steve");
      hash.put(14, "Tony");
      if (!hash.get(13).equals("Rhodey")) {// checks for an existing node
        return false;
      }
      if (!hash.get(14).equals("Tony")) {// checks for an existing node
        return false;
      }
      hash.get(16);// invalid key which should throw a NoSuchElementException
      return false;// if no exception is thrown then test for get() has failed
    } catch (NoSuchElementException e) {
      return true;// this would only execute if get() works properly i.e. successfully gets the
                  // existing elements and throws a NoSuchElementException when the elements doesn't
                  // exist
    } catch (Exception e) { // catches any unwanted exception if thrown while testing get()
      return false;
    }
  }

  @SuppressWarnings("unchecked")
  /**
   * This method checks the functionality of HashtableMap.size()
   * 
   * @return true only if no errors occur while testing size()
   */
  public static boolean test3() {
    try {
      @SuppressWarnings("rawtypes")

      HashtableMap hash = new HashtableMap(2);
      hash.put(13, "Rhodey");
      hash.put(12, "Steve");
      hash.put(14, "Tony");
      hash.put(15, "Muchhi");
      hash.put(16, "Chintu");
      hash.put(17, "Jagga");
      if (hash.size() != 6)
        return false;
    } catch (Exception e) { // catches any unwanted exception if thrown while testing size()
      return false;
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  /**
   * This method checks the functionality of HashtableMap.remove()
   * 
   * @return true only if no errors occur while testing remove()
   */
  public static boolean test4() {
    try {
      @SuppressWarnings("rawtypes")
      HashtableMap hash = new HashtableMap();
      hash.put(13, "Rhodey");
      hash.put(12, "Steve");
      hash.put(14, "Tony");
      if (hash.remove(16) != null)// trying to remove a non-existent element should return null
        return false;
      if (!hash.remove(13).equals("Rhodey"))// removing should return the value for the given key
        return false;
      if (hash.remove(13) != null)// trying to remove an already removed element should return null
        return false;
    } catch (Exception e) { // catches any unwanted exception if thrown
      return false;
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  /**
   * This method checks the functionality of HashtableMap.clear()
   * 
   * @return true only if no errors occur while testing clear()
   */
  public static boolean test5() {
    try {
      @SuppressWarnings("rawtypes")
      HashtableMap hash = new HashtableMap();
      hash.put(13, "Rhodey");
      hash.put(12, "Steve");
      hash.put(14, "Tony");
      hash.put(15, "Mucho");
      hash.put(16, "Chimp");
      hash.put(17, "Jazz");
      hash.clear();
      if (hash.size() != 0)
        return false;
      if (hash.get(12).equals("Steve")) {// should throw a NoSuchElementException as there should be
                                         // no elements in the hashtable
        return false;
      }
      if (hash.get(13).equals("Rhodey")) {
        return false;
      }
      if (hash.get(17).equals("Jazz")) {
        return false;
      }
      // if no exception is thrown then test for clear() has failed as elements are
      // still in the array
    } catch (NoSuchElementException e) {
      return true;// this would only execute if the elements are removed successfully
    } catch (Exception e) { // catches any unwanted exception if thrown
      return false;
    }
    return true;
  }

  public static void main(String Args[]) {
    if (test1() && test2() && test3() && test4() && test5()) {
      System.out.println("All test passed");
    }
    else
      System.out.println("Test(s) failed");
  }
}
