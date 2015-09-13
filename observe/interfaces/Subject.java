package com.designPattern.observe.interfaces;

public interface Subject {

	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObserver();
}
