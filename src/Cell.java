
public class Cell
{
    // members
    private char _player; // 'B' or 'W'
    private boolean _is_dead;
    private boolean _is_free;

    // methods

    /*
    // constructor
    name: constructor
    desc: set is dead to false and is free ture
    params: none
    return: n/a
    1) set is dead to false
    2) set is free to true
    */
    public Cell()
    {
	_is_dead = false;
	_is_free = true;
    }

    /*
    // toString
    name: toString
    desc: returns "-" if free, otherwise player character
    params: none
    return: String
    1) if _is_free, return "-"
    2) return _player
    */
    public String toString()
    {
	if ( _is_free )
	    return "-";
	
	return "" + _player;
    }

    /*
    // get player
    name: get_player
    desc: returns the cell's player
    params: none
    return: char
    1) return _player
    */
    public char get_player()
    {
	return _player;
    }


    /*
    // set player
    name: set_player
    desc: tries to set the player
    params: char player
    return: boolean - if it succeds
    1) if not _is_free, return false
    2) _player = player
    3) return true;
    */
    public boolean set_player(char player)
    {
	if ( ! _is_free ) 
	    return false;

	_is_free = false;
	_player = player;
	
	return true;
    }

    /*
    // make dead
    name: make_dead
    desc: makes the cell dead
    params: none
    return: void
    1) sets _is_dead to true
    */
    public void make_dead()
    {
	_is_dead = true;
    }


    /*
    // make alive
    name: make_alive
    desc: makes the cell alive ( not dead )
    params: none
    return: void
    1) sets is_dead to false
    */

    public void make_alive()
    {
	_is_dead = false;
    }

    /*
    // is free
    name: get_is_free
    desc: returns _is_free
    params: none
    return: boolean
    1) return _is_free
    */
    public boolean get_is_free()
    {
	return _is_free;
    }
    
    /*
    // get is dead
    name: get_is_dead
    desc: gets _is_dead
    params: none
    return: boolean
    1) return _is_dead
    */
    
    public boolean get_is_dead()
    {
	return _is_dead;
    }
}