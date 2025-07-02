package com.fort.main;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.LONG;
import com.sun.jna.platform.win32.WinUser.INPUT;

import static com.sun.jna.platform.win32.WinUser.*;

public class HandleMouseOutput {
	
    public static final int MOUSEEVENTF_MOVE = 1;
    public static final int MOUSEEVENTF_LEFTDOWN = 2;
    public static final int MOUSEEVENTF_LEFTUP = 4;

    private static WinUser.HHOOK hHook;
    static final User32 user32Library = User32.INSTANCE;
    static WinDef.HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
	
	
	public static void mouseMove(int x, int y) {
		mouseAction(x, y, MOUSEEVENTF_MOVE);
	}
	 
	
    public static void mouseAction(int x, int y, int flags) {
        INPUT input = new INPUT();

        input.type = new DWORD(INPUT.INPUT_MOUSE);
        input.input.setType("mi");
        if (x != -1) {
            input.input.mi.dx = new LONG(x);
        }
        if (y != -1) {
            input.input.mi.dy = new LONG(y);
        }
        input.input.mi.time = new DWORD(0);
        input.input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        input.input.mi.dwFlags = new DWORD(flags);
        User32.INSTANCE.SendInput(new DWORD(1), new INPUT[]{input}, input.size());
    }
    
    
    public static void main(String[] args) {
    	mouseMove(100,100);
    }
}
