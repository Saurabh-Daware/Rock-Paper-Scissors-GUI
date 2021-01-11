package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainActivity {
	
//	panel initialization
	JPanel IntroPanel = new JPanel();
	JPanel GamePanel = new JPanel();
	int UserScore, ComScore;

//	Main activity constructor
	MainActivity() {
		JFrame frame = new JFrame("Rock - Paper - Scissors");
		frame.setSize(625, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(IntroPanel);
		frame.add(GamePanel);
		placeIntroComponents(IntroPanel);
		placeGameComponents(GamePanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		IntroPanel.setVisible(true);
		GamePanel.setVisible(false);
		startGame();
	}

	public static void main(String[] args) throws IOException{
		
		MainActivity main = new MainActivity();
	}
	

//	Places components in IntroPanel and handles ngButton click
	
	private void placeIntroComponents(JPanel IntroPanel) {
		
		IntroPanel.setLayout(null);
		
//		Computer score
		JLabel comScoreLabel = new JLabel(String.valueOf(ComScore));
		comScoreLabel.setBounds(45, 50, 175, 220);
		comScoreLabel.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 200));
		IntroPanel.add(comScoreLabel);
		JLabel Computer = new JLabel("    Computer");
		Computer.setBounds(35, 240, 175, 40);
		Computer.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 20));
		IntroPanel.add(Computer);

//		User Score
		JLabel userScoreLabel = new JLabel(String.valueOf(UserScore));
		userScoreLabel.setBounds(390, 20, 175, 220);
		userScoreLabel.setFont(new Font(userScoreLabel.getFont().getName(), Font.PLAIN, 200));
		IntroPanel.add(userScoreLabel);
		
//		User Label
		JLabel User = new JLabel("    User");
		User.setBounds(400, 240, 175, 40);
		User.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 20));
		IntroPanel.add(User);

//		New Game Button
		JButton ngButton = new JButton("New Game");
		ngButton.setBounds(220, 300, 150, 30);
		ngButton.setBorder(BorderFactory.createEmptyBorder());
		ngButton.setBackground(Color.white);
		IntroPanel.add(ngButton);
		ngButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				startGame();
				System.out.println("OK");
			}
		});
	}

//	Places components in GamePanel
	private void placeGameComponents(JPanel gamePanel) {
		
		GamePanel.setLayout(null);
		String Info = "Choose your hand!";
		
//		Loading image
		BufferedImage RockImg = null, PaperImg = null, ScissorsImg = null;
		try {
			RockImg = ImageIO.read(new File("src/res/Rock.png"));
			PaperImg = ImageIO.read(new File("src/res/Paper.png"));
			ScissorsImg = ImageIO.read(new File("src/res/Scissors.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
//		Rock Button
		JButton Rock = new JButton(new ImageIcon(RockImg));
		Rock.setBounds(15, 90, 185, 180);
		Rock.setBorder(BorderFactory.createEmptyBorder());
		gamePanel.add(Rock);
		Rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Rock");
			}
		});
		

//		Paper Button
		JButton Paper = new JButton(new ImageIcon(PaperImg));
		Paper.setBounds(210, 90, 190, 180);
		Paper.setBorder(BorderFactory.createEmptyBorder());
		gamePanel.add(Paper);
		Paper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Paper");
			}
		});
		
		
//		Scissors Button
		JButton Scissors = new JButton(new ImageIcon(ScissorsImg));
		Scissors.setBounds(410, 90, 190, 180);
		Scissors.setBorder(BorderFactory.createEmptyBorder());
		gamePanel.add(Scissors);
		Scissors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Scissors");
			}
		});
		
		JLabel infoLabel = new JLabel(Info);
		infoLabel.setBounds(200, 20, 300, 30);
		infoLabel.setFont(new Font(infoLabel.getFont().getName(), Font.PLAIN, 25));
		GamePanel.add(infoLabel);
	}
	
//		Hides introduction panel and starts game
	private void startGame() {
		IntroPanel.setVisible(false);
		GamePanel.setVisible(true);
	}
}
