package model.pawn;

/**
 * Contains the method signatures needed for creating a Stratego Ice vs Fire
 * MoveablePawn/SpecialMoveablePawn/ImmovablePawn.
 * @author Sundorius
 */
public interface Pawn
{
    /**
     * <br>Transformer: Increases rescue counter by 1.
     * <br>Postcondition: Rescue counter has been increased by 1.
     */
    public void addRescueCount();

    /**
     * <br>Accessor: Returns how many times a pawn has rescued another pawn.
     * <br>Postcondition: Returns how many times a pawn has rescued another pawn.
     * @return how many times a pawn has rescued another pawn
     */
    public int getRescueCount();
      
    /**
     * <br>Transformer: Sets the pawn's rank.
     * <br>Precondition: Argument's value has to be between 0 and 10.
     * <br>Postcondition: Pawn's rank has been set.
     * @param rank rank of pawn
     */
    public void setRank(int rank) ;
    
    /**
     * <br>Accessor: Returns the pawn's rank.
     * <br>Postcondition: Pawn's rank has been returned.
     * @return  rank of the pawn
     */
    public int getRank();
    
    /**
     * <br>Transformer: Sets the pawn's name.
     * <br>Precondition: Argument has to be of type String and name!=null.
     * <br>Postcondition: Pawn's name has been set.
     * @param name name of pawn
     */
    public void setName(String name);

    /**
     * <br>Accessor: Return the pawn's name.
     * <br>Postcondition: Pawn's name has been returned.
     * @return name of the pawn
     */
    public String getName();
}
