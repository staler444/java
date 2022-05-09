package pac.stale;

import pac.Wr;
import pac.funkcje.Funkcja;

public class Stala extends Wr{
    public static int pior = 3;

    private double val; 

    public Stala(double li){
        super(Stala.pior);
        this.val = li;
    }

    public static Stala nowy(double li){
        if(li == 0.0)
            return StalaZero.nowy();
        if(li == 1.0)
            return StalaJeden.nowy();
        return new Stala(li);
    }

    // dodawanie 
    public Wr dodaj(Wr wyr){
        return wyr.dodaj((Stala)this);
    }
    @Override
    public Wr dodaj(Stala sta){
        return Stala.nowy(sta.getVal() + val);
    }

    // odejmowanie
    public Wr odejm(Wr wyr){
        return wyr.odejm((Stala)this);
    }
    @Override
    public Wr odejm(Stala sta){
        return Stala.nowy(sta.getVal() - val);
    }

    // mnozenie 
    public Wr mnoz(Wr wyr){
        if(getSigma())
            if(wyr.flipSigma()){
                wyr = wyr.repair();
                flipSigma();
            }
        return wyr.mnoz((Stala)this);
    }
    @Override
    public Wr mnoz(Stala sta){
        return Stala.nowy(sta.getVal()*val);
    }

    //obsluga skracania minusów
    public boolean flipSigma(){
        if(val < 0){
            val = -val;
            return true;
        }
        return false;
    }
    public boolean getSigma(){
        return val < 0; 
    }

    @Override
    public Wr repair(){
        return Stala.nowy(val);
    }

    // reszta 
    public Wr obliczPochodna(){
        return Stala.nowy(0);
    }

    public double oblicz(double x){
        return val;
    }

    public double getVal(){
        return val;
    }

    @Override
    public Stala budujFunckje(Funkcja fun){
        return Stala.nowy(fun.oblicz(val));
    } 

    @Override
    public String toString(){
        return Double.toString(val);
    }
}