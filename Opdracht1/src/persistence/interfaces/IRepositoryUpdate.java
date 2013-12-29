package persistence.interfaces;

import java.util.HashSet;

/**
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 *
 * @param <T>
 */
public interface IRepositoryUpdate<T> {

	boolean update(T t);
	boolean updateSubset(HashSet<T> subset);
	
}
