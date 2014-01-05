package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.baseclasses.Catalogus;
import model.baseclasses.Opdracht;
import model.interfaces.IObservable;
import model.interfaces.IObserver;

/**
 * Represents an observable OpdrachtCatalogus
 * 
 * @author Wim Ombelets
 * @version 20131228-01 - initial commit
 * @version 20131229-01 - Tom Scheepers - added init observers in constructors
 *
 */
public class ObservableOpdrachtCatalogus extends OpdrachtCatalogus implements IObservable, Cloneable, Iterable<Opdracht> {

	private List<IObserver> observers;

	public ObservableOpdrachtCatalogus() {
		
		super();
		this.observers = new ArrayList<IObserver>();
	}
	
	public ObservableOpdrachtCatalogus(String fileName) throws IOException {
		
		super(fileName);
		observers = new ArrayList<IObserver>();
	}
	
	@Override
	public Iterator<Opdracht> iterator() {
		
		return super.iterator();
		
	}
	
	@Override
	public boolean add(Opdracht o) {
		
		if(o == null)
			return false;
		
		boolean result = super.add(o);
		notifyObservers();
		return result;
		
	}
	
	@Override
	public boolean remove(Opdracht o) {
		
		if(o == null)
			return false;
		
		boolean result = super.remove(o);
		notifyObservers();
		return result;
		
	}
	
	public boolean contains(Opdracht o) {
		
		return super.getCatalogus().contains(o);
		
	}
	
	public void addObserver(IObserver observer) {
		
		if(observer != null)
			this.observers.add(observer);
		
	}

	public void removeObserver(IObserver observer) {
		
		if(observer != null)
			this.observers.remove(observer);
		
	}
	
	private void notifyObservers() {
		
		for(IObserver o : this.observers) {
			
			o.update(this);
			
		}
		
	}

	@Override
	public int compareTo(Catalogus o) {
		
		return super.compareTo(o);
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
		
	}

	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
		
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
		
	}

	@Override
	public String toString() {
		
		return super.toString();
		
	}
	
}
