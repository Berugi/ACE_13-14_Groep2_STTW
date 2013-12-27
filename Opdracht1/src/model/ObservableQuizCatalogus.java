package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.interfaces.IObservable;
import model.interfaces.IObserver;

/**
 * Represents an observable QuizCatalogus
 * 
 * @author Wim Ombelets
 * @version 20131227-01 - initial commit
 * @version 20131227-02 - additional work
 *
 */
public class ObservableQuizCatalogus extends QuizCatalogus implements IObservable, Cloneable, Iterable<Quiz> {

	private ArrayList<IObserver> observers;
	
	public ObservableQuizCatalogus() {
		
		super();
		
	}
	
	public ObservableQuizCatalogus(String fileName) throws IOException {
		
		super(fileName);
		
	}
	
	public Iterator<Quiz> iterator() {
		
		return super.iterator();
		
	}
	
	public boolean add(Quiz q) {
		
		if(q == null)
			return false;
		
		boolean result = super.add(q);
		notifyObservers();
		return result;
	
	}
	
	public boolean remove(Quiz q) {
		
		if(q == null)
			return false;
		
		boolean result = super.remove(q);
		notifyObservers();
		return result;
		
	}
	
	public boolean contains(Quiz q) {
		
		return super.quizen.contains(q);
		
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
		
		Iterator<IObserver> i = this.observers.iterator();
		
		while(i.hasNext()) {
			
			i.next().update(this);
			
		}
		
	}	
	
}
