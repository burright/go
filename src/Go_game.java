
import java.util.*;

public class Go_game
{
    // members
    private Go_board _board;
    private Scanner _scan;
    
    // methods
    
    /*
    // constructor
    name: constructor
    desc: saves the scanner
    params: Scanner scan
    return: n/a
    1) allocate a go board object and store in _board
    2) save scan in _scan
    */
    public Go_game(Scanner scan)
    {
	_scan = scan;

	_board = new Go_board();
    }


    /*
    // play game
    name: play_game
    desc: plays the game
    params: none
    return: void
    1) while no one has won, repeat steps 2-3
    2)  have player B take a turn
    3)  if no one wins, have player W take a turn
    */
    public void play_game()
    {
	char result = 'N';
	int c,r;

	while ( result == 'N' )
	    {
		System.out.println( _board );
		System.out.println("B, its your turn....");
		System.out.print("col: ");
		c = _scan.nextInt();
		System.out.print("row: ");
		r = _scan.nextInt();

		result = _board.place_stone('B', 'W', c, r);

		if ( result == 'N' )
		    {
			System.out.println( _board );
			System.out.println("W, its your turn....");
			System.out.print("col: ");
			c = _scan.nextInt();
			System.out.print("row: ");
			r = _scan.nextInt();
			
			result = _board.place_stone('W', 'B', c, r);
		    }
	    }

	System.out.println(result + " wins!!!!!!");
	
    }
}