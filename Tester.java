import pac.*;
import pac.funkcje.*;
import pac.operatory.*;
import pac.stale.*;

import java.util.Random;

public class Tester{
    private static Random rand = new Random();
    public static void main(String args[])
    {
        boolean TESTUJ_PRZYKLADOWE = true;
        boolean TESTUJ_SKRACANIE = true;
        boolean LOSOWA_PACZKA = true; 

        if(TESTUJ_PRZYKLADOWE){
            Wr wr1 = Iloczyn.nowy(Stala.nowy(4), Plus.nowy(Stala.nowy(2), Zmienna.nowy()));
            Wr wr2 = Iloczyn.nowy(Zmienna.nowy(), Plus.nowy(Sinus.nowy(Zmienna.nowy()), Plus.nowy(Stala.nowy(3), Zmienna.nowy())));
            cout("Testuje dwa wyrażenia przykładowe z treści", 2);
            testuj(wr1, "wr1");
            testuj(wr2, "wr2");
            endl(3);
        }
        if(TESTUJ_SKRACANIE){
            Testyskracania();
            endl(3);
        }

        if(LOSOWA_PACZKA){
            cout("Losowo wygenerowana paczka wyrażeń: ", 1);
            generatorka(10, 6);
        }
    }

    private static void testuj(Wr wyr, String name)
    {
        cout("Testuje wyrażenie: " + name + ", ");
        cout(name + "(x) = "); cout(wyr, 2);
        
        unittests(wyr, name);

        Wr pochodna = wyr.getPochodna();
        String pochname = name+"'";

        cout("Niech " + pochname + " będzie pochodną " + name , 1);
        cout(pochname + "(x) = "); cout(pochodna, 2);
        cout("Testuje: " + pochname, 1);

        unittests(pochodna, pochname);
    }

    private static void unittests(Wr wyr, String name)
    {
        double punkty[] = {-1, 0, 1};
        cout(" Całka na [0; 1] = ");
        cout(wyr.obliczCalke(0, 1), 2);

        cout(" Obliczam wartosci w punktach:", 1);
        for(double p : punkty){
            cout("   " + name +"("); cout(p); cout(") = ");
            cout(wyr.oblicz(p), 2);
        }
    }

    private static void Testout(int i){
        cout("Test: ");
        cout(i, 1);
        cout("  "); 
    }

