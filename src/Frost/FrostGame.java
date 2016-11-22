package Frost;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FrostGame extends JPanel {

	private JPanel southPnl;
	private JPanel northPnl;
	private JPanel mainPnl;

	private JLabel nwlbl;
	private JLabel northlbl;
	private JLabel southlbl;

	private BorderLayout bL;
	private TitledBorder titleN;
	private TitledBorder titleC;
	

	public FrostGame() {
		
		this.titleN = new TitledBorder("North");
		this.titleC = new TitledBorder("South");

		this.bL = new BorderLayout();

		this.northPnl = new JPanel();
		this.mainPnl = new JPanel();
		this.southPnl = new JPanel();

		this.northlbl = new JLabel();
		this.southlbl = new JLabel();
		this.nwlbl = new JLabel();

		setMainPanel();
		setBorders();
		setNorthPanel();
		setSouthPanel();
		addPanels();
		addLabels();
	}
	
	private void addLabels() {
		GridBagConstraints gbc = new GridBagConstraints();
		northPnl.add(northlbl);
		southPnl.add(southlbl, gbc);
		southPnl.add(nwlbl);
	}

	private void addPanels() {
		add(mainPnl);
		mainPnl.add(northPnl, BorderLayout.NORTH);
		mainPnl.add(southPnl, BorderLayout.CENTER);
	}

	private void setBorders() {
		titleN.setTitleJustification(TitledBorder.CENTER);
		titleN.setTitleColor(Color.WHITE);

		titleC.setTitleJustification(TitledBorder.CENTER);
		titleC.setTitleColor(Color.WHITE);
	}

	private void setMainPanel() {
		mainPnl.setLayout(bL);
	}

	private void setSouthPanel() {
		southPnl.setLayout(new GridBagLayout());	
		southPnl.setPreferredSize(new Dimension(1000, 520));
		southPnl.setBackground(Color.BLACK);
		southPnl.setAlignmentX(0);
	}

	private void setNorthPanel() {
		northPnl.setPreferredSize(new Dimension(1000, 260));
		northPnl.setBackground(Color.BLACK);
		northPnl.setAlignmentX(0);
	}

	public void handleKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		southPnl.setBackground(Color.MAGENTA);
	}

}
