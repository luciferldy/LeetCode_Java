package test;

import sun.rmi.runtime.Log;

import java.util.Observable;
import java.util.Observer;

public class Switch {

    private static String LOG_TAG = Switch.class.getSimpleName();

    public static void main(String[] args) {
        SimpleObservable observable = new SimpleObservable();
        Observer o1 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("o1 update.");
            }
        };

        Observer o2 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("o2 update.");
            }
        };
        observable.addObserver(o1);
        observable.addObserver(o2);

        observable.change();
        observable.notifyObservers();

        STATE state = STATE.ON;

    }

    static class SimpleObservable extends Observable {
        public synchronized void change(){
            setChanged();
        }
    }

    enum STATE {
        ON, HALFWAY, OFF
    }
}
