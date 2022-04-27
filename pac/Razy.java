package pac;

public class Razy extends Operator {
    public static int id = 3;

    public Razy(Wr l, Wr r){
        super(Razy.id, l, r);
    }

    public int oblicz(int x){
        return l.oblicz(x) * r.oblicz(x);
    }
}
