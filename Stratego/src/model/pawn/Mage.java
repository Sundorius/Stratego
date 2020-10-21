package model.pawn;

/**
 * This class creates a new Mage pawn.
 * @author Sundorius
 */
public class Mage extends MoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Mage and via the parent's class
     * (MoveablePawn) super method sets, rank=9, name=Mage. 
     */
    public Mage()
    {
        super(9,"Mage");
    }
}
