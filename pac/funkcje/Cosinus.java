package pac.funkcje;

import pac.Wr;
import pac.operatory.Iloczyn;
import pac.stale.Stala;

public class Cosinus extends Funkcja{
    private static String nazwa = "cos";
    private static int pior = 3;

    public Cosinus(Wr wyr){
        super(Cosinus.pior, wyr);
    }

    public Cosinus buduj(Wr wyr){
        return new Cosinus(wyr);
    }

    public static Wr nowy(Wr wyr){
        Cosinus res = new Cosinus(wyr);
        return wyr.budujFunckje(res);
    }

    public double oblicz(double x){
        return Math.cos(arg.oblicz(x));
    }

    public Wr obliczPochodna(){
        return Iloczyn.nowy(Iloczyn.nowy(Stala.nowy(-1), Sinus.nowy(arg)), arg.getPochodna());
    }

    public String getName(){
        return Cosinus.nazwa;
    }
}
