/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rohan
 */
public class GamePanel extends javax.swing.JPanel {

	public static final int X_SIZE = 640;
	public static final int Y_SIZE = 640;
	public static double LB_X = -2.3;
	public static double UB_X = 2.3;
	public static double LB_Y = -2.3;
	public static double UB_Y = 2.3;
	public static double LENGTH = UB_X - LB_X;

	public GamePanel() {
		this.addMouseWheelListener(new Controller());
	}

	@Override
	public java.awt.Dimension getPreferredSize() {
		return new java.awt.Dimension(X_SIZE, Y_SIZE);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < X_SIZE; i++) {
			for (int j = 0; j < Y_SIZE; j++) {
		double pctX = i / (double) GamePanel.X_SIZE;
		double pctY = j / (double) GamePanel.Y_SIZE;

		double xCoord = GamePanel.UB_X * pctX + GamePanel.LB_X * (1 - pctX);
		double yCoord = GamePanel.UB_Y * pctY + GamePanel.LB_Y * (1 - pctY);

		double c0 = xCoord, c1 = yCoord;
		int it;
		for(it = 0;it<100;it++){
			double re = c0*c0 - c1*c1 + xCoord;
			double im = c0 * c1 * 2 + yCoord;
			c0 = re;
			c1 = im;
		if(Math.sqrt(c0*c0+c1*c1)>2.1/*arbitrary disk cutoff*/){ 
			break;
		}
		}
		
		g.setColor(it==100?Color.black:Color.red);
		
		g.fillRect(i, j, 1, 1);
		
			}
		}
	}
}
