package de.fhaachen.nullstellenrechner;

import de.fhaachen.funktionen.Function;

import java.util.ArrayList;

/**
 * Created by jrocke on 14.11.16.
 */
public class TestRoot {
    public static void main(String[] args){
        ArrayList<Function> testFunctions = new ArrayList<Function>();

        testFunctions.add(new Function() {
            @Override
            public double getY(double x) {
                return Math.exp(x)-4d;
            }
        });

        testFunctions.add(new Function() {
            @Override
            public double getY(double x) {
                return Math.log(Math.abs(x+1)) - Math.sin(2*x) - 0.5d;
            }
        });

        testFunctions.add(new Function() {
            @Override
            public double getY(double x) {
                return (x * x) - Math.sin(x) - 1d;
            }
        });

        testFunctions.add(new Function() {
            @Override
            public double getY(double x) {
                return Math.pow(x,4d) + Math.pow(x,3) - 5;
            }
        });
    }
}
