package pac.stale;

import pac.Wr;
import pac.Zmienna;
import pac.funkcje.Funkcja;
import pac.operatory.Operator;

public class StalaJeden extends Stala{
    private static StalaJeden jeden = null;

    private StalaJeden(){
        super(1.0);
        jeden = this;
    }

    public static StalaJeden nowy(){
        if(jeden == null)
            return new StalaJeden();
        return jeden;
    }
    
    @Override
    public Wr mnoz(Wr wyr){
        return wyr;
    }
    @Override
    public Wr mnoz(Stala sta){
        return sta;
    }
    @Override
    public Wr mnoz(Operator oper){
        return oper;
    }
    @Override 
    public Wr mnoz(Zmienna x){
        return x;
    }
    @Override
    public Wr mnoz(Funkcja fun){
        return fun;
    }
}
