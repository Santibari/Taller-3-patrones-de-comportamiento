package edu.unisabana.dyas.patterns.observer.impl;

/**
 * @author cesarvefe
 
 */
public interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyAllObservers(String command, Object source);
}