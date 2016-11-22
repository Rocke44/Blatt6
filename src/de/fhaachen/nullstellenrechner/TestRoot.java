package de.fhaachen.nullstellenrechner;

import de.fhaachen.funktionen.Function;
import de.fhaachen.nullstellenmethoden.BisectionMethod;
import de.fhaachen.nullstellenmethoden.Method;
import de.fhaachen.nullstellenmethoden.SecantMethod;

import java.util.ArrayList;

/**
 * Created by jrocke on 14.11.16.
 */
public class TestRoot {
    public static void main(String[] args){
        ArrayList<Function> testFunctions = new ArrayList<Function>();

        testFunctions.add(x -> x-5);

        testFunctions.add(x -> Math.exp(x)-4d);

        testFunctions.add(x -> Math.log(Math.abs(x+1)) - Math.sin(2*x) - 0.5d);

        testFunctions.add(x -> (x * x) - Math.sin(x) - 1d);

        testFunctions.add(x -> Math.pow(x,4d) + Math.pow(x,3) - 5);

        Method bisectional = new BisectionMethod();
        Method secantional = new SecantMethod();
        double bisect, secant, diff;

        for(Function func : testFunctions){
            try {
                bisect = bisectional.findRoot(func, 0, 10);
                secant = secantional.findRoot(func,0,10);
                diff = bisect - secant;
                System.out.println("BisectionMethod: " + bisect);
                System.out.println("SecantMethod: " + secant);
                System.out.println("Difference: " + diff);
            }catch (ArithmeticException e){
                System.out.println(e);
            }
        }
    }
}
