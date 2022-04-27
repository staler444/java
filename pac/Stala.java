package pac;
 
public class Stala extends Wr{
    public static int id = 0;
    private int val; 

    public Stala(int li)
    {
        super(Stala.id);
        this.val = li;
    }
    public int oblicz(int x){
        return val;
    }
} 