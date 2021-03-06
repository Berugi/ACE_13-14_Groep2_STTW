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
 * @version 20131229-01 - Tom Scheepers - added init observers in constructors
 * 
 */
public class ObservableQuizCatalogus extends QuizCatalogus implements
		IObservable, Cloneable, Iterable<Quiz> {

	private ArrayList<IObserver> observers;

	public ObservableQuizCatalogus() {
		super();
		this.observers = new ArrayList<IObserver>();

	}

	public ObservableQuizCatalogus(String fileName) throws IOException {

		super(fileName);
		this.observers = new ArrayList<IObserver>();
	}

	@Override
	public Iterator<Quiz> iterator() {

		return super.iterator();

	}

	@Override
	public boolean add(Quiz q) {

		if (q == null)
			return false;

		boolean result = super.add(q);
		notifyObservers();
		return result;

	}

	@Override
	public boolean remove(Quiz q) {

		if (q == null)
			return false;

		boolean result = super.remove(q);
		notifyObservers();
		return result;

	}

	public boolean contains(Quiz q) {

		return super.quizen.contains(q);

	}

	public void addObserver(IObserver observer) {

		if (observer != null)
			this.observers.add(observer);

	}

	public void removeObserver(IObserver observer) {

		if (observer != null)
			this.observers.remove(observer);

	}

	private void notifyObservers() {

		for (IObserver o : observers) {

			o.update(this);

		}

	}

}
