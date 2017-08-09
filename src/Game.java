import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rober on 8/8/2017.
 */
public class Game {

    public int numPlayers =0;
    public int numRounds =0;
    public ArrayList<Player> playerList = new ArrayList<>();

    public Game(int playerCount, int roundCount)
    {
        this.numRounds=roundCount;
        this.numPlayers = playerCount;
        int index= 0;
        while(playerCount>index)
        {
            Player p = new Player(playerCount);
            this.playerList.add(index,p);
            playerCount--;
            index+=1;
        }

    }
    public void nextRound()
    {
        for(int i =0; i<this.playerList.size(); i++)
        {
            this.playerList.get(i).movePlayer();
        }
    }

    public Player findWinner()
    {
        Player currentWinner= new Player();
        for(int i =0; i<this.playerList.size(); i++)
        {
            if(this.playerList.get(i).rounds > currentWinner.rounds)
            {
                currentWinner=this.playerList.get(i);
            }
            else if(this.playerList.get(i).rounds == currentWinner.rounds
                    && this.playerList.get(i).squareLoc > currentWinner.squareLoc)
            {
                currentWinner=this.playerList.get(i);
            }
        }
        return currentWinner;
    }

    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome! " +
                "\nselect the number of players in the range of [2,8]");
        int inputPlayer = scan.nextInt();
        while(inputPlayer >8 || inputPlayer <2)
        {
            System.out.println("not a valid number please try again");
            inputPlayer = scan.nextInt();
        }
        System.out.print("Select the number of round such that the value is less " +
                "than or equal to 1000 and greater than 0\n");

        int inputRounds = scan.nextInt();
        while(inputRounds > 1000 || inputRounds <0)
        {
            System.out.println("value not valid please try again");
            inputRounds = scan.nextInt();

        }
        scan.close();
        Game game = new Game(inputPlayer, inputRounds);

        while(inputRounds>0)
        {
            game.nextRound();
            inputRounds--;
        }
        Player winner= game.findWinner();

        System.out.println("The winner is player "+winner.id+" with total rounds being "
        +winner.rounds+" and located on square "+winner.squareLoc);


    }
}
