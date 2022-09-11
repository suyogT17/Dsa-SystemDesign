package com.systemdesign.designpattern.observer;

import java.util.ArrayList;

//Mostly used in chatting application
//observable - push and observer- pull type implementation
public class WeatherApplicationTest {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        IObserver phone = new Phone(weatherStation);
        IObserver laptop = new Laptop(weatherStation);

        //adding observers
        weatherStation.add(phone);
        weatherStation.add(laptop);

        System.out.println("current Temperature");
        phone.update();
        laptop.update();

        System.out.println("Got Temperature update");
        weatherStation.setTemp(19);
    }
}

interface IObserver {
    void update();
}

class Laptop implements IObserver {
    private WeatherStation weatherStation;

    public Laptop(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public void update() {
        System.out.println("got new temperature from weather application for Laptop: " + weatherStation.getTemp());
    }
}

class Phone implements IObserver {
    private WeatherStation weatherStation;

    public Phone(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public void update() {
        System.out.println("got new temperature from weather application for Phone: " + weatherStation.getTemp());
    }
}

interface IObservable {
    ArrayList<IObserver> observers = new ArrayList<>();

    default void add(IObserver iObserver) {
        observers.add(iObserver);
    }

    default void remove(IObserver iObserver) {
        observers.add(iObserver);
    }

    default void notifyObserver() {
        observers.forEach(IObserver::update);
    }
}

class WeatherStation implements IObservable {
    private int temp;

    void setTemp(int temp) {
        this.temp = temp;
        notifyObserver();
    }

    int getTemp() {
        return temp;
    }
}

