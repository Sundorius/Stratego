package model.pawn;

/**
 * This class creates a new Lava Beast pawn.
 * @author Sundorius
 */
public class LavaBeast extends MoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Lava Beast and via the parent's class
     * (MoveablePawn) super method sets, rank=5, name=LavaBeast. 
     */
    public LavaBeast()
    {
        super(5,"LavaBeast");
    }
}
