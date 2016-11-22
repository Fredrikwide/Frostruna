package Frost;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FrostFrame extends JFrame implements KeyListener {
	FrostMenu menu;
	FrostGame game;
	boolean gamestarted;
	
	public FrostFrame(String string) throws HeadlessException {
		super(string);
		newMenu();
		addKeyListener(this);
	}

	private void newMenu() {
		menu = new FrostMenu();
		super.add(menu);
		this.gamestarted = false;
	}
	
	private void newGame() {
		super.remove(menu);
		menu = null;
		game = new FrostGame();
		super.add(game);
		super.validate();
		this.gamestarted = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!gamestarted) {
	        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
	        	menu.toggleSelection();
	        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        	if (menu.getSelection() == 0) {
	        		newGame();
	        	} else {
	        		System.exit(0);
	        	}
	        }
		} else {
			game.handleKeyPress(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
}
