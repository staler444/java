package pac.operatory;

import pac.Wr;

public abstract class Operator extends Wr{
    protected Wr l, r;
    
    public Operator(int pior, Wr l, Wr r){
        super(pior);
        this.l = l;
        this.r = r;
    }

    public Wr dodaj(Wr wyr){
        return wyr.dodaj((Operator)this);
    }
    public Wr odejm(Wr wyr){
        return wyr.odejm((Operator)this);
    }
    public Wr mnoz(Wr wyr){
        return wyr.mnoz((Operator)this);
    }

    public abstract String getMyChar();

    @Override
    public String toString(){
        boolean lnawias = l.jakiPior() < this.jakiPior();
        boolean rnawias = r.jakiPior() < this.jakiPior();
        return (lnawias ? "(" : "") + l.toString() + (lnawias ? ")" : "") + this.getMyChar() + (rnawias ? "(" : "") + r.toString() + (rnawias ? ")" : "");
    }
}
