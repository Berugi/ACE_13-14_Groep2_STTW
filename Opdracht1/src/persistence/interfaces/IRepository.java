package persistence.interfaces;

/**
 * Generic interface that defines basic repository functionality.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 Initial commit
 * @param <T>
 */
public interface IRepository<T> {
	
	//nog niet helemaal af, niet te veel op baseren... (Wim)
	boolean write(T... objs);
	T[] read();
	boolean update(T... objs);
	boolean delete(T... objs);
	
}
