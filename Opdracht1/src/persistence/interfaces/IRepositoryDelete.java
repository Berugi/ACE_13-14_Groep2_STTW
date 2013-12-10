package persistence.interfaces;

import java.util.HashSet;

/**
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 *
 * @param <T>
 */
public interface IRepositoryDelete<T> {

	boolean delete(T t);
	boolean deleteSubset(HashSet<T> subset);
	
}
