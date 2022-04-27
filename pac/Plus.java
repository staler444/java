package pac;

public class Plus extends Operator {
    public static int id = 2;

    public Plus(Wr l, Wr r){
        super(Plus.id, l, r);
    }
    
    public int oblicz(int x){
        return l.oblicz(x) + r.oblicz(x);
    }
}
