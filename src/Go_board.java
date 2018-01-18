import java.util.*;


public class Go_board
{
  //constant
  public static final int SIZE = 9; // by tradition a 9x9 board
  
  //members

  private Cell[][] _the_cells;

    /*
    // constructor
    name: constructor
    desc:  allocates a 2d array of cell pointers and cell
    objects for each pointer
    params: none
    return: n/a
    1) allocate an 2d array of 9x9 cell pointers, store in _the_cells
    2) allocate a cell object for each pointer
    */

    public Go_board()
    {
	int r,c;

	_the_cells = new Cell[SIZE][SIZE];
	
	for ( r = 0; r < SIZE; r++ )
	    for ( c = 0; c < SIZE; c ++ )
		_the_cells[c][r] = new Cell();
    }

    /*
    // tostring
    name: toString
    desc: prints out the board as a giant string
    params:       none
    return: String
    1) set a string called out to the empty string
    2) for each row, do steps 3-5
    3)   for each col, do step 4
    4)      add the return of _the_cells[c][r] toString method
    to out
    5)   add the new line character to out
    6) return out
    */

    public String toString()
    {
        int r,c;
        String out = "";
	
        for ( c = 0; c < SIZE; c++ )
            out += c + " ";
	
        out += "\n";
	
        for ( r = 0; r < SIZE; r ++ )
            {
                for ( c = 0; c < SIZE; c ++ )
                    out += _the_cells[c][r] + " ";
		
                out += ") " + r + " \n";
            }
	
        return out;
    }
    
    
    /*
    // place stone
    name: place_stone
    desc: places a players stone, returns who wins, if
    anyone
    params: char player, char enemy, int col, int row
    return: char - N if game not win, otherwise the character of
    the winner
    1) if the col row is not on the board, return N
    2) call set_player on the cell at col, row.  if the method returns
    false, return N
    3) check to see if the player won, if so, return player
    4) check to see if the enemy won, if so, return enemy
    5) return N
    */

    public char place_stone(char player, char enemy, int col, int row)
    {
	char result;

	if ( ! on_board(col,row) )
	    return 'N';

	if ( _the_cells[col][row].set_player(player) == false )
	    return 'N';

	if ( check_for_win(player, enemy) )
	    return player;
	
	if ( check_for_win(enemy, player) )
	    return enemy;

	return 'N';
    }
    

    /*
    // check for win 
    name: check_for_win
    desc:  checks to see if a given player has beat his enemy
    params: char player, char enemy
    return: boolean - true if the player wins
    1) mark all the enemy stones as dead
    2) visit all enemy stones, and do step 3
    3)  if the stone is next to a free space, make that stone
    and all if its ajacent allies alive ( make_alive_recursive method )
    4) check all enemy stones, if one is dead, return true
    5) return false
    */
    private boolean check_for_win(char player, char enemy)
    {
	int r,c;

	// step 1
	for ( c = 0; c < SIZE; c++ )
	    for ( r = 0; r < SIZE; r ++ )
		_the_cells[c][r].make_dead();

	// steps 2-3
	for ( c = 0; c < SIZE; c++ )
	    for ( r = 0; r < SIZE; r ++ )
		if ( _the_cells[c][r].get_player() == enemy 
		     && next_to_free(c,r) )
		    make_alive_recursive( c, r, enemy );

	// steps 4
	for ( c = 0; c < SIZE; c++ )
	    for ( r = 0; r < SIZE; r ++ )
		if ( _the_cells[c][r].get_player() == enemy 
		     &&  _the_cells[c][r].get_is_dead() )
		    return true;

	return false;
    }

    /*
    //on board 
    name: on_board
    desc: returns true if the cell is on the board
    params: col, row
    return: boolean - true if col, row is on the board
    1) if col >= 0 and col < SIZE and row >= 0 and row < SIZE,
    then return true, else return false
    */

    private boolean on_board(int col, int row)
    {
	return col >= 0 && col < SIZE && row >= 0 && row < SIZE;
    }
    
    /*
    //next to free
    name: next_to_free
    desc: checks to see if a given cell is next to
    an adjacement cell 
    params: int col, int row
    return: boolean - true if next to a free cell
    1) if the cell above is on the board, and that cell is free,
    return true
    2) if the cell below is on the board, and that cell is free,
    return true
    3) if the cell to the left is on the board, and that cell is free,
    return true
    4) if the cell to the right is on the board, and that cell is free,
    return true
    5) return false
    */
    public boolean next_to_free(int col, int row)
    {
	if ( on_board( col, row-1 ) && _the_cells[col][row-1].get_is_free() )
	    return true;
	if ( on_board( col, row+1 ) && _the_cells[col][row+1].get_is_free() )
	    return true;
	if ( on_board( col-1, row ) && _the_cells[col-1][row].get_is_free() )
	    return true;
	if ( on_board( col+1, row ) && _the_cells[col+1][row].get_is_free() )
	    return true;
	return false;
    }

    /*
    // make alive recursive
    name: make_alive_recursive
    desc: makes the cell at col row alive, and all of its
    adjacent allied cells alive
    params: int col, int row, char player
    return: void
    1) if the cell at col, row is not on the board, return
    2) if the cell at col, row does not belong to the player, return
    3) if the cell at col, row is dead, make it alive
    4) call make_alive_recursive on all adjacent cells 
    */
    
    private void make_alive_recursive(int col, int row, char player)
    {
	if ( ! on_board(col, row) )
	    return;
	
	if ( _the_cells[col][row].get_player() != player )
	    return;

	if ( _the_cells[col][row].get_is_dead() == false )
	    return;
	
	_the_cells[col][row].make_alive();

	make_alive_recursive(col+1, row, player);
	make_alive_recursive(col-1, row, player);
	make_alive_recursive(col, row+1, player);
	make_alive_recursive(col, row-1, player);
    }
}