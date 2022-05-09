package pac.funkcje;

import pac.Wr;
import pac.operatory.Iloczyn;

public class Sinus extends Funkcja{
    private static String nazwa = "sin";
    private static int pior = 3;
    
    public Sinus(Wr wyr){
        super(Sinus.pior, wyr);
    }

    public static Wr nowy(Wr wyr){
        Sinus res = new Sinus(wyr);
        return wyr.budujFunckje(res);
    }

    public double oblicz(double x){
        return Math.sin(arg.oblicz(x));
    }

    public Wr obliczPochodna(){
        return Iloczyn.nowy(Cosinus.nowy(arg), arg.getPochodna());
    }

    public String getName(){
        return Sinus.nazwa;
    }
}
