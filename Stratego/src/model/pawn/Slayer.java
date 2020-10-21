package model.pawn;

/**
 * This class creates a new Slayer pawn.
 * @author Sundorius
 */
public class Slayer extends SpecialMoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Slayer and via the parent's class
     * (SpecialMoveablePawn) super method sets, rank=1, name=Slayer
     * and via parent's class setSpecialPower method sets specialPower=killDragon. 
     */
    public Slayer() 
    {
        super(1, "Slayer");
        setSpecialPower("killDragon");
    }
}
