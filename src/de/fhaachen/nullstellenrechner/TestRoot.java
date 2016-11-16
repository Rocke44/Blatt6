package de.fhaachen.nullstellenrechner;

import de.fhaachen.funktionen.Function;
import de.fhaachen.nullstellenmethoden.BisectionMethod;
import de.fhaachen.nullstellenmethoden.Method;

import java.util.ArrayList;

/**
 * Created by jrocke on 14.11.16.
 */
public class TestRoot {
    public static void main(String[] args){
        ArrayList<Function> testFunctions = new ArrayList<Function>();

        testFunctions.add(x -> Math.exp(x)-4d);

        testFunctions.add(x -> Math.log(Math.abs(x+1)) - Math.sin(2*x) - 0.5d);

        testFunctions.add(x -> (x * x) - Math.sin(x) - 1d);

        testFunctions.add(x -> Math.pow(x,4d) + Math.pow(x,3) - 5);

        Method bisectional = new BisectionMethod();

        for(Function func : testFunctions){
            try {
                System.out.println(bisectional.findRoot(func, 0, 10));
            }catch (ArithmeticException e){
                System.out.println(e);
            }
        }
    }
}
