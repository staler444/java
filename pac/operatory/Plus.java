package pac.operatory;

import pac.Wr;
import pac.Zmienna;
import pac.funkcje.Funkcja;
import pac.stale.Stala;

public class Plus extends Operator {
    public static String mychar = "+";
    public static int pior = 0;

    public Plus(Wr l, Wr r){
        super(Plus.pior, l, r);
    }

    public static Wr nowy(Wr l, Wr r){
        if(r.getSigma()){
            r.flipSigma();
            r = r.repair();
            return Minus.nowy(l, r);
        }
        if(l.getSigma()){
            l.flipSigma();
            l = l.repair();
            return Minus.nowy(r, l);
        }
        return l.dodaj(r);
    }

    // do opuszczanie nawiasów
    @Override 
    public Wr odejm(Stala sta){
        return new Minus(sta, new Minus(l, r));
    }
    @Override 
    public Wr odejm(Operator oper){
        return new Minus(oper, new Minus(l, r));
    }
    @Override 
    public Wr odejm(Zmienna x){
        return new Minus(x, new Minus(l, r));
    }
    @Override 
    public Wr odejm(Funkcja fun){
        return new Minus(fun, new Minus(l, r));
    }

    public Wr obliczPochodna(){
        return Plus.nowy(l.getPochodna(), r.getPochodna());
    }

    public double oblicz(double x){
        return l.oblicz(x) + r.oblicz(x);
    }

    public String getMyChar(){
        return mychar;
    }
}
