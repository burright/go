
import java.util.*; 

public class go
{
    public static void main(String[] args)
    {
	Scanner scan = new Scanner(System.in);

	Go_game g = new Go_game(scan);

	g.play_game();
    }
}