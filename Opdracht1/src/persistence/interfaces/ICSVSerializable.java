package persistence.interfaces;

/**
 * Generic interface for serializing and deserializing CSV strings to objects and vice-versa.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 *
 * @param <T>
 */
public interface ICSVSerializable<T> {
	
	String serialize(T t);
	T deserialize(String csvString);
	
}
