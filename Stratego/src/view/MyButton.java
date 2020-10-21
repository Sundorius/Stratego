package view;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.pawn.*;
import model.player.Player;

/**
 * This class represents a button for the gui.
 * @author Sundorius
 */
public class MyButton extends JButton
{
    private int xCoo,yCoo;                 //coordinates of MyButton.
    private int redPlayer;  //if pl.getRedPlayer==true , redPlayer=1 else redPlayer=0.
    private Pawn pawnOfBut;
    private Image hiddenImg,normalImg,turnImg;
    private boolean canBePressed;
    private boolean canBeAttacked;
    
    
    /**
     * <br>Constructor
     * <br>Postcondition: Makes a new MyButton instance.
     */
    public MyButton()
    {
        super();
        this.pawnOfBut=new Helper();
        this.redPlayer=2;
    }

    
    /**
     * <br>Transformer: Sets if the button can be pressed or not.
     * <br>Precondition: The variable has to be of boolean type.
     * <br>Postcondition: Button's canBePressed variable has been set.
     * @param canBePressed boolean variable
     */
    public void setCanBePressed(boolean canBePressed)
    {
        this.canBePressed=canBePressed;
    }
    
    
    /**
     * <br>Observer: Returns button's canBePressed value.
     * <br>Postcondition: canBePressed variable's value has been returned.
     * @return true if button can be pressed, else false
     */
    public boolean getCanBePressed()
    {
        return this.canBePressed;
    }
    
    
    /**
     * <br>Transformer: Sets if the button can be attacked or not.
     * <br>Precondition: Argument has to be of boolean type.
     * <br>Postcondition: Button's canBeAttacked variable has been set.
     * @param canBeAttacked boolean variable
     */
    public void setCanBeAttacked(Boolean canBeAttacked)
    {
        this.canBeAttacked=canBeAttacked;
    }
    
    
    /**
     * <br>Observer: Returns button's canBeAttacked value.
     * <br>Postcondition: canBeAttacked variable's value has been returned.
     * @return true if button can be attacked,else false
     */
    public boolean getCanBeAttacked()
    {
        return this.canBeAttacked;
    }
    
    
    /**
     * <br>Transformer: Sets hidden img of the button.
     * <br>Precondition: Argument has to be of type Image.
     * @param img Image variable which will be used as hidden img
     */
    public void setHiddenImg(Image img)
    {
        this.hiddenImg=img;
    }
    
    
    /**
     * <br>Transformer: Sets the normal img of button.
     * <br>Precondition: Argument has to be of type Image.
     * @param img Image variable which will be used as normal img
     */
    public void setNormalImg(Image img)
    {
        this.normalImg=img;
    }
    
    
    /**
     * <br>Accessor: Returns hidden img of button.
     * <br>Postcondition: Hidden img returned.
     * @return hidden image of button
     */
    public Image getHiddenImg()
    {
        return this.hiddenImg;
    }
    
    
    /**
     * <br>Accessor: Returns normal img of button.
     * <br>Postcondition: Normal img of button returned.
     * @return normal image of button
     */
    public Image getNormalImg()
    {
        return this.normalImg;
    }
    
    
    /**
     * <br>Transformer: Sets image of the button for this turn.
     * <br>Precondition: Argument has to be of type Image.
     * <br>Postcondition: Image of button for the turn has been set.
     * @param img Image variable which will be used as the img for the next turn
     */
    public void setImgOfTurn(Image img)
    {
        this.turnImg=img;
        this.setIcon(new ImageIcon(turnImg));
    }
    
    
    /**
     * <br>Transformer: Sets the pawn of the button.
     * <br>Precondition: Argument has to be of type Pawn.
     * <br>Postcondition: Pawn of the button has been set.
     * @param Butpawn an object of Pawn type
     */
    public void setPawnOfBut(Pawn Butpawn)
    {
        this.pawnOfBut=Butpawn;
    }
    
    
    /**
     * <br>Aceessor: Returns the pawn of the button.
     * <br>Postcondition: Pawn of the button has been returned.
     * @return the pawn of the button
     */
    public Pawn getPawnOfBut()
    {
        return this.pawnOfBut;
    }
    
    
    /**
     * <br>Transformer: Sets the button's player from a given Player object.
     * <br>Precondition: Argument has to be of type Player.
     * <br>Postcondition: Button's player has been set.
     * @param pl an object of Player type
     */
    public void setPlayerBool(Player pl)
    {
        this.redPlayer=pl.getRedPlayer()? 1:0;        
    }
    
    
    /**
     * <br>Transformer: Sets the button's player from a given int variable.
     * <br>Precondition: The player value has to be either 1 or 0.
     * <br>Postcondition: Button's player has been set.
     * @param player an object of Player type
     */
    public void setPlayerInt(int player)
    {
        this.redPlayer=player;
    }
    
    
    /**
     * <br>Transformer: If a button is blank,it has not a player,so set player =2.
     * <br>Postcondition:redPlayer set =2.
     */
    public void setPlayer()
    {
        this.redPlayer=2;
    }
    
    /**
     * <br>Accessor: Returns the button's player value.
     * <br>Postcondition: Button's player value has been returned.
     * @return 1 if player is the redPlayer, else false.
     */
    public int getPlayerInt()
    {
        return this.redPlayer;
    }
    
    
    /**
     * <br>Accessor: Returns the button's X coordinate.
     * <br>Postcondition: Button's X coordinate has been returned.
     * @return X coordinate of the button
     */
    public int getXcoo()
    {
        return this.xCoo;
    }
    
    
    /**
     * <br>Accessor: Returns the button's Y coordinate.
     * <br>Postcondition: Button's Y coordinate has been returned.
     * @return Y coordinate of the button
     */
    public int getYcoo()
    {
        return this.yCoo;
    }
    
    
    /**
     * <br>Transformer: Sets the button's X coordinate.
     * <br>Precondition: The X coordinate has to be between 0 and 7.
     * <br>Postcondition: Button's X coordinate has been set.
     * @param x X coordinate of the button
     */
    public void setXcoo(int x)
    {
        this.xCoo=x;
    }
    
    
    /**
     * <br>Transformer: Sets the button's Y coordinate.
     * <br>Precondition: The Y coordinate has to be between 0 and 9.
     * <br>Postcondition: Button's Y coordinate has been set.
     * @param y Y coordinate of the button
     */
    public void setYcoo(int y)
    {
        this.yCoo=y;
    }

  
}
