package pac.funkcje;

import pac.Wr;

public abstract class Funkcja extends Wr{
    protected Wr arg;

    public Funkcja(int pior, Wr arg){
        super(pior);
        this.arg = arg;
    }

    public Wr dodaj(Wr wyr){
        return wyr.dodaj((Funkcja)this);
    }
    public Wr odejm(Wr wyr){
        return wyr.odejm((Funkcja)this);
    }
    public Wr mnoz(Wr wyr){
        return wyr.mnoz((Funkcja)this);
    }

    public abstract String getName();

    @Override
    public String toString(){
        return getName() + "(" + arg.toString() + ")";
    }
}
