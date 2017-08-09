/**
 * Created by rober on 8/8/2017.
 */
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public int squareLoc;
    public int rounds;
    public int id;

    public Player(int index)
    {
        this.squareLoc=0;
        this.rounds=0;
        this.id = index;

    }
    public Player()
    {
        this.squareLoc=0;
        this.rounds=0;
    }

    public void movePlayer()
    {
        this.squareLoc += (ThreadLocalRandom.current().nextInt(0, 6 + 1)+
                ThreadLocalRandom.current().nextInt(0, 6 + 1));
        if(this.squareLoc >= 40)
        {
            this.squareLoc= this.squareLoc -40;
            this.rounds +=1;
        }
    }
}
