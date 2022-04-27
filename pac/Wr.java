package pac;

public abstract class Wr {
    private int co; // 0 = stala, 1 = x, 2, = +, 3 = -, 4 = *;
    public Wr(int co){
        this.co = co;
    }
    public int coTo(){
        return co;
    }
    public abstract int oblicz(int x);
}
