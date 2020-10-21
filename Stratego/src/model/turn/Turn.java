package model.turn;

import java.util.Random;
import model.player.Player;

/**
 * This class represents one turn in the game.
 * @author Sundorius
 */
public class Turn
{
    private int lastPlayerID,PlayerID;
    
    /**
     * <br>Constructor
     * <br>Postcondition: Creates a new instance of Turn, sets player ID
     * (the ID of the player that plays first).
     */
    public Turn()
    {
        Random rand=new Random();
        int firstPlayer=rand.nextInt(2);
        this.setPlayerID(firstPlayer);
        if(this.getPlayerID()==1)
        {
            this.setLastPlayerID(0);
        }
        else if(this.getPlayerID()==0)
        {
            this.setLastPlayerID(1);
        }
    }
    
    
    /**
     * <br>Transformer: Sets the ID of the player.
     * <br>Precondition: Argument has to be of type Player and pl!=null..
     * <br>Postcondition: ID of the player has been set.
     * @param pl player
     */
    public void setPlayerID(Player pl)
    {
        this.PlayerID=pl.getRedPlayer()? 1:0;
    }
    
    
    /**
     * <br>Transformer: Sets the ID of the player.
     * <br>Precondition: Argument's value has to be either 1 or 0.
     * <br>Postcondition: ID of the player has been set.
     * @param id ID of player
     */
    public void setPlayerID(int id)
    {
        this.PlayerID=id;
    }
    
    
    /**
     * <br>Accessor: Returns the ID of the player.
     * <br>Postcondition: ID of the player has been returned.
     * @return 1 if player is the red player, else 0.
     */
    public int getPlayerID()
    {
        return this.PlayerID;
    }
    
    
    /**
     * <br>Transformer: Sets the ID of the player that played last.
     * <br>Precondition: Argument's value has to be either 1 or 0.
     * <br>Postcondition: ID of the player that played last has been set.
     * @param id ID of player
     */
    public void setLastPlayerID(int id)
    {
        this.lastPlayerID=id;
    }
    
    
    /**
     * <br>Accessor: Returns ID of the player that played last.
     * <br>Postcondition: ID of the player that played last has been returned.
     * @return 1 if last player is the red player, else 0
     */
    public int getLastPlayerID()
    {
        return this.lastPlayerID;
    }
    
    
    /**
     * <br>Observer: Checks if the player has finished.
     * <br>Precondition: Argument has to be of type Player and pl!=null.
     * <br>Postcondition: Returns true if player has finished,else false.
     * @param pl the player
     * @return true if player has finished, else false
     */
    public boolean checkIfFinished(Player pl)
    {
        return pl.getFinished();
    }
    
    
    /**
     * <br>Transformer: Sets the ID of the player of the next turn.
     * <br>Postcondition: ID of the new player has been set.    
     */
    public void nextTurn()
    {
        switch(this.PlayerID)
        {
            case 1: this.setPlayerID(0);
                    this.setLastPlayerID(1);
                    break;                  
            case 0: this.setPlayerID(1);
                    this.setLastPlayerID(0);
                    break;
        }
    }
}
