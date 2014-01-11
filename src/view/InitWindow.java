package view;

import javax.swing.Box;

import java.awt.Dimension;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.InitWindowModel;

import controller.BoundException;
import controller.OkButton;


public class InitWindow extends JFrame implements KeyListener{

	
	private JTextField heightToWrite;
	private JTextField widthToWrite;

	public InitWindow() {
		super();
		JPanel panel = (JPanel) this.getContentPane() ;
		
		this.setSize(180,180);
		this.setLocationRelativeTo(null);
		
		// Création des éléments constitutifs de la fenêtre
		this.setTitle("Size");
		JLabel height = new JLabel("Height");
		heightToWrite = new JTextField("15") ;
		heightToWrite.setSize(4,2);
		heightToWrite.addKeyListener(this);
		JLabel width = new JLabel("Width");
		widthToWrite = new JTextField("15") ;
		widthToWrite.addKeyListener(this);
		OkButton okButton = new OkButton(this);
		JLabel intro = new JLabel("Welcome in SuperMaze !");
		
		
		 //box d'introduction
		Box iBox = Box.createHorizontalBox();
		iBox.add(intro);
		
		 //box contenant la ligne "height"
		Box hBox = Box.createHorizontalBox();
		hBox.add(Box.createHorizontalStrut(5));
		hBox.add(height);
		hBox.add(Box.createHorizontalStrut(10));
		hBox.add(heightToWrite);
		hBox.add(Box.createHorizontalStrut(5));
		
		 //box contenant la ligne "width"
		Box wBox = Box.createHorizontalBox();
		wBox.add(Box.createHorizontalStrut(5));
		wBox.add(width);
		wBox.add(Box.createHorizontalStrut(10));
		wBox.add(widthToWrite);
		wBox.add(Box.createHorizontalStrut(5));
		

		//box contenant les boutons
		Box bBox = Box.createHorizontalBox(); 
		bBox.add(okButton);

		
			
		//box principale contenant les autres box
		Box mBox = Box.createVerticalBox() ; 
		mBox.add(Box.createVerticalStrut(5));
		mBox.add(iBox);
		mBox.add(Box.createVerticalStrut(10));
		mBox.add(hBox);
		mBox.add(Box.createVerticalStrut(10));
		mBox.add(wBox);
		mBox.add(Box.createVerticalStrut(10));
		mBox.add(bBox);
		mBox.add(Box.createVerticalStrut(5));

		panel.add(mBox);
		this.setVisible(true) ;
	}

	public JTextField getJTextHeight() {
		return heightToWrite;
	}

	public JTextField getJTextWidth() {
		return widthToWrite;
	}
	public void createGW(){
		int heightUser ; int widthUser;
		
		try{
			heightUser=Integer.parseInt( this.getJTextHeight().getText() );  /*parse en entier le string contenu dans le JText relatif 
			à Height appele JTextHeight,on utilise la methode getText de ce denier pour recuperer la height en string*/ 													   	
			widthUser=Integer.parseInt( this.getJTextWidth().getText() );
			InitWindowModel.setHeight(heightUser);
			InitWindowModel.setWidth(widthUser);
			new GameWindow();
			this.dispose() ;
		
		}catch (NumberFormatException e){
		
			System.out.println("Empty case(s)");
			new ErrorWindow("Please enter values for Height and Width");
		
		}catch (BoundException be){
		
			JOptionPane.showMessageDialog(null, be.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	// Ce listener ne marche pas : il faudrait créer une fenêtre de jeu en pressant la touche entrée...
	public void keyTyped(KeyEvent e) { 
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER){
			this.createGW();
		}
		
	}


}
