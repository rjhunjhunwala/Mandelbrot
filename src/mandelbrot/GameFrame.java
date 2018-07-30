/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import javax.swing.JFrame;

/**
 *
 * @author rohan
 */
public class GameFrame extends JFrame{
	public GameFrame(){
		super("Mandelbrot: Interactive View.");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new GamePanel());
		this.pack();
	
	}
}
