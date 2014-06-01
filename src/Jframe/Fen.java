package Jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fen extends JFrame{
	JPanel panBackground = new JPanel();
	JLabel lblAddUsine = new JLabel("Améliorer une Usine");
	
	public Fen(){
		Container cn = getContentPane();
		String path = "/Users/ivanklarman/Documents/workspace/QAWIWeb/src/Jframe/planet.jpg";
		try{
			BufferedImage image = ImageIO.read(new File(path));
			Image contentPane = new Image(image);
			contentPane.setBounds(0, 0, image.getWidth(), image.getHeight());
			cn.add(contentPane,BorderLayout.CENTER);
		}catch(Exception e){
			System.out.println("Image Non chargée");
		}
	    lblAddUsine.setForeground(Color.white);
		panBackground.setBackground(Color.black);
		panBackground.add(lblAddUsine,BorderLayout.CENTER);
		//cn.add(panBackground);
		setBounds(250, 250, 500, 500);
		setResizable(true);
		setVisible(true);
	}
}
