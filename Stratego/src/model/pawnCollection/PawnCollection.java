package model.pawnCollection;

import java.util.ArrayList;
import model.pawn.*;

/**
 * This class creates a new collection of pawns for the player.
 * @author Sundorius
 */
public class PawnCollection 
{
    private ArrayList<Pawn> pawns;
    
    
    /**
     * <br>Constructor
     * <br>Postcondition: A collection of pawns has been created.
     */
    public PawnCollection()
    {
        this.pawns=new ArrayList<Pawn>();
    }
    
    
    /**
     * <br>Accessor: Returns the pawn, in the i position of the collection.
     * <br>Precondition: Argument's i value has to be less or equal to pawns.size().
     * <br>Postcondition: Pawn in position i has been returned.
     * @param i the position of the pawn in the collection
     * @return the pawn in the i position of the collection.
     */
    public Pawn getPawn(int i)
    {
        return pawns.get(i);
    }
    
    
    /**
     * <br>Accessor: Returns the size of the collection.
     * <br>Postcondition: Size of the collection has been returned.
     * @return the size of the collection
     */
    public int getSize()
    {
        return pawns.size();
    }

    
    /**
     * <br>Transformer: Removes a pawn form the collection.
     * <br>Precondition: The argument has to be of type String and name!=null.
     * <br>Postcondition: A pawn has been removed from the collection.
     * @param name of the pawn that wants to be removed
     */
    public void removePawn(String name)
    {
        for(int i=0; i<pawns.size(); i++)
        {
            if(pawns.get(i).getName().equals(name))
            {
                pawns.remove(i);
                return;
            }
        }
    }
    
    
    /**
     * <br>Transformer: Adds a pawn to the collection.
     * <br>Precondition: The argument has to be of type Pawn and pawn!=null.
     * <br>Postcondition: A pawn has been added to the collection.
     * @param pawn an object of Pawn type
     */
    public void addPawn(Pawn pawn)
    {
        this.pawns.add(pawn);
    }
    
    
    /**
     * <br>Accessor: Returns the pawn's rank in position i.
     * <br>Precondition: Argument's i value has to be less or equal to pawns.size().
     * <br>Postcondition: Pawn's rank in position i has been returned.
     * @param i the position of the pawn in the collection
     * @return the rank, of the pawn in position i.
     */
    public int getRank(int i)
    {
        return pawns.get(i).getRank();
    }
}
