package model.pawn;

/**
 * This class creates a new Knight pawn.
 * @author Sundorius
 */
public class Knight extends SpecialMoveablePawn 
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Knight and via the parent's class
     * (MoveablePawn) super method sets, rank=8, name=Knight. 
     */
    public Knight()
    {
        super(8,"Knight");
        setSpecialPower("move2blocks");
    }
}
