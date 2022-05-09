package pac.operatory;

import pac.Wr;

public class Iloczyn extends Operator {
    public static String mychar = "*";
    public static int pior = 2;

    // do skracania minusów
    private boolean sigma;
    private Wr sub;
    
    public Iloczyn(Wr l, Wr r){
        super(Iloczyn.pior, l, r);

        sigma = false;
        sub = null;
        
        SigmaControl();
    }

    public static Wr nowy(Wr l, Wr r){
        return l.mnoz(r);
    }

    public Wr obliczPochodna(){
        return Plus.nowy(Iloczyn.nowy(l.getPochodna(), r), Iloczyn.nowy(l, r.getPochodna()));
    }

    public double oblicz(double x){
        return l.oblicz(x) * r.oblicz(x);
    }

    public String getMyChar(){
        return mychar;
    }

    // obsluga skracania minusów
    @Override 
    public Wr mnoz(Wr wyr){
        tryFlipSigma(wyr);
        return wyr.mnoz((Operator)this);
    }

    @Override
    public boolean flipSigma(){
        if(sub != null){
            sub.flipSigma();
            sigma = false;
            return true;
        }
        return false;
    }
    @Override
    public boolean getSigma(){
        return sigma;
    }

    private void SigmaControl(){ // jeśli l i r są ujemne skrócą sie podczas budowy, sprawdzamy tylko pojedyńcze
        if(l.getSigma()){
            sub = l;
            sigma = true;
        }
        if(r.getSigma()){
            sub = r;
            sigma = true;
        }
    }
    private void tryFlipSigma(Wr wyr){
        if(sigma)
            if(wyr.flipSigma())
                flipSigma();
    }
    
    @Override
    public Wr repair(){
        if(l != sub)
            return Iloczyn.nowy(l, sub.repair());
        return Iloczyn.nowy(sub.repair(), r);
    }
}
