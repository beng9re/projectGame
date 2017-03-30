package game;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;



public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		
		
		
		
		
		
		gamePanel=new GamePanel();
		gamePanel.setFocusable(true);
		add(gamePanel);
	
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GameWindow();
	}
	
}
