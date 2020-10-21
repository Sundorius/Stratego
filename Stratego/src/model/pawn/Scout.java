package model.pawn;


/**
 * This class creates a new Scout pawn.
 * @author Sundorius
 */
public class Scout extends SpecialMoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Scout and via the parent's class
     * (SpecialMoveablePawn) super method sets, rank=2, name=Scout
     *  and via parent's class setSpecialPower method sets specialPower=moveAway 
     */
    public Scout() 
    {
        super(2,"Scout");
        setSpecialPower("moveAway");
    }
}
