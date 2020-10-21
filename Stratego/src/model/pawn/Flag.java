package model.pawn;

/**
 * This class creates a new Flag pawn.
 * @author Sundorius
 */
public class Flag extends ImmovablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Flag and via the parent's class
     * (ImmovablePawn) super method sets, rank=-1, name=Flag. 
     */
    public Flag() {
        super(-1, "Flag");
    }
    
}
