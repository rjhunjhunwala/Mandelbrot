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

	public static final int X_SIZE = 480;
	public static final int Y_SIZE = 480;
	public static double LB_X = -2;
	public static double UB_X = 1.3;
	public static double LB_Y = -1.5;
	public static double UB_Y = 1.8;
	public static double LENGTH = UB_X - LB_X;

	public GamePanel() {
		this.addMouseWheelListener(new Controller());
		this.addMouseListener(new Mover());
	}

	@Override
	public java.awt.Dimension getPreferredSize() {
		return new java.awt.Dimension(X_SIZE, Y_SIZE);
	}

	public static final int ITERATIONS = 205;

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
				for (it = 0; it < ITERATIONS; it++) {
					double re = c0 * c0 - c1 * c1 + xCoord;
					double im = c0 * c1 * 2 + yCoord;
					c0 = re;
					c1 = im;
					if (Math.sqrt(c0 * c0 + c1 * c1) > 10.1/*arbitrary disk cutoff*/) {
						break;
					}
				}

				int r = 0;
				int gr = 0;
				int b = 0;
				double pct = it / (double) ITERATIONS;
				double prog = (pct % (1 / 6.0)) * 6;

				switch ((int) (6.0 * pct)) {
					case 0:
						r = 255;
						gr = (int) (255 * prog);
						break;
					case 1:
						gr = 255;
						r = (int) (255 * (1 - prog));
						break;
					case 2:
						gr = 255;
						b = (int) (255 * prog);
						break;
					case 3:
						b = 255;
						gr = (int) (255 * (1 - prog));
						break;
					case 4:
						b = 255;
						r = (int) (255 * prog);
						break;
					case 5:
						r = 255;
						b = (int) (255 * (1 - prog));
					default:
					case 6:
						//color is black
						break;
						

				}

				Color thisColor = new Color(r, gr, b);
				g.setColor(thisColor);

				g.fillRect(i, j, 1, 1);

			}
		}
	}
}
