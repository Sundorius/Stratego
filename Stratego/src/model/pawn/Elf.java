package model.pawn;

/**
 * This class creates a new Elf pawn.
 * @author Sundorius
 */
public class Elf extends MoveablePawn
{
    /**
     * <br>Constructor
     * <br>Postcondition: Constructs a new instance of Elf and via the parent's class
     * (MoveablePawn) super method sets, rank=4, name=Elf. 
     */
    public Elf()
    {
        super(4,"Elf");
    }
}
