package com.fort.main;



import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class JNativeHookMouse implements NativeMouseListener{
	private static Timer t;
	private static boolean aimOn;
	private static KeyOutputs ko;
	private static KeyHandler kh;
	
	
	private static int left = 1235;
	private static int right = 1325;
	private static int top = 680;
	private static int bottom = 750;
	
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("clicked");
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// start
		if(arg0.getButton()==1) {
			t.start();
		}
//		if(arg0.getButton()==2) {
//			// aim assist on 
//			System.out.println("Aim on");
//			aimOn=true;
//		}
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		//stop
		if(arg0.getButton()==1) {
			t.stop();
		}
//		if(arg0.getButton()==2) {
//			System.out.println("Aim off");
//			aimOn=false;
//		}
		
	} 
	public static void run() throws AWTException {
		ko = new KeyOutputs();
		kh = new KeyHandler();
		t = new Timer(170,(ActionEvent e)->{
			HandleMouseOutput.mouseMove(0,7);
		});

		GlobalScreen.addNativeMouseListener(new JNativeHookMouse());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		//logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			
	

			System.exit(1);
		}

	}
	
	
}