    private static void Testyskracania(){
        Wr wr;
        cout("Testy skracania", 1);

        // 1
        wr = Plus.nowy(Stala.nowy(0), Zmienna.nowy());
        Testout(1);
        cout("Plus(0, x)  =  "); 
        cout(wr, 2);

        // 2
        wr = Minus.nowy(Zmienna.nowy(), Stala.nowy(-2));
        Testout(2);
        cout("Minus(x, -2)  =  "); 
        cout(wr, 2);

        // 3
        wr = Minus.nowy(Zmienna.nowy(), Zmienna.nowy());
        Testout(3);
        cout("Minus(x, x) = ");
        cout(wr, 2);

        // 4
        wr = Minus.nowy(Stala.nowy(0), Zmienna.nowy());
        Testout(4);
        cout("Minus(0, x) = ");
        cout(wr,2);

        // 5
        wr = Iloczyn.nowy(Stala.nowy(-2), Iloczyn.nowy(Zmienna.nowy(), Iloczyn.nowy(Zmienna.nowy(), Stala.nowy(-7))));
        Testout(5);
        cout("Iloczyn(-2, Iloczyn(x, Iloczyn(x, -7)))  =  ");
        cout(wr, 2);

        // 6
        wr = Iloczyn.nowy(Stala.nowy(-2), Iloczyn.nowy(Stala.nowy(-4), Iloczyn.nowy(Zmienna.nowy(), Stala.nowy(-7))));
        Testout(6);
        cout("Iloczyn(-2, Iloczyn(-4, Iloczyn(x, -7))) =  ");
        cout(wr, 2);

        // 7
        wr = Iloczyn.nowy(Iloczyn.nowy(Stala.nowy(-2), Zmienna.nowy()), Iloczyn.nowy(Zmienna.nowy(), Stala.nowy(-6)));
        Testout(7);
        cout("Iloczyn(Iloczyn(-2, x), Iloczyn(x, -6)) = ");
        cout(wr, 2);

        // 8
        wr = Plus.nowy(Zmienna.nowy(), Minus.nowy(Stala.nowy(-2), Zmienna.nowy()));
        Testout(8);
        cout("Plus(x, Minus(-2, x)) =  ");
        cout(wr, 2);

        // 9
        wr = Minus.nowy(Zmienna.nowy(), Plus.nowy(Stala.nowy(-2), Zmienna.nowy()));
        Testout(9);
        cout("Minus(x, Plus(-2, x)) =  ");
        cout(wr, 2);

        // 10
        wr = Minus.nowy(Zmienna.nowy(), Stala.nowy(-2));
        Testout(10);
        cout("Minus(x, -2) =  ");
        cout(wr, 2);

        // 11
        wr = Plus.nowy(Zmienna.nowy(), Stala.nowy(-2));
        Testout(11);
        cout("Plus(x, -2) =  ");
        cout(wr, 2);

        // 12
        wr = Minus.nowy(Zmienna.nowy(), Iloczyn.nowy(Stala.nowy(-2), Zmienna.nowy()));
        Testout(12);
        cout("Minus(x, Iloczyn(-2, x)) =  ");
        cout(wr,2);

        // 13 
        wr = Iloczyn.nowy(Stala.nowy(-2), Minus.nowy(Stala.nowy(-3), Zmienna.nowy()));
        Testout(13);
        cout("Iloczyn(-2, Minus(-3, x)) =  ");
        cout(wr, 2);
    }

    public static void generatorka(int n, int maxdep){
        for(int i = 0; i < n; i++)
        {
            Tester.rand = new Random(i);
            Wr wr = jazda(0, maxdep);
            cout("Test: "); cout(i); cout("  ");
            cout(wr,1);
        }
    }

    private static Wr jazda(int dep, int maxdep){
        if(dep == maxdep)
        {
            int losulosu = rand.nextInt(2);
            if(losulosu == 0)
                return Zmienna.nowy();
            return Stala.nowy(rand.nextInt(6));
        }

        int losulosu = rand.nextInt(7);

        if(losulosu == 0)
            return Zmienna.nowy();
        if(losulosu == 1)
            return Stala.nowy(rand.nextInt(6));
        if(losulosu == 2)
            return Plus.nowy(jazda(dep+1, maxdep), jazda(dep+1, maxdep));
        if(losulosu == 3)
            return Minus.nowy(jazda(dep+1, maxdep), jazda(dep+1, maxdep));
        if(losulosu == 4)
            return Iloczyn.nowy(jazda(dep+1, maxdep), jazda(dep+1, maxdep));
        if(losulosu == 5)
            return Sinus.nowy(jazda(dep+1, maxdep));
        return Cosinus.nowy(jazda(dep+1, maxdep));
    }

    // #include <iostream.h>
    private static void endl(int l){
        for(int i = 0; i < l; i++)
            System.out.println();
    }
    private static void cout(String s, int l){
        System.out.print(s);
        endl(l);
    } 
    private static void cout(double a, int l){
        System.out.print(a);
        endl(l);
    }
    private static void cout(int i, int l){
        System.out.print(i);
        endl(l);
    }
    private static void cout(Wr wyr, int l){
        System.out.print(wyr);
        endl(l);
    }
    private static void cout(Wr wyr){
        System.out.print(wyr);
    }
    private static void cout(String s){
        System.out.print(s);
    } 
    private static void cout(double a){
        System.out.print(a);
    }
    private static void cout(int i){
        System.out.print(i);
    }
}