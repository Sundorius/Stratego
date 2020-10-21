package model.pawn;

/**
 * This class creates a new Beast Rider pawn.
 * @author Sundorius
 */
public class BeastRider extends SpecialMoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of BeastRider and via the parent's class
     * (MoveablePawn) super method sets, rank=7, name=BeastRider. 
     */
    public BeastRider()
    {
        super(7,"BeastRider");
        setSpecialPower("move2blocks");
    } 
}
