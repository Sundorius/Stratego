package model.pawn;

/**
 * This class creates a new Dwarf pawn.
 * @author Sundorius
 */
public class Dwarf extends SpecialMoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Dwarf and via the parent's class
     * (SpecialMoveablePawn) super method sets, rank=3, name=Dwarf
     *  and via parent's class setSpecialPower method sets specialPower=trapDefuse. 
     */
    public Dwarf()
    {
        super(3,"Dwarf"); 
        setSpecialPower("trapDefuse");
    }
}
