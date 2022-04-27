package pac;

public abstract class Operator extends Wr{
    protected Wr l, r;
    
    public Operator(int co, Wr l, Wr r)
    {
        super(co);
        this.l = l;
        this.r = r;
    }

    @Override
    public abstract int oblicz(int x);
}
