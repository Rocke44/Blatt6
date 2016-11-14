package de.fhaachen.nullstellenmethoden;

import de.fhaachen.funktionen.Function;

/**
 * Created by jrocke on 14.11.16.
 */
public class BisectionMethod implements Method{
    @Override
    public double findRoot(Function f, double xMin, double xMax){
         double a, b;
        if(xMin<xMax) {
            a = xMin;
            b = xMax;
        }else{
            a = xMax;
            b = xMin;
        }


        double m = (a+b)/2;

        while(! (Math.abs( f.getY(m) ) < Math.pow(10,-10) ) ){
            if(f.getY(m)<0){
                a = m;
            }else{
                b = m;
            }
            m = (a+b)/2;
        }

        return m;
    }
}
