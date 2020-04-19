package com.xfc.spring.clound.config.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  08:51
 * @description: spring cloud预备知识
 */
public class ObServerPreKnowledgeDemo {


    public static void main(String[] args) {

        CustomObserverable observable = new CustomObserverable();

        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {

                System.out.println("o = " + o.toString());
                System.out.println("arg = " + arg.toString());
            }
        });
        observable.setChanged();

        observable.notifyObservers("hello");


    }

    public static class CustomObserverable extends Observable {

        /**
         * Marks this <tt>Observable</tt> object as having been changed; the
         * <tt>hasChanged</tt> method will now return <tt>true</tt>.
         */
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }
}
