package de.fhaachen.nullstellenmethoden;

import de.fhaachen.funktionen.Function;

/**
 * Created by jrocke on 11/18/16.
 */
public class SecantMethod implements Method {
    @Override
    public double findRoot(Function f , double xMin , double xMax ){
        double a = Math.min(xMin,xMax);
        double b = Math.max(xMin,xMax);
        Function g;

        if(Math.signum(f.getY(a))==Math.signum(f.getY(b))){
            throw new ArithmeticException("Not sure if f(x)=0 exists");
        }
        if(f.getY(a)>f.getY(b)){
            g = x -> (-1.0 * f.getY(x));
        }else{
            g = f;
        }

        double m = (a*g.getY(b)-b*g.getY(a))/(g.getY(b)-g.getY(a));

        while(! (Math.abs( g.getY(m) ) < Math.pow(10,-10) ) ){
            if(g.getY(m) < 0){
                a = m;
            }else{
                b = m;
            }
            m = (a*g.getY(b)-b*g.getY(a))/(g.getY(b)-g.getY(a));
        }

        return m;
    }
}
