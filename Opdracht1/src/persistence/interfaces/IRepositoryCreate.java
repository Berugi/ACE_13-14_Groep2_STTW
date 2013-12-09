package persistence.interfaces;

/**
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 *
 * @param <T>
 */
public interface IRepositoryCreate<T> {
	
	void create(T t);
	
}
