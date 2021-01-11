package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainActivity {
	
	JPanel IntroPanel = new JPanel();
	JPanel GamePanel = new JPanel();
	int UserScore, ComScore;
	
	MainActivity() {
		JFrame frame = new JFrame("Rock - Paper - Scissors");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(IntroPanel);
		frame.add(GamePanel);
		placeIntroComponents(IntroPanel);
		placeGameComponents(GamePanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		IntroPanel.setVisible(true);
		GamePanel.setVisible(false);
	}


	public static void main(String[] args) throws IOException{
		MainActivity main = new MainActivity();
	}
	
	private void startGame() {
		IntroPanel.setVisible(false);
		GamePanel.setVisible(true);
	}

	private void placeIntroComponents(JPanel IntroPanel) {
		
		IntroPanel.setLayout(null);
		
		JLabel comScoreLabel = new JLabel(String.valueOf(ComScore));
		comScoreLabel.setBounds(45, 20, 175, 220);
		comScoreLabel.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 200));
		IntroPanel.add(comScoreLabel);
		JLabel Computer = new JLabel("    Computer");
		Computer.setBounds(35, 240, 175, 40);
		Computer.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 20));
		IntroPanel.add(Computer);

		JLabel userScoreLabel = new JLabel(String.valueOf(UserScore));
		userScoreLabel.setBounds(390, 20, 175, 220);
		userScoreLabel.setFont(new Font(userScoreLabel.getFont().getName(), Font.PLAIN, 200));
		IntroPanel.add(userScoreLabel);
		
		JLabel User = new JLabel("    User");
		User.setBounds(400, 240, 175, 40);
		User.setFont(new Font(comScoreLabel.getFont().getName(), Font.PLAIN, 20));
		IntroPanel.add(User);

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

	private void placeGameComponents(JPanel gamePanel) {
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/res/Rock.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton Rock = new JButton(new ImageIcon(img));
		Rock.setBounds(20, 30, 50, 30);
		Rock.setBorder(BorderFactory.createEmptyBorder());
		gamePanel.add(Rock);
		Rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("OK");
			}
		});
	}
}
