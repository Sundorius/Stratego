package model.pawn;

/**
 * This class represents an Immovable Pawn.
 * @author Sundorius
 */
public class ImmovablePawn implements Pawn
{
    private int rank,x,y,rescueCount;
    private String name=new String();
    
    
     /**
     * <br>Constructor
     * <br>Precondition: Argument's rank value has to be between 0 and 10 and argument name has to be of type String and name!=null.
     * (Pawn) super method sets 'rank'=rank and 'name=name, and sets this.canMove=canMove. 
     *
     * @param rank rank of pawn
     * @param name name of pawn
     */
    public ImmovablePawn(int rank, String name)
    {
        this.rank=rank;
        this.name=name;
        this.rescueCount=0;
    }

    
    /**
     * <br>Transformer: Increases rescue counter by 1.
     * <br>Postcondition: Rescue counter has been increased by 1.
     */
    @Override
    public void addRescueCount()
    {
        this.rescueCount++;
    }
    
    
    /**
     * <br>Accessor: Returns how many times a pawn has rescued another pawn.
     * <br>Postcondition: Returns how many times a pawn has rescued another pawn.
     * @return how many times a pawn has rescued another pawn
     */
    @Override
    public int getRescueCount()
    {
        return this.rescueCount;
    }
    
    
    /**
     * <br>Transformer: Sets the pawn's rank.
     * <br>Precondition: Argument's value has to be between 0 and 10.
     * <br>Postcondition: Pawn's rank has been set.
     * @param rank rank of pawn
     */
    @Override
    public void setRank(int rank) 
    {
        this.rank=rank;
    }

    
    /**
     * <br>Accessor: Returns the pawn's rank.
     * <br>Postcondition: Pawn's rank has been returned.
     * @return  rank of pawn
     */
    @Override
    public int getRank() 
    {
        return rank;
    }

    
    /**
     * <br>Transformer: Sets the pawn's name.
     * <br>Precondition: Argument has to be of type String and name!=null.
     * <br>Postcondition: Pawn's name has been set.
     * @param name name of the pawn
     */
    @Override
    public void setName(String name)
    {
        this.name=name;
    }

    
    /**
     * <br>Accessor: Returns the pawn's name.
     * <br>Postcondition: Pawn's name has been returned.
     * @return name of the pawn
     */
    @Override
    public String getName()
    {
        return name;
    }
}
