/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author rohan
 */
public class Controller implements MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double zoomFactor = Math.pow(.9, -e.getPreciseWheelRotation());
		double xCoord, yCoord;
		double pctX = e.getX() / (double) GamePanel.X_SIZE;
		double pctY = e.getY() / (double) GamePanel.Y_SIZE;

		xCoord = GamePanel.UB_X * pctX + GamePanel.LB_X * (1 - pctX);
		yCoord = GamePanel.UB_Y * pctY + GamePanel.LB_Y * (1 - pctY);

		GamePanel.LENGTH*=zoomFactor;
		
		GamePanel.LB_X = xCoord - GamePanel.LENGTH * .5;
		GamePanel.UB_X = xCoord + GamePanel.LENGTH * .5;
		GamePanel.LB_Y = yCoord - GamePanel.LENGTH * .5;
		GamePanel.UB_Y = yCoord + GamePanel.LENGTH * .5;
	
	}
}
