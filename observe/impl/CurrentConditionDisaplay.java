package com.designPattern.observe.impl;

import com.designPattern.observe.interfaces.DisplayElement;
import com.designPattern.observe.interfaces.Observer;
import com.designPattern.observe.interfaces.Subject;

public class CurrentConditionDisaplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionDisaplay(Subject weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("当前气象为："+temperature+"°，"+humidity+"%湿度！");
		
	}

	@Override
	public void update(float temp, float humidity, float perssure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
}
