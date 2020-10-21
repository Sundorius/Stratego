package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



/**
 * This class represents the main screen of the game.
 * @author Sundorius
 */
public class GraphicUI extends JFrame
{
    private MyButton ExitBut, NewGameBut;
    public MyButton[] pawn_but = new MyButton[80];
    public JTextArea text = new JTextArea(); 

    private JPanel pawn_pane=new JPanel();
    private JPanel option_pane=new JPanel();

    private final Image blockBlue=ImageIO.read(getClass().getResource("images/blueBlock.png"));
    private final Image blockRed=ImageIO.read(getClass().getResource("images/redBlock.png"));

    private boolean iconSelected;
    private MyButton startButt;
    private Controller cont;
    private PawnListener pLis;
    
    /**
     * <br>Constructor: Creates a new window and initializes the 
     * necessary buttons and panels.
     * <br>Postcondition: Creates a new window and initializes the 
     * necessary buttons and panels, and starts a new game.
     * @throws java.io.IOException
     */
    public GraphicUI() throws IOException 
    {
        super("Stratego");
        setSize(1200,750);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pawn_pane.setLayout(new GridLayout(8,10));//Layout for pawns.
        this.option_pane.setLayout(new GridLayout(3,1));//Layout for options.
        this.option_pane.setBackground(Color.white);
        
        this.iconSelected=false;
        this.pLis = new PawnListener();
        
        
        this.cont=new Controller(this);
        
        this.ExitBut=new MyButton();
        this.NewGameBut=new MyButton();
        this.ExitBut.addActionListener(new ExitButListener());
        this.NewGameBut.addActionListener(new NewGameButListener());
        
        atStart();    
    }

    
    /**
     * <br>Transformer: Makes the starting screen of the game.
     * <br>Postcondition: Starting screen of the game has been made.
     * @throws IOException
     */
    //This happens only one time, at the beginning of the game.
    public void atStart() throws IOException
    {
        this.initOptionButtons();
        int y=-1;
        for(int i=0; i<80; i++)
        {
            pawn_but[i]=new MyButton();
            pawn_but[i].addMouseListener(pLis);
            y++;
            if(i==30 || i==40)
            {
                y=0;
            }
            
            //buttons for red player
            if(i<30)
            {
                switch(i)
                {
                    case 0:  cont.initPButton(pawn_but[i],"LavaBeast","red",0,0); break;
                    case 1:  cont.initPButton(pawn_but[i],"Trap","red",0,1); break;
                    case 2:  cont.initPButton(pawn_but[i],"Trap","red",0,2); break;
                    case 3:  cont.initPButton(pawn_but[i],"Flag","red",0,3); break;
                    case 4:  cont.initPButton(pawn_but[i],"Dragon","red",0,4); break;
                    case 5:  cont.initPButton(pawn_but[i],"BeastRider","red",0,5); break;
                    case 6:  cont.initPButton(pawn_but[i],"LavaBeast","red",0,6); break;
                    case 7:  cont.initPButton(pawn_but[i],"Elf","red",0,7); break;
                    case 8:  cont.initPButton(pawn_but[i],"Scout","red",0,8); break;
                    case 9:  cont.initPButton(pawn_but[i],"Dwarf","red",0,9); break;
                    case 10: cont.initPButton(pawn_but[i],"Sorceress","red",1,0); break;
                    case 11: cont.initPButton(pawn_but[i],"Scout","red",1,1); break;
                    case 12: cont.initPButton(pawn_but[i],"Trap","red",1,2); break;
                    case 13: cont.initPButton(pawn_but[i],"Knight","red",1,3); break;
                    case 14: cont.initPButton(pawn_but[i],"Slayer","red",1,4); break;
                    case 15: cont.initPButton(pawn_but[i],"Dwarf","red",1,5); break;
                    case 16: cont.initPButton(pawn_but[i],"BeastRider","red",1,6); break;
                    case 17: cont.initPButton(pawn_but[i],"Mage","red",1,7); break;
                    case 18: cont.initPButton(pawn_but[i],"Elf","red",1,8); break;
                    case 19: cont.initPButton(pawn_but[i],"Trap","red",1,9); break;
                    case 20: cont.initPButton(pawn_but[i],"Scout","red",2,0); break;
                    case 21: cont.initPButton(pawn_but[i],"Trap","red",2,1); break;
                    case 22: cont.initPButton(pawn_but[i],"Dwarf","red",2,2); break;
                    case 23: cont.initPButton(pawn_but[i],"Knight","red",2,3); break;
                    case 24: cont.initPButton(pawn_but[i],"Trap","red",2,4); break;
                    case 25: cont.initPButton(pawn_but[i],"Sorceress","red",2,5); break;
                    case 26: cont.initPButton(pawn_but[i],"Dwarf","red",2,6); break;
                    case 27: cont.initPButton(pawn_but[i],"Scout","red",2,7); break;
                    case 28: cont.initPButton(pawn_but[i],"BeastRider","red",2,8); break;
                    case 29: cont.initPButton(pawn_but[i],"Dwarf","red",2,9); break;            
                }
                pawn_but[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                pawn_pane.add(pawn_but[i]);
            }
            //buttons for blue player
            else if (i>=50 )
            {
                switch(i)
                {
                    case 50:cont.initPButton(pawn_but[i],"Dwarf","blue",5,0); break;
                    case 51:cont.initPButton(pawn_but[i],"Scout","blue",5,1); break;
                    case 52:cont.initPButton(pawn_but[i],"Trap","blue",5,2); break;
                    case 53:cont.initPButton(pawn_but[i],"Sorceress","blue",5,3); break;
                    case 54:cont.initPButton(pawn_but[i],"Elf","blue",5,4); break;
                    case 55:cont.initPButton(pawn_but[i],"Yeti","blue",5,5); break;
                    case 56:cont.initPButton(pawn_but[i],"BeastRider","blue",5,6); break;
                    case 57:cont.initPButton(pawn_but[i],"Dwarf","blue",5,7); break;
                    case 58:cont.initPButton(pawn_but[i],"Trap","blue",5,8); break;
                    case 59:cont.initPButton(pawn_but[i],"Scout","blue",5,9); break;
                    case 60:cont.initPButton(pawn_but[i],"BeastRider","blue",6,0); break;
                    case 61:cont.initPButton(pawn_but[i],"Trap","blue",6,1); break;
                    case 62:cont.initPButton(pawn_but[i],"Trap","blue",6,2); break;
                    case 63:cont.initPButton(pawn_but[i],"Dragon","blue",6,3); break;
                    case 64:cont.initPButton(pawn_but[i],"Knight","blue",6,4); break;
                    case 65:cont.initPButton(pawn_but[i],"Dwarf","blue",6,5); break;
                    case 66:cont.initPButton(pawn_but[i],"Slayer","blue",6,6); break;
                    case 67:cont.initPButton(pawn_but[i],"Scout","blue",6,7); break;
                    case 68:cont.initPButton(pawn_but[i],"Yeti","blue",6,8); break;
                    case 69:cont.initPButton(pawn_but[i],"Mage","blue",6,9); break;                                            
                    case 70:cont.initPButton(pawn_but[i],"Sorceress","blue",7,0); break;         
                    case 71:cont.initPButton(pawn_but[i],"Dwarf","blue",7,1); break;    
                    case 72:cont.initPButton(pawn_but[i],"Elf","blue",7,2); break;    
                    case 73:cont.initPButton(pawn_but[i],"Trap","blue",7,3); break;    
                    case 74:cont.initPButton(pawn_but[i],"Flag","blue",7,4); break;    
                    case 75:cont.initPButton(pawn_but[i],"Knight","blue",7,5); break;    
                    case 76:cont.initPButton(pawn_but[i],"Trap","blue",7,6); break;    
                    case 77:cont.initPButton(pawn_but[i],"BeastRider","blue",7,7); break;    
                    case 78:cont.initPButton(pawn_but[i],"Dwarf","blue",7,8); break;    
                    case 79:cont.initPButton(pawn_but[i],"Scout","blue",7,9); break;                           
                }
                pawn_but[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                pawn_pane.add(pawn_but[i]);
            }
            //buttons that can not be pressed and can not be attacked.
            else if(i==32 || i==33 || i==42 || i==43)
            {
                pawn_but[i]=new MyButton();
                pawn_but[i].setBorderPainted( false );
                pawn_but[i].setFocusPainted( false );
                pawn_but[i].setNormalImg(blockBlue);
                pawn_but[i].setCanBePressed(false);
                pawn_but[i].setCanBeAttacked(false);
                pawn_but[i].setImgOfTurn(pawn_but[i].getNormalImg());
            }
            else if(i==36 || i==37 || i==46 || i==47)
            {
                pawn_but[i]=new MyButton();
                pawn_but[i].setBorderPainted( false );
                pawn_but[i].setFocusPainted( false );
                pawn_but[i].setNormalImg(blockRed);
                pawn_but[i].setCanBePressed(false);
                pawn_but[i].setCanBeAttacked(false);
                pawn_but[i].setImgOfTurn(pawn_but[i].getNormalImg());
            }
            //Blank buttons.
            else
            {
                cont.makeBlankBut(pawn_but[i]);
                pawn_but[i].setXcoo(Integer.parseInt(Integer.toString(i).substring(0, 1)));
                pawn_but[i].setYcoo(y);
                pawn_but[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                pawn_but[i].setCanBePressed(false);                
            }
                pawn_pane.add(pawn_but[i]);
        }
        cont.hideButtons( cont.getTurnLastPlayerID(), cont.getTurnPlayerID());

        text.setEditable(false);
        text.setOpaque(false);
        text.setFont(new java.awt.Font("Serif Bold", 0, 12));
        text.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
        text.setText("Welcome to Stratego. Play fair and have fun!");
        this.add(option_pane,BorderLayout.WEST);
        this.add(text,BorderLayout.PAGE_START);
        this.add(pawn_pane);
        setVisible(true);
    }

    
    /**
     * <br>Transformer:Sets the option buttons.
     * <br>Postcondition: Option buttons have been set.
     * @throws java.io.IOException
     */
    //This happens only one time, at the beginning of the game.
    public void initOptionButtons() throws IOException 
    {
        
        //Exit Button
        ExitBut.setBorderPainted(false);
        ExitBut.setContentAreaFilled(false);
        ExitBut.setNormalImg(ImageIO.read(getClass().getResource("images/exit.png")));
        ExitBut.setImgOfTurn(ExitBut.getNormalImg());

        
        //New Game Button
        NewGameBut.setBorderPainted(false);
        NewGameBut.setContentAreaFilled(false);
        NewGameBut.setNormalImg(ImageIO.read(getClass().getResource("images/newGame.png")));
        NewGameBut.setImgOfTurn(NewGameBut.getNormalImg());
        
        
        //Add Exit,NewGame Buttons to panel.
        option_pane.add(ExitBut);    
        option_pane.add(NewGameBut);
    }
    
    
    /**
     * This class checks if the move/attack of the button is valid,if it is valid it does the necessary modifications.
     */
    public class PawnListener implements MouseListener
    {
        /**
         * <br>Transformer: Checks if the move/attack of the button is valid,if it is valid it does the necessary modifications.
         * <br>Postcondition: If move/attack is valid, necessary modifications are made.
         * @param me mouse event
         **/
        @Override
        public void mouseClicked(MouseEvent me)
        {
            MyButton dest = ((MyButton) me.getSource());
            if(iconSelected )
            {
                //startButt is the button the player wants to move, dest is the button that the player wants to attack or to move to.
                //checks if move is valid.
                if(cont.check_move(startButt,dest))
                {
                    int result=cont.check_attack(startButt, dest);
                    
                    //after the attack the winner pawn, has taken the place of the loser, so the button that contains the winner pawn
                    //which wants to make a rescue, is the dest pawn!!
                    if(dest.getPlayerInt()==1 && dest.getXcoo()==7)
                    {
                        if(result==1)
                        {
                            if(cont.canRescue(dest))
                            {
                                try 
                                {
                                    cont.makeRescue(dest);
                                } 
                                catch (IOException ex) 
                                {
                                    Logger.getLogger(GraphicUI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                        }
                    }
                    else if(dest.getPlayerInt()==0 && dest.getXcoo()==0)
                    {
                        if(result==1)
                        {
                            if(cont.canRescue(dest))
                            {
                                try 
                                {
                                    cont.makeRescue(dest);
                                } 
                                catch (IOException ex) 
                                {
                                    Logger.getLogger(GraphicUI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                    startButt.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
                    iconSelected=false;
                        
                    //makes the ID's of the players for the next turn.
                    cont.turn.nextTurn();
                        
                    //reveals the buttons of the next player for the next round.
                    cont.hideButtons(cont.getTurnLastPlayerID(), cont.getTurnPlayerID()); 
                }   
                else
                {
                    startButt.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                    dest.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                    iconSelected=false;  
                }
            }
            //if no button is pressed, but the desired button is pressable, do the code below.
            if(!iconSelected && dest.getCanBePressed())
            {
                iconSelected=true;
                startButt=dest;
                dest.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
            }
        }

        
        @Override public void mousePressed(MouseEvent me) {}
        @Override public void mouseReleased(MouseEvent me) {}
        @Override public void mouseEntered(MouseEvent me) {}
        @Override public void mouseExited(MouseEvent me) {}
    }
    
    
 
    
    
    /**
     * Closes the game if the player presses the YES option of the ExitGame button. 
     */
    public class ExitButListener implements ActionListener
    {
        /**
         * <br>Transformer: Closes the game if the player presses the YES option of the ExitGame button. 
         * <br>Postcondition: Closes the game if the player presses the YES option of the ExitGame button. 
         * @param ae ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Exit",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }          
    }
    
    
    /**
     * Creates a new game if the player presses the YES option of the NewGame button.
     */
    public class NewGameButListener implements ActionListener
    {
        /**
         * <br>Transformer: Creates a new GraphicUI and start the game from the beginning,if player chose the YES option, else nothing happens.
         * <br>Postcondition: New GraphicUI created and new game started, if player chose the YES option, else nothing happens.
         * @param ae ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to start a new game?", "New Game",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result==JOptionPane.YES_OPTION)
            {
                try {
                    setVisible(false); 
                    GraphicUI new_game=new GraphicUI();
                } catch (IOException ex) {
                    Logger.getLogger(GraphicUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    }
}
