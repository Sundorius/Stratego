package model.pawn;

/**
 * This class creates a new Yeti pawn.
 * @author Sundorius
 */
public class Yeti extends MoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Yeti and via the parent's class
     * (MoveablePawn) super method sets, rank=5, name=Yeti. 
     */
    public Yeti()
    {
        super(5,"Yeti");   
    }
}
