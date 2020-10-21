package model.pawn;
/**
 * This class creates a new Trap pawn.
 * @author Sundorius
 */
public class Trap extends ImmovablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Bomb and via the parent's class
     * (ImmovablePawn) super method sets, rank=-1, name=Bomb. 
     */
    public Trap()
    {
        super(-1, "Trap");
    }
    
}
