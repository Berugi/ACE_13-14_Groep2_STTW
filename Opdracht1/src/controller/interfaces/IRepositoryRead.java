package controller.interfaces;

import java.util.HashSet;

/**
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 *
 * @param <T>
 */
public interface IRepositoryRead<T> {

	HashSet<T> readAll();
	HashSet<T> readSubset();
	T read(T t);
	
}
