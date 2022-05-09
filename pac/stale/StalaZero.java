package pac.stale;

import pac.Wr;
import pac.Zmienna;
import pac.funkcje.Funkcja;
import pac.operatory.*;

public class StalaZero extends Stala{
    private static StalaZero zero = null;

    private StalaZero(){
        super(Stala.pior);
        zero = this;
    }

    public static StalaZero nowy(){
        if(zero == null)
            return new StalaZero();
        return zero;
    }
    // dodawanie 
    @Override 
    public Wr dodaj(Wr wyr){
        return wyr;
    }
    @Override
    public Wr dodaj(Stala sta){
        return sta;
    }
    @Override 
    public Wr dodaj(Operator oper){
        return oper;
    }
    @Override
    public Wr dodaj(Zmienna x){
        return x;
    }
    @Override 
    public Wr dodaj(Funkcja fun){
        return fun;
    }

    //odejmowanie
    @Override 
    public Wr odejm(Wr wyr){
        return Iloczyn.nowy(Stala.nowy(-1), wyr);
    }
    @Override
    public Wr odejm(Stala sta){
        return sta;
    }
    @Override 
    public Wr odejm(Operator oper){
        return oper;
    }
    @Override
    public Wr odejm(Zmienna x){
        return x;
    }
    @Override 
    public Wr odejm(Funkcja fun){
        return fun;
    }

    // mnozenie
    @Override
    public Wr mnoz(Wr wyr){
        return nowy();
    }
    @Override 
    public Wr mnoz(Stala sta){
        return nowy();
    }
    @Override
    public Wr mnoz(Operator oper){
        return nowy();
    }
    @Override
    public Wr mnoz(Zmienna x){
        return nowy();
    }
    @Override
    public Wr mnoz(Funkcja fun){
        return nowy();
    }

    public double oblicz(double x){
        return 0;
    }

    @Override 
    public String toString(){
        return "0";
    }
}
