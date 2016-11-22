package Frost;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FrostMenu extends JPanel {

	String fontPath = "./font/ENDOR___.ttf";
	private JPanel southPnl;
	private JPanel northPnl;
	private JPanel mainPnl;

	private JLabel nwlbl;
	private JLabel northlbl;
	private JLabel southlbl;

	private BorderLayout bL;
	private TitledBorder titleN;
	private TitledBorder titleC;
	
	private int selection;

	public FrostMenu() {
		this.selection = 0;
		
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
		setNorthLabel();
		setSouthLabel();
		addPanels();
		addLabels();
	}
	
	public int getSelection() {
		return selection;
	}

	private Font getFonts() {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(16f);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
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
		northPnl.setBorder(titleN);
		southPnl.setBorder(titleC);

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

	private void setSouthLabel() {
		GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(getFonts());
		southlbl.setForeground(Color.WHITE);
		StringBuffer sb = new StringBuffer();
		sb.append("<html><font face=\"Endor\">");
		
		if (this.selection  == 0)
			sb.append("[ START ]<br><br>");
		else
			sb.append("START<br><br>");
		if (this.selection == 1)
			sb.append("[ CLOSE ]");
		else
			sb.append("CLOSE");

		southlbl.setText(sb.toString());
		southlbl.setVerticalTextPosition(SwingConstants.CENTER);
	}

	private void setNorthLabel() {
		StringBuffer sb = new StringBuffer();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:\\Users\\ZeroCool\\workspace\\FrostStjärna\\ascii\\Asciiheader.txt"), "UTF-8"));
			sb.append("<HTML><font size=\"5\">");
			while (br.ready()) {
				sb.append("<pre>" + br.readLine() + "</pre>");
			}
			sb.append("</font></HTML>");
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		northlbl.setForeground(Color.WHITE);
		northlbl.setText(sb.toString());
		northlbl.setVerticalTextPosition(SwingConstants.CENTER);
	}
	
	public void toggleSelection() {
		this.selection++;
		this.selection %= 2;
		setSouthLabel();
	}

}