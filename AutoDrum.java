package com.fort.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
/*
	830 1195 
	1023 1189
	1213 1193 
	1405 1193
	1597 1193
  
 */

import javax.swing.Timer;


public class AutoDrum {
	static Timer t;
	
	public AutoDrum() {
		// constantly ran to find change
		t = new Timer(2,(ActionEvent e)->{
			try {
				if(grabColor(830,1195,80)) {
					// left
					clickD();
					System.out.println("d");
				} 
				
				if(grabColor(1023,1189,80)) {
					// down
					clickF();
					System.out.println("f");
				}
				
				if(grabColor(1213,1193, 80)) {
					// up
					clickJ();
					System.out.println("j");
				}
				
				if(grabColor(1405,1193,80)) {
					// right
					clickK();
					System.out.println("k");
				}
				if(grabColor(1597,1193,80)) {
					// right
					clickL();
					System.out.println("l");
				}
			
			}catch (Exception e1) {
				// TODO: handle exception
			}
		});
		
	}
	
	// method returns whether a color is facts
	public static boolean grabColor(int x, int y, int color) throws AWTException {
		
		Robot robot = new Robot();
		Color grabPixelLocation1 = robot.getPixelColor(x,y);
		if(!(grabPixelLocation1.getRed()+10 <= color && grabPixelLocation1.getRed()-10 >= color)) {
			return true;
		}
		return false;
	}
	
	public static void clickD() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_D);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_D);
	    
	}
	public static void clickF() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_F);
	}
	public static void clickJ() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_J);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_J);
	}
	public static void clickK() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_K);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_K);
	}
	
	public static void clickL() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_L);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_L);
	}
	
	public static void main(String[] args) {

		t.start();
	}
}
