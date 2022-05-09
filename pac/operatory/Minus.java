package pac.operatory;

import pac.Wr;
import pac.stale.Stala;
import pac.Zmienna;
import pac.funkcje.Funkcja;

public class Minus extends Operator{
    private static String mychar = "-";
    private static int pior = 0;

    public Minus(Wr l, Wr r){
        super(Minus.pior, l, r);
    }

    public static Wr nowy(Wr l, Wr r){
        if(r.getSigma()){
            r.flipSigma();
            r = r.repair();
            return Plus.nowy(l, r);
        }
        if(l.getSigma()){
            l.flipSigma();
            l = l.repair();
            return Iloczyn.nowy(Stala.nowy(-1), Plus.nowy(l, r));
        }
        return l.odejm(r);
    }

    // do opuszczanie nawiasów
    @Override 
    public Wr odejm(Stala sta){
        return new Minus(sta, new Plus(l, r));
    }
    @Override 
    public Wr odejm(Operator oper){
        return new Minus(oper, new Plus(l, r));
    }
    @Override 
    public Wr odejm(Zmienna x){
        return new Minus(x, new Plus(l, r));
    }
    @Override 
    public Wr odejm(Funkcja fun){
        return new Minus(fun, new Plus(l, r));
    }

    public Wr obliczPochodna(){
        return Minus.nowy(l.getPochodna(), r.getPochodna()); 
    }

    public double oblicz(double x){
        return l.oblicz(x) - r.oblicz(x);
    }

    public String getMyChar(){
        return mychar;
    }
}
