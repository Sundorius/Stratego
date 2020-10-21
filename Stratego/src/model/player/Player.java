package model.player;

import model.pawn.Pawn;
import model.pawnCollection.PawnCollection;


/**
 * This class represents a player.
 * @author Sundorius
 */
public class Player 
{
    private boolean finished,redPlayer;// redPlayer is the one with the fire troops.
    private PawnCollection aliveColl , deadColl;
    private int rescueCounter=0;
    
    
    /**
     * <br>Constructor
     * <br>Precondition: 
     * <br>Postconditions: Creates a player and sets,if the player
     * has the red troops(redPlayer), also it initializes the player's two pawn collections.
     * @param redPlayer is true if player is the redPlayer,else false
     */
    public Player(boolean redPlayer)
    {
        this.redPlayer=redPlayer;
        this.finished=false;
        this.deadColl=new PawnCollection(); 
        this.aliveColl=new PawnCollection();         
    }
    
    /**
     * <br>Accessor: Returns a pawn, from the dead pawn collection in position i.
     * <br>Precondition: Argument's i value has to be less or equal to getDeadCollSize().
     * <br>Postcondition: Pawn from position i of the dead pawn collection has been returned.
     * @param i the position of the pawn in the dead pawn collection
     * @return the pawn in position i in the dead pawn collection
     */
    public Pawn getDeadPawn(int i)
    {
        return deadColl.getPawn(i);
    }
    
    
    /**
     * <br>Transformer: Increases the counter of rescues by one.
     * <br>Postcondition: Counter of rescues has been increased by one. 
     */
    public void IncreaseRescueCounter()
    {
        if(this.rescueCounter<=2)
        {
            this.rescueCounter++;
        }
    }
    
    
    /**
     * <br>Accessor: Returns the value of the rescue counter.
     * <br>Postcondition: Value of rescue counter has been returned.
     * @return the value of rescue counter
     */
    public int getRescueCounter()
    {
        return this.rescueCounter;
    }

    
    /**
     * <br>Accessor: Returns the pawn from the alive pawn collection in position i.
     * <br>Precondition: Argument's i value has to be less or equal to getAliveCollSize().
     * <br>Postcondition: Pawn from position i of the alive pawn collection has been returned.
     * @param i the position of the pawn in the alive pawn collection
     * @return the pawn in position i of alive pawn collection
     */
    public Pawn getAlivePawn(int i)
    {
        return aliveColl.getPawn(i);
    }
    
    
    /**
     * <br>Accessor: Returns the size of the alive pawn collection.
     * <br>Transformer: Size of the alive pawn collection has been returned.
     * @return alive pawn collection size
     */
    public int getAliveCollSize()
    {
        return aliveColl.getSize();
    }
    
    
    /**
     * <br>Accessor: Returns the size of the dead pawn collection.
     * <br>Transformer: Size of the dead pawn collection has been returned.
     * @return dead collection size
     */
    public int getDeadCollSize()
    {
        return deadColl.getSize();
    }
    
    
    /**
     * <br>Transformer: Adds a pawn to alive pawn collection.
     * <br>Precondition: Argument has to be of type Pawn and pawn!=null.
     * <br>Postcondition: Pawn added to alive pawn collection.
     * @param pawn an object of Pawn type
     */
    public void addAlivePawn(Pawn pawn)
    {
        this.aliveColl.addPawn(pawn);
    }
    
    
    /**
     * <br>Transformer: Adds a dead pawn in dead pawn collection, and removes it from alive pawn collection.
     * <br>Precondition: Argument has to be of type Pawn and pawn!=null.
     * <br>Postcondition: Pawn added in dead pawn collection,pawn removed from alive pawns collection.
     * @param pawn an object of Pawn type
     */
    public void addFromAlivetoDead(Pawn pawn)
    {
        this.deadColl.addPawn(pawn);
        this.aliveColl.removePawn(pawn.getName());
    }
    
    
    /**
     * <br>Transformer: Removes a pawn from dead pawn collection.
     * <br>Precondition: Argument has to be of type Pawn and pawn!=null.
     * <br>Postcondition: Pawn removed from dead pawn collection.
     * @param pawn an object of Pawn type
     */
    public void removeFromDeadColl(Pawn pawn)
    {
        this.deadColl.removePawn(pawn.getName());
    }
    
    
    /**
     * <br>Transformer: Sets redPlayer variable with true if the player has the fire troops,else false.
     * <br>Precondition: Argument has to be of boolean type.
     * <br>Postcondition: redPlayer variable has been set with true
     * if player has the fire troops,else false.
     * @param red boolean variable
     */
    public void setRedPlayer(boolean red)
    {
        this.redPlayer=red;
    }
    
    
    /**
     * <br>Observer: Returns true/false accordingly to player's troops.
     * <br>Postcondition: Returns true if the player has the fire troops,else false.
     * @return true if player has the fire troops, else false
     */
    public boolean getRedPlayer()
    {
        return this.redPlayer;
    }
    
    
    /**
     * <br>Transformer: Sets player's finished state.
     * <br>Precondition: Argument has to be of boolean type.
     * <br>Postcondition: Player's finished state has been set.
     * @param finished if player has finished his/her move
     */
    public void setFinished(boolean finished)
    {
        this.finished=finished;
    }
    
    
    /**
     * <br>Observer: Returns player's finished state.
     * <br>Postcondition: Returns true if player has finished its move, else false.
     * @return true if player has finished, else false
     */
    public boolean getFinished()
    {
        return this.finished;
    }
}
