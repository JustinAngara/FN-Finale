package com.fort.main;

import com.fort.main.Kernel32;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class MemoryProcessing {

    final static long baseAddress = 0x10002AFA8L;
    final static int[] offsets = new int[]{0x50,0x14};

    static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32",Kernel32.class);
    static User32 user32 = (User32) Native.loadLibrary("user32", User32.class);

    public static int PROCESS_VM_READ= 0x0010;
    public static int PROCESS_VM_WRITE = 0x0020;
    public static int PROCESS_VM_OPERATION = 0x0008;

    public static void main(String... args)
    {
        int pid = getProcessId("12632");
        Pointer process = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, pid);

        long dynAddress = findDynAddress(process,offsets,baseAddress);

        Memory scoreMem = readMemory(process,dynAddress,4);
        int score = scoreMem.getInt(0);
        System.out.println(score);


        
        /*
         const uintptr_t PawnPrivate = 0x308;
		 const uintptr_t BoneArray = 0x600;
		 const uintptr_t BoneArrayCache = 0x648;
		 const uintptr_t Mesh = 0x318;
		 const uintptr_t ComponentToWorld = 0x240;
         * */
        byte[] newScore = new byte[]{(byte) 0x600};
        writeMemory(process, dynAddress, newScore);
    }

    public static int getProcessId(String window) {
         IntByReference pid = new IntByReference(0);
         user32.GetWindowThreadProcessId(user32.FindWindowA(null, window), pid);

         return pid.getValue();
    }

    public static Pointer openProcess(int permissions, int pid) {
         Pointer process = kernel32.OpenProcess(permissions, true, pid);
         return process;
    }

    public static long findDynAddress(Pointer process, int[] offsets, long baseAddress)
    {

        long pointer = baseAddress;

        int size = 4;
        Memory pTemp = new Memory(size);
        long pointerAddress = 0;

        for(int i = 0; i < offsets.length; i++)
        {
            if(i == 0)
            {
                 kernel32.ReadProcessMemory(process, pointer, pTemp, size, null);
            }

            pointerAddress = ((pTemp.getInt(0)+offsets[i]));

            if(i != offsets.length-1)
                 kernel32.ReadProcessMemory(process, pointerAddress, pTemp, size, null);


        }

        return pointerAddress;
    }

    public static Memory readMemory(Pointer process, long address, int bytesToRead) {
        IntByReference read = new IntByReference(0);
        Memory output = new Memory(bytesToRead);

        kernel32.ReadProcessMemory(process, address, output, bytesToRead, read);
        return output;
    }

    public static void writeMemory(Pointer process, long address, byte[] data)
    {
        int size = data.length;
        Memory toWrite = new Memory(size);

        for(int i = 0; i < size; i++)
        {
                toWrite.setByte(i, data[i]);
        }

        boolean b = kernel32.WriteProcessMemory(process, address, toWrite, size, null);
    }
}