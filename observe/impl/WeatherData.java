package com.designPattern.observe.impl;

import java.util.ArrayList;

import com.designPattern.observe.interfaces.Observer;
import com.designPattern.observe.interfaces.Subject;

public class WeatherData implements Subject {

	private ArrayList<Observer> observes;
	private float temperature;
	private float humidity;
	private float pressure;
	public WeatherData(){
		observes = new ArrayList<Observer>();
	}
	@Override
	public void registerObserver(Observer observer) {
		observes.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observes.indexOf(observer);
		if(i>=0){
			observes.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		for(Observer o :observes){
			o.update(temperature, humidity, pressure);
		}
	}

	public void measurementChange(){
		notifyObserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChange();
	}
}
