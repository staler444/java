package pac;

import pac.funkcje.*;
import pac.operatory.*;
import pac.stale.*;

public abstract class Wr {
    private int pior;
    private Wr pochodna = null;

    public Wr(int pior){
        this.pior = pior;
    }

    // dodawanie 
    public abstract Wr dodaj(Wr wyr);
    public Wr dodaj(Stala sta){
        return new Plus(sta, this);
    }
    public Wr dodaj(Operator oper){
        return new Plus(oper, this);
    }
    public Wr dodaj(Zmienna x){
        return new Plus(x, this);
    }
    public Wr dodaj(Funkcja fun){
        return new Plus(fun, this);
    }

    // odejmowanie
    public abstract Wr odejm(Wr wyr);
    public Wr odejm(Stala sta){
        return new Minus(sta, this);
    }
    public Wr odejm(Operator oper){
        return new Minus(oper, this);
    }
    public Wr odejm(Zmienna x){
        return new Minus(x, this);
    }
    public Wr odejm(Funkcja fun){
        return new Minus(fun, this);
    }
    
    // mnozenie
    public abstract Wr mnoz(Wr wyr);
    public Wr mnoz(Stala sta){
        return new Iloczyn(sta, this); 
    }
    public Wr mnoz(Operator oper){
        return new Iloczyn(oper, this);
    }
    public Wr mnoz(Zmienna x){
        return new Iloczyn(x, this);
    }
    public Wr mnoz(Funkcja fun){
        return new Iloczyn(fun, this);
    }

    //pochodna
    public abstract Wr obliczPochodna();
    public Wr getPochodna(){
        if(pochodna == null)
            pochodna = obliczPochodna();
        return pochodna;
    }

    // funkcje pomocnicze do całkowania
    private static double abs(double a){
        return (a > 0.0 ? a : -a);
    }
    private static double min(double a, double b){
        return (a < b ? a : b);
    }
    private static double max(double a, double b){
        return (a > b ? a : b);
    }
    private static double poleTrojkata(double a, double h){
        return a*h/2.0;
    }
    private static double sigma(double a){
        return (a < 0 ? -1 : 1);
    }
    private static double odleglosc(double a, double b){
        return abs(abs(a)-abs(b));
    }

    // całkowanie
    private double pole(double a, double b){
        double fa = oblicz(a), fb = oblicz(b);
        if(fa*fb < 0)
            return 0;
        return sigma(fa) * (min(abs(fa), abs(fb))*odleglosc(a, b) + poleTrojkata(odleglosc(a, b), odleglosc(fa, fb)));
    }   

    public double obliczCalke(double a, double b){
        if(a > b){
            double tmp = a;
            a = b;
            b = tmp;
        }

        double dokladnosc = 10e5;
        double h = max(odleglosc(a, b)/dokladnosc, 10e-6);
        double res = 0;
        
        for(;a+h < b; a+=h)
            res+=pole(a, a+h);

        res += pole(a, b);

        return res;
    }

    //obsluga skracania minusów dla iloczynu i stalej (niepotrzebny bajer), domyślnie nic nie jest sigmowane
    // pomaga też przy fixowaniu dodawania i odejmowania
    public boolean flipSigma(){
        return false;
    }
    public boolean getSigma(){
        return false;
    }

    // potrzebne jeśli -1*x zmieni znak. Skracanie z 1 odbywa się podczas budowania obiektu.
    // buduje zmienioną ścierzke jeszcze raz żeby jedynka sama mogła się skrócić. Czas amortyzuje się do stałego.
    public Wr repair(){ 
        return this;
    }

    // reszta 
    public int jakiPior(){
        return pior;
    }

    public abstract double oblicz(double x);

    public Wr budujFunckje(Funkcja fun){
        return fun;
    }

    @Override
    public abstract String toString();
}
