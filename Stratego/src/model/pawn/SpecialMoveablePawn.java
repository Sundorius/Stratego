package model.pawn;

/**
 * This class represents a Special Moveable Pawn.
 * @author Sundorius
 */
public class SpecialMoveablePawn extends MoveablePawn
{
    private String specialPower=new String();
    
    /**
     * <br>Constructor
     * <br>Postcondition: Creates a new Special Moveable Pawn and via parent's class
     * (MoveablePawn) super method sets 'rank'=rank and 'name=name 
     *
     * @param rank rank of pawn
     * @param name name of pawn
     */
    public SpecialMoveablePawn(int rank, String name)
    {
        super(rank,name);
    }

    /**
     * <br>Transformer: Sets pawn's specialPower.
     * <br>Precondition: Argument has to be of type String and specialPower!=null.
     * <br>Postcondition: pawn's specialPower has been set.
     * @param specialPower special power of pawn
     */
    public void setSpecialPower(String specialPower)
    {
        this.specialPower=specialPower;
    }
    
    
    /**
     * <br>Accessor: Returns pawn's specialPower.
     * <br>Postcondition: pawn's specialPower has been returned.
     * @return pawn's specialPower
     */
    public String getSpecialPower()
    {
        return this.specialPower;
    }
    
}
