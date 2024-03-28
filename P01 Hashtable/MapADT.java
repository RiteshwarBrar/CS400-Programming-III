// --== CS400 Project One File Header ==--
// Name: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Team: Blue
// Group: CD
// TA: Harper
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

    public boolean put(KeyType key, ValueType value);
    public ValueType get(KeyType key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(KeyType key);
    public ValueType remove(KeyType key);
    public void clear();
    
}