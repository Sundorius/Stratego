package model.pawn;

/**
 * This class creates a new Dragon pawn.
 * @author Sundorius
 */
public class Dragon extends MoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Dragon and via the parent's class
     * (MoveablePawn) super method sets, rank=10, name=Dragon. 
     */
    public Dragon()
    {
        super(10,"Dragon");
    } 
}
