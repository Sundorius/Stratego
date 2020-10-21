package controller;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.pawn.*;
import model.player.Player;
import model.turn.Turn;
import view.GraphicUI;
import view.MyButton;

/**
 * This class is the brain of the Stratego game.
 * @author Sundorius
 */
public class Controller 
{
    private int lastPlayer,newPlayer;
    private Player redPl,bluePl;
    public Turn turn;
    private boolean endGame;
    private final Image redHidden=ImageIO.read(getClass().getResource("images/redHidden.png"));
    private final Image blueHidden=ImageIO.read(getClass().getResource("images/blueHidden.png"));
    private final Image blankBlock = ImageIO.read(getClass().getResource("images/blankBlock.png"));
    private GraphicUI gui;

    /**
     * <br>Constructor 
     * <br>Postcondition: Two Player instances created, Turn instance created , variable endGame=false and this.gui=gui.
     * @param gui the GraphicalUI
     * @throws java.io.IOException
     */
    public Controller(GraphicUI gui) throws IOException
    {
        this.redPl=new Player(true);
        this.bluePl=new Player(false);
        this.turn=new Turn();
        this.endGame=false;
        this.gui=gui;
    }
    
    
    /**
     * <br>Transformer:Initializes a pawn button.
     * <br>Precondition: Argument but has to be of type MyButton and but!=null, argument pawnName has to be of type String and pawnName!=null,
     * argument's x value has to be between 0 and 7 and argument's y value has to be between 0 and 9.
     * <br>Postcondition:Pawn button has been initialized.
     * @param but a button
     * @param pawnName name of the pawn
     * @param playerColor color of the player , red if red player , blue if blue player
     * @param x x coordinate of the button
     * @param y y coordinate of the button
     * @throws java.io.IOException
     */
    public void initPButton(MyButton but,String pawnName,String playerColor,int x, int y) throws IOException
    {
        Player tempPl;
        tempPl=playerColor.equals("red")? redPl:bluePl;  
        
        String imgName=new String();
        switch (pawnName) {
            case "Dwarf":
                but.setPawnOfBut(new Dwarf());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Dwarf());
                break;
            case "Scout":
                but.setPawnOfBut(new Scout());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Scout());
                break;
            case "Trap":
                but.setPawnOfBut(new Trap());
                but.setCanBePressed(false);
                tempPl.addAlivePawn(new Trap());
                break;
            case "BeastRider":
                but.setPawnOfBut(new BeastRider());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new BeastRider());
                break;
            case "Knight":
                but.setPawnOfBut(new Knight());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Knight());
                break;
            case "LavaBeast":
                but.setPawnOfBut(new LavaBeast());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new LavaBeast());
                break;
            case "Yeti":
                but.setPawnOfBut(new Yeti());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Yeti());
                break;
            case "Elf":
                but.setPawnOfBut(new Elf());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Elf());
                break;
            case "Sorceress":
                but.setPawnOfBut(new Sorceress());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Sorceress());
                break;
            case "Slayer":
                but.setPawnOfBut(new Slayer());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Slayer());
                break;
            case "Flag":
                but.setPawnOfBut(new Flag());
                but.setCanBePressed(false);
                tempPl.addAlivePawn(new Flag());
                break;
            case "Mage":
                but.setPawnOfBut(new Mage());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Mage());
                break;
            case "Dragon":
                but.setPawnOfBut(new Dragon());
                but.setCanBePressed(true);
                tempPl.addAlivePawn(new Dragon());
                break;
        }
        
        
        but.setXcoo(x);
        but.setYcoo(y);
        but.setCanBeAttacked(true);
        
        if(playerColor.equals("red"))
        {
            but.setPlayerBool(redPl);
            but.setHiddenImg(redHidden);
            imgName=pawnName+"R.png";
            but.setNormalImg(ImageIO.read(getClass().getResource("images/"+imgName)));
            but.setImgOfTurn(but.getNormalImg());
        }
        else
        {
            but.setPlayerBool(bluePl);
            but.setHiddenImg(blueHidden);
            imgName=pawnName+"B.png";
            but.setNormalImg(ImageIO.read(getClass().getResource("images/"+imgName)));
            but.setImgOfTurn(but.getNormalImg());
        }
    }

    
    /**
     * <br>Transformer: Sets endGame variable.
     * <br>Precondition: Argument set has to be of type boolean.
     * <br>Postcondition: endGame variable has been set.
     * @param set true if game ended, else false
     */
    public void setEndGame(boolean set)
    {
        this.endGame=set;
    }
    
    
    /**
     * <br>Transformer: Swaps all the information  of but1 with but2.
     * <br>Precondition: Arguments but1 and but2 have to be of type MyButton and but1!=null and but2!=null.
     * <br>Postcondition: Information  of buttons have been swapped.
     * @param but1 button number 1
     * @param but2 button number 2
     */
    public void swapButtonInfo(MyButton but1, MyButton but2) 
    {
        if(but2.getPawnOfBut().getName().equals("Helper"))
        {
            but2.setNormalImg(but1.getNormalImg());
            but2.setHiddenImg(but1.getHiddenImg());
            but2.setImgOfTurn(but2.getNormalImg());
            but2.setPawnOfBut(but1.getPawnOfBut());
            but2.setPlayerInt(but1.getPlayerInt());
            but2.setCanBePressed(true);
            this.makeBlankBut(but1);
            return;
        }
        Image imgNorm=but1.getNormalImg();
        Image imgHid=but1.getHiddenImg();
        Pawn tempPawn=but1.getPawnOfBut();
        int player=but1.getPlayerInt();
        boolean canPressed=but1.getCanBePressed();

        
        but1.setNormalImg(but2.getNormalImg());
        but1.setHiddenImg(but2.getHiddenImg());
        but1.setImgOfTurn(but1.getNormalImg());
        but1.setCanBePressed(but2.getCanBePressed());
        but1.setPawnOfBut(but2.getPawnOfBut());
        but1.setPlayerInt(but2.getPlayerInt());
        
        but2.setNormalImg(imgNorm);
        but2.setHiddenImg(imgHid);
        but2.setImgOfTurn(but2.getNormalImg());
        but2.setCanBePressed(canPressed);
        but2.setPawnOfBut(tempPawn);
        but2.setPlayerInt(player);
    }
    
    
    /**
     * <br>Accessor: Returns this turn's player ID. 
     * <br>Postcondition: This turn's player ID has been returned.
     * @return this turn's player ID
     */
    public int getTurnPlayerID()
    {
        return this.turn.getPlayerID();
    }
    
    
    /**
     * <br>Accessor: Returns last player's ID.
     * <br>Postcondition: Last player's ID has been returned.
     * @return lastPlayer ID
     */
    public int getTurnLastPlayerID()
    {
        return this.turn.getLastPlayerID();
    }

    
    /**
     * <br>Observer: Checks if player's move is correct.
     * <br>Precondition: Arguments start/dest have to be of type MyButton and start!=null and dest!=null.
     * <br>Postcondition: Move checked.
     * @param start button 
     * @param dest  button 
     * @return  true if move is correct, else false
     */
    public boolean check_move(MyButton start , MyButton dest)
    {
            if(dest.getCanBeAttacked())//Checks if destination button is not one of the 8 buttons that can not be attacked.
            {
                if(start.getPawnOfBut().getName().equals("Helper"))
                {
                    return false;
                }
                //if the destination button is the same, return false.
                if((start.getXcoo()==dest.getXcoo()) && (start.getYcoo()==dest.getYcoo()))
                {
                    return false;
                }
                //if the buttons belong to the same player, move is invalid.
                else if(start.getPlayerInt()==dest.getPlayerInt())
                {
                    return false;
                }
                else if(start.getPawnOfBut().getName().equals("Knight") || start.getPawnOfBut().getName().equals("BeastRider"))
                {
                    if(start.getXcoo()==dest.getXcoo())
                    {
                        int startY=start.getYcoo();
                        int destY=dest.getYcoo();
                        if((destY==startY+1) || (destY==startY+2) || (destY==startY-1) || (destY==startY-2))
                        {
                            if(destY==startY+2)
                            {
                                return gui.pawn_but[(start.getXcoo()*10)+(destY-1)].getPawnOfBut().getName().equals("Helper");
                            }
                            else if(destY==startY-2)  
                            {
                                return gui.pawn_but[(start.getXcoo()*10)+(destY+1)].getPawnOfBut().getName().equals("Helper");
                            }
                            return true;
                        }
                    }
                    else if(start.getYcoo()==dest.getYcoo())
                    {
                        int startX=start.getXcoo();
                        int destX=dest.getXcoo();
                        if((destX==startX+1) || (destX==startX+2) || (destX==startX-1) || (destX==startX-2))
                        {
                            if(destX==startX+2)
                            {
                                return gui.pawn_but[(start.getYcoo())+(destX-1)*10].getPawnOfBut().getName().equals("Helper");
                            }
                            else if(destX==startX-2)  
                            {
                                return gui.pawn_but[(start.getYcoo())+(destX+1)*10].getPawnOfBut().getName().equals("Helper");
                            }
                            return true;
                        }
                    }
                    else if(  (dest.getXcoo()==start.getXcoo()+1  ||  dest.getXcoo()==start.getXcoo()-1) &&  ((dest.getYcoo()==start.getYcoo()+1) || (dest.getYcoo()==start.getYcoo()-1)) )
                    {
                        return true;                        
                    }
                    return false;
                }
                else if(start.getPawnOfBut().getName().equals("Scout"))
                {
                    int distance=0;
                    int emptyButtons=0;
                    if(dest.getXcoo()==start.getXcoo())
                    {
                        int Xcoo=start.getXcoo()*10;
                        int startY=start.getYcoo();
                        int destY=dest.getYcoo();
                        if(destY>startY)
                        {
                            distance=destY-startY-1;
                            for(int i=destY-1; i>startY; i--)
                            {
                                if(!gui.pawn_but[Xcoo+i].getCanBeAttacked())
                                {
                                    continue;
                                }
                                else if(gui.pawn_but[Xcoo+i].getPawnOfBut().getName().equals("Helper"))
                                {
                                    emptyButtons++;
                                }
                            }
                            return emptyButtons==distance;
                        }
                        else
                        {
                            distance=startY-destY-1;
                            for(int i=destY+1; i<startY; i++)
                            {
                                if(!gui.pawn_but[Xcoo+i].getCanBeAttacked())
                                {
                                    continue;
                                }
                                else if(gui.pawn_but[Xcoo+i].getPawnOfBut().getName().equals("Helper"))
                                {
                                    emptyButtons++;
                                }
                            }
                            return emptyButtons==distance;
                        } 
                    }
                    else if(dest.getYcoo()==start.getYcoo())
                    {
                        int Ycoo=start.getYcoo();
                        int startX=start.getXcoo();
                        int destX=dest.getXcoo();

                        if(destX>startX)
                        {
                            distance=destX-startX-1;
                            for(int i=destX-1; i>startX; i--)
                            {
                                if(!gui.pawn_but[i*10+Ycoo].getCanBeAttacked())
                                {
                                    continue;
                                }
                                else if(gui.pawn_but[i*10+Ycoo].getPawnOfBut().getName().equals("Helper"))
                                {
                                    emptyButtons++;
                                }
                            }
                            return emptyButtons==distance;
                        }
                        else
                        {
                            distance=startX-destX-1;
                            for(int i=destX+1; i<startX; i++)
                            {
                                if(!gui.pawn_but[i*10+Ycoo].getCanBeAttacked())
                                {
                                    continue;
                                }
                                else if(gui.pawn_but[i*10+Ycoo].getPawnOfBut().getName().equals("Helper"))
                                {
                                    emptyButtons++;
                                }
                            }
                            return emptyButtons==distance;
                        }   
                    }
                }
                else
                {
                    //if the target button is diagonal, then return false.
                    if((dest.getXcoo()==start.getXcoo()+1 && dest.getYcoo()==start.getYcoo()+1) || (dest.getXcoo()==start.getXcoo()+1 && dest.getYcoo()==start.getYcoo()-1) || (dest.getXcoo()==start.getXcoo()-1 && dest.getYcoo()==start.getYcoo()-1) || (dest.getXcoo()==start.getXcoo()-1 && dest.getYcoo()==start.getYcoo()+1))
                    {
                        return false;
                    }
                    //if the distance from left/right/up/bottom between the target button and the button that wants to move is +1 or -1 return true, else false.
                    else if(dest.getXcoo()==start.getXcoo()+1 || dest.getXcoo()==start.getXcoo()-1 || dest.getXcoo()==start.getXcoo())
                    {
                        if(dest.getYcoo()==start.getYcoo()+1 || dest.getYcoo()==start.getYcoo()-1 || dest.getYcoo()==start.getYcoo())
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
            else
            {
                return false;
            }

        return false;
    }
 
    
    /**
     * <br>Transformer: Transforms the button into a blank button.
     * <br>Precondition: Argument but has to be of type MyButton and but!=null.
     * <br>Postcondition: Button has been transformed to blank button.
     * @param but a button
     */
    public void makeBlankBut(MyButton but) 
    {
        but.setNormalImg(blankBlock);
        but.setHiddenImg(blankBlock);
        but.setImgOfTurn(but.getNormalImg());
        but.setCanBeAttacked(true);
        but.setPawnOfBut(new Helper());
        but.setPlayer();  
    }
    
    
    /**
     * <br>Transformer: Makes the attack.
     * <br>Precondition: Arguments start/dest have to be of type MyButton and start!=null and dest!=null.
     * <br>Postcondition: Attack has been made.
     * @param start button that attacks
     * @param dest  button that is attacked
     * @return 1 if attacker wins,0 if attacker fails, 2 if flag is captured, else 3
     */
    public int check_attack(MyButton start , MyButton dest) 
    {
        //if destination button is a blank button, return 3.
        if(dest.getPawnOfBut().getName().equals("Helper"))
        {
            this.swapButtonInfo(start, dest);
            this.makeBlankBut(start);
            return 1;
        }
        else if(start.getPlayerInt()!=dest.getPlayerInt())
        {
            if(start.getPawnOfBut().getName().equals("Slayer") && dest.getPawnOfBut().getName().equals("Dragon"))
            {
                //red player makes the attack.
                if(start.getPlayerInt()==1)
                {
                    gui.text.setText("Slayer(Red)  killed  Dragon(Blue)");
                    this.swapButtonInfo(start, dest);
                    //after the swap, the start button contains the loser pawn.
                    bluePl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    
                    redPl.setFinished(true);
                }
                //blue player makes the attack.
                else if(start.getPlayerInt()==0)
                {
                    gui.text.setText("Slayer(Blue)  killed  Dragon(Red)");
                    this.swapButtonInfo(start, dest);
                    //after the swap, the start button contains the loser pawn.
                    redPl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    bluePl.setFinished(true);
                }
                return 1;
            }
        
            else if(start.getPawnOfBut().getName().equals("Dwarf") && dest.getPawnOfBut().getName().equals("Trap"))
            {
                if(start.getPlayerInt()==1)
                {
                    gui.text.setText("Dwarf(Red)  disarmed  Trap(Blue)");
                    this.swapButtonInfo(start, dest);
                    bluePl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    redPl.setFinished(true);
                }
                else if(start.getPlayerInt()==0)
                {
                    gui.text.setText("Dwarf(Blue)  disarmed  Trap(Red)");
                    this.swapButtonInfo(start, dest);
                    redPl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    bluePl.setFinished(true);
                }
                return 1; 
            }
            else if(dest.getPawnOfBut().getName().equals("Trap"))
            {
                if(start.getPlayerInt()==1)
                {
                    gui.text.setText(start.getPawnOfBut().getName()+"(Red) got killed by Trap(Blue)");
                    redPl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    redPl.setFinished(true);
                }
                else if(start.getPlayerInt()==0)
                {
                    gui.text.setText(start.getPawnOfBut().getName()+"(Blue) got killed by Trap(Red)");
                    bluePl.addFromAlivetoDead(start.getPawnOfBut());
                    makeBlankBut(start);
                    bluePl.setFinished(true);
                }
                return 0;
            }
            else if(dest.getPawnOfBut().getName().equals("Flag"))
            {
                String pl=turn.getPlayerID()==1?"Red":"Blue";
                String lpl=turn.getLastPlayerID()==1?"Red":"Blue";
                gui.text.setText(start.getPawnOfBut().getName()+"("+pl+") captured the flag("+lpl+")                            "+pl+" player is the winner!!");
                this.endGame=true;
                return 2;
            }
            else
            {
                if(start.getPawnOfBut().getRank()>dest.getPawnOfBut().getRank())
                {
                    if(start.getPlayerInt()==1)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Red)  attacked and killed  "+dest.getPawnOfBut().getName()+"(Blue)");
                        redPl.setFinished(true);
                        this.swapButtonInfo(start, dest);
                        bluePl.addFromAlivetoDead(start.getPawnOfBut());
                        makeBlankBut(start);
                    }
                    else if(start.getPlayerInt()==0)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Blue)  attacked and killed  "+dest.getPawnOfBut().getName()+"(Red)");
                        bluePl.setFinished(true);
                        this.swapButtonInfo(start, dest);
                        redPl.addFromAlivetoDead(start.getPawnOfBut());
                        makeBlankBut(start);
                    }
                    return 1;
                }
                //attacker loses, so there is no variables swap between these two buttons.
                else if(start.getPawnOfBut().getRank()<dest.getPawnOfBut().getRank())
                {
                    if(start.getPlayerInt()==1)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Red)  attacked and got killed by  "+dest.getPawnOfBut().getName()+"(Blue)");
                        redPl.addFromAlivetoDead(start.getPawnOfBut());
                        makeBlankBut(start);
                        redPl.setFinished(true);
                    }
                    else if(start.getPlayerInt()==0)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Blue)  attacked and got killed by  "+dest.getPawnOfBut().getName()+"(Red)");
                        bluePl.addFromAlivetoDead(start.getPawnOfBut());
                        makeBlankBut(start);
                        bluePl.setFinished(true);
                    }
                    return 0;
                }
                //both pawns get destroyed.
                else if(start.getPawnOfBut().getRank()==dest.getPawnOfBut().getRank())
                {
                    if(start.getPlayerInt()==1)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Red) and "+dest.getPawnOfBut().getName()+"(Blue) killed each other");
                        redPl.addFromAlivetoDead(start.getPawnOfBut());
                        bluePl.addFromAlivetoDead(dest.getPawnOfBut());
                        this.makeBlankBut(start);
                        this.makeBlankBut(dest);
                        redPl.setFinished(true);
                    }
                    else if(start.getPlayerInt()==0)
                    {
                        gui.text.setText(start.getPawnOfBut().getName()+"(Blue) and "+dest.getPawnOfBut().getName()+"(Red) killed each other");
                        bluePl.addFromAlivetoDead(start.getPawnOfBut());
                        redPl.addFromAlivetoDead(dest.getPawnOfBut());
                        this.makeBlankBut(start);
                        this.makeBlankBut(dest);
                        bluePl.setFinished(true);
                    }
                    return 0;
                }
            }
        }
        return 3;
    }
    
    
    /**
     * <br>Observer: Checks if a rescue is possible.
     * <br>Precondition: Argument but has to be of type MyButton and but!=null.
     * <br>Postcondition: Check for rescue possibility has been done.
     * @param but the button that wants to rescue a pawn
     * @return true if rescue is possible, else false
     */
    public boolean canRescue(MyButton but)
    {
        Player pl = but.getPlayerInt()==1? redPl:bluePl;

        if(but.getPawnOfBut().getName().equals("Scout")) 
        {
            JOptionPane.showMessageDialog(null,"A scout pawn can not rescue another pawn!","Rescue fail",1);
            return false;
        }
        else if(pl.getRescueCounter()==2)
        {
            JOptionPane.showMessageDialog(null,"You have already rescued 2 pawns, you can not rescue another one!","Rescue fail",1);
            return false;
        }
        else if(but.getPawnOfBut().getRescueCount()==1)
        {
            JOptionPane.showMessageDialog(null,"This pawn, has already rescued another one!","Rescue fail",1);
            return false;
        }
        else if(pl.getDeadCollSize()==0)
        {
            JOptionPane.showMessageDialog(null,"All your pawns are alive, you have no pawn for rescue!","Rescue fail",1);
            return false;
        }
       return true; 
    }
    
    
   
    /**
     * <br>Transformer: Brings back a pawn from the dead pawn collection,the pawn gets deployed into the battlefield within a button.
     * <br>Precondition: Argument but has to be of type MyButton and but!=null.
     * <br>Postcondition: Pawn added to player's alive pawn collection and removed from player's dead pawn collection.
     * @param but the button that wants to rescue a pawn
     * @throws java.io.IOException
     */
    public void makeRescue(MyButton but) throws IOException 
    {
        String pName=new String();

        JPanel rescuePanel = new JPanel();
        DefaultComboBoxModel deadPawns = new DefaultComboBoxModel();
        Player player = but.getPlayerInt()==1? redPl: bluePl;
        for(int i=0; i<player.getDeadCollSize(); i++)
        {
            if(!player.getDeadPawn(i).getName().equals("Trap"))
            {
                deadPawns.addElement(player.getDeadPawn(i).getName());
            }
        }
        JComboBox comboBox = new JComboBox(deadPawns);

        String Rescue[]={"Rescue"};
        int result = JOptionPane.showOptionDialog(rescuePanel,comboBox, "Rescue a pawn", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,null,Rescue,Rescue[0]);

        pName=(String)comboBox.getSelectedItem();
        but.getPawnOfBut().addRescueCount();

        if(player.getRedPlayer())
        {
            String pawnName = new String();
            for(int i=0; i<redPl.getDeadCollSize(); i++)
            {
                if(redPl.getDeadPawn(i).getName().equals(pName))
                {
                    pawnName=redPl.getDeadPawn(i).getName();
                    redPl.removeFromDeadColl(redPl.getDeadPawn(i));
                }
            }
            redPl.IncreaseRescueCounter();
            int num=0;
            for(int i=0; i<3; i++)
            {
                for(int y=0; y<9; i++)
                {
                    if(gui.pawn_but[num].getPawnOfBut().getName().equals("Helper"))
                    {
                        this.initPButton(gui.pawn_but[num], pawnName, "red", gui.pawn_but[num].getXcoo(), gui.pawn_but[num].getYcoo());
                        gui.text.setText("Red player rescued a "+pName);
                        return;
                    }
                    num++;
                }
            }
        }
        else
        {
            String pawnName = new String();
            for(int i=0; i<bluePl.getDeadCollSize(); i++)
            {
                if(bluePl.getDeadPawn(i).getName().equals(pName))
                {
                    pawnName=bluePl.getDeadPawn(i).getName();
                    bluePl.removeFromDeadColl(bluePl.getDeadPawn(i));
                }
            }
            bluePl.IncreaseRescueCounter();
            int num=50;
            for(int i=5; i<8; i++)
            {
                for(int y=0; y<9; i++)
                {
                    if(gui.pawn_but[num].getPawnOfBut().getName().equals("Helper"))
                    {
                        this.initPButton(gui.pawn_but[num], pawnName, "blue", gui.pawn_but[num].getXcoo(), gui.pawn_but[num].getYcoo());
                        gui.text.setText("Blue player rescued a "+pName);
                        return;
                    }
                    num++;
                }
            }
        }
    } 
    
    
    /**
     * <br>Observer: Checks if the button is blocked and can not move anymore.
     * <br>Precondition: Argument but has to be of type MyButton and but!=null.
     * <br>Postcondition: Returns true if the button is blocked, else false.
     * @param but the button 
     * @return  true if the button is blocked, else false
     */
    public boolean checkIfBlocked(MyButton but)
    {
        int x=but.getXcoo();
        int y=but.getYcoo();
        int num=x*10+y;
        if(y==0)
        {
            int blocked=0;
            if(x==0)
            {
                if(gui.pawn_but[10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[10].getPawnOfBut().getName().equals("Flag") )
                {
                    blocked++;
                }   
                if(gui.pawn_but[1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[1].getPawnOfBut().getName().equals("Flag"))
                {
                    blocked++;
                }
                return blocked==2;   
            }
            else if(x==7)
            {
                if(gui.pawn_but[60].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[60].getPawnOfBut().getName().equals("Flag") )
                {
                    blocked++;
                }   
                if(gui.pawn_but[71].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[71].getPawnOfBut().getName().equals("Flag"))
                {
                    blocked++;
                }
                return blocked==2; 
            }
            else
            {
                for(int i=0; i<10; i++)
                {
                    if(gui.pawn_but[num-10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-10].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    if(gui.pawn_but[num+10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+10].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    if(gui.pawn_but[num+1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+1].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    return blocked==3;
                }
            }
        }
        else if(y==9)
        {   
            int blocked=0;
            if(x==0)
            {
                if(gui.pawn_but[19].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[19].getPawnOfBut().getName().equals("Flag") )
                {
                    blocked++;
                }   
                if(gui.pawn_but[8].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[8].getPawnOfBut().getName().equals("Flag"))
                {
                    blocked++;
                }
                return blocked==2; 
            }
            else if(x==7)
            {
                if(gui.pawn_but[69].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[69].getPawnOfBut().getName().equals("Flag") )
                {
                    blocked++;
                }   
                if(gui.pawn_but[78].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[78].getPawnOfBut().getName().equals("Flag"))
                {
                    blocked++;
                }
                return blocked==2; 
            }
            else
            {
                for(int i=0; i<10; i++)
                {
                    if(gui.pawn_but[num-10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-10].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    if(gui.pawn_but[num+10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+10].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    if(gui.pawn_but[num-1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-1].getPawnOfBut().getName().equals("Flag"))
                    {
                        blocked++;
                    }
                    return blocked==3;
                }
            }
            
        }
        else if(x==0 || num==52 || num==53 || num==56 || num==57)
        {
            int blocked=0;
            if(gui.pawn_but[num-1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num+1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num+10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+10].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            return blocked==3;
        }
        else if(x==7 || num==22 || num==23 || num==26 || num==27)
        {
            int blocked=0;
            if(gui.pawn_but[num-1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num+1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num-10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-10].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            return blocked==3;
        }
        else
        {
            int blocked=0;
            if(gui.pawn_but[num-1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num+1].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+1].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num-10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num-10].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            if(gui.pawn_but[num+10].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[num+10].getPawnOfBut().getName().equals("Flag"))
            {
                blocked++;
            }
            return blocked==4;
        }
        return false;
    }
    
    
    /**
     * <br>Accessor: Checks if the game has ended.
     * <br>Postcondition: Check has finished and a value has been returned.
     * @return 1 if red player won,0 if blue player won, else 2
     */
    public int testEndGame()
    {
        if(this.endGame)
        {
            return turn.getLastPlayerID();
        }
        //Checks if blocked (pawns+flags+traps)==player's alive pawns, if so , then the player has lost due to not be able to move any pawn.
        int redAlive=redPl.getAliveCollSize();
            int redTF=0; //traps and flags of red player.
            int redBlocked=0;
            int blueAlive=bluePl.getAliveCollSize();
            int blueTF=0; //traps and flags of blue player.
            int blueBlocked=0;
        for(int i=0; i<80; i++)
        {
            if(gui.pawn_but[i].getPlayerInt()==1)
            {
                if(gui.pawn_but[i].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[i].getPawnOfBut().getName().equals("Flag"))
                {
                    redTF++;
                }
                else
                {
                    redBlocked=this.checkIfBlocked(gui.pawn_but[i])? redBlocked+1:redBlocked+0;
                }
            }
            else if(gui.pawn_but[i].getPlayerInt()==0)
            {
                if(gui.pawn_but[i].getPawnOfBut().getName().equals("Trap") || gui.pawn_but[i].getPawnOfBut().getName().equals("Flag"))
                {
                    blueTF++;
                }
                else
                {
                    blueBlocked=this.checkIfBlocked(gui.pawn_but[i])? blueBlocked+1:blueBlocked+0;
                }
                
            }
        }
        if(redTF+redBlocked==redAlive)
        {
            this.endGame=true;
            return 0;
        }
        else if(blueTF+blueBlocked==blueAlive)
        {
            this.endGame=true;
            return 1;
        }

         //checks if the previous player has only bombs and the trap in his alive pawn collection.
        int tf=0;       //counter for traps and flags.
        if(turn.getLastPlayerID()==1)
        {
            for(int i=0; i<redPl.getAliveCollSize(); i++)
            {
                if(redPl.getAlivePawn(i).getName().equals("Trap") || redPl.getAlivePawn(i).getName().equals("Flag") )
                {
                    tf++;
                }
            }
            if(tf==redPl.getAliveCollSize())
            {
                this.endGame=true;
                return 0;
            }
        }
        else if(turn.getLastPlayerID()==0)
        {
            for(int i=0; i<bluePl.getAliveCollSize(); i++)
            {
                if(bluePl.getAlivePawn(i).getName().equals("Trap") || bluePl.getAlivePawn(i).getName().equals("Flag") )
                {
                    tf++;
                }
            }
            if(tf==bluePl.getAliveCollSize())
            {
                this.endGame=true;
                return 1;
            }
        }
        return 2;
    }
            
            
    /**
     * <br>Transformer: Hides the buttons of the previous player, and reveals the next player's buttons, it also ends the game if there is a winner.
     * <br>Precondition: Arguments lastPlayer/nextPlayer have to be either 1 or 0, but not the same.
     * <br>Postcondition: Previous player's buttons are hidden, next player's buttons are revealed or game has ended if there was a winner.
     * @param lastPlayer previous player
     * @param nextPlayer next player
     */        
    public void hideButtons(int lastPlayer, int nextPlayer) 
    {
        
        //Checks if game has finished.
        int result=this.testEndGame();
       
        
        if(this.endGame)
        {
            String player=new String();
            if(result==1)
            {
                player="Red";
            }
            else
            {
                player="Blue";
            }
            gui.text.setText(player+" player is the winner!!");
            JOptionPane.showMessageDialog(null, player+" player is the winner!","Winner",1);
            
            Object options[] = { "Exit Game", "New Game" };
            int Panelresult=JOptionPane.showOptionDialog(null, "Do you want to Exit or Play Again?", "Select an Option",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
            options[0]);
            if(Panelresult==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
            else
            {
                try {
                    gui.setVisible(false); 
                    GraphicUI new_game=new GraphicUI();
                } catch (IOException ex) {
                    Logger.getLogger(GraphicUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return;
        }
        //Hides buttons if game continues.
        for(int i=0; i<80; i++)
        {
            gui.pawn_but[i].setCanBePressed(false);
            //hide the buttons of last player.
            if(gui.pawn_but[i].getPlayerInt()==lastPlayer)
            {
                gui.pawn_but[i].setImgOfTurn(gui.pawn_but[i].getHiddenImg());
            }
            
            //reveal the buttons of the next player.
            if(gui.pawn_but[i].getPlayerInt()==nextPlayer)
            {
                gui.pawn_but[i].setImgOfTurn(gui.pawn_but[i].getNormalImg());
                if(!gui.pawn_but[i].getPawnOfBut().getName().equals("Trap") && !gui.pawn_but[i].getPawnOfBut().getName().equals("Flag") )
                {
                    gui.pawn_but[i].setCanBePressed(true);
                }
            }
        }
    }
}