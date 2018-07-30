/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author rohan
 */
public class Mover implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	GamePanel.LB_X += (((double) x)/GamePanel.X_SIZE - .5) * GamePanel.LENGTH * .25;
	GamePanel.UB_X += (((double) x)/GamePanel.X_SIZE - .5) * GamePanel.LENGTH * .25;
	GamePanel.LB_Y += (((double) y)/GamePanel.Y_SIZE - .5) * GamePanel.LENGTH * .25;
	GamePanel.UB_Y += (((double) y)/GamePanel.Y_SIZE - .5) * GamePanel.LENGTH * .25;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//nil
	}

	@Override
	public void mouseReleased(MouseEvent e) {
 //nil
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	//nil
	}

	@Override
	public void mouseExited(MouseEvent e) {
	//nil
	}
	
}
