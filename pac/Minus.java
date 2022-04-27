package pac;

public class Minus extends Operator{
    public static int id = 1;

    public Minus(Wr l, Wr r){
        super(Minus.id, l, r);
    }
    
    public int oblicz(int x){
        return l.oblicz(x) - r.oblicz(x);
    }
}
