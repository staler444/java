package pac;

import pac.stale.Stala;
import pac.operatory.Iloczyn;

public class Zmienna extends Wr{
    private static String mychar = "x";
    private static int pior = 3;
    private static Zmienna zmienna = null;
    
    public Zmienna(){
        super(pior);
        zmienna = this;
    }

    public static Zmienna nowy(){
        if(zmienna == null)
            return new Zmienna();
        return zmienna;
    }

    public Wr dodaj(Wr wyr){
        return wyr.dodaj((Zmienna)this);
    }
    public Wr odejm(Wr wyr){
        return wyr.odejm((Zmienna)this);
    }
    @Override 
    public Wr odejm(Zmienna x){
        return Stala.nowy(0);
    }
    public Wr mnoz(Wr wyr){
        return wyr.mnoz((Zmienna)this);
    }

    public double oblicz(double x){
        return x;
    }

    public Wr obliczPochodna(){
        return Stala.nowy(1);
    }

    public Wr obliczPierwotna(){
        return Iloczyn.nowy(this, Zmienna.nowy());
    }

    @Override
    public String toString(){
        return mychar;
    }
}