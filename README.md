# fn-finale (LAST UPDATED BACK IN 2022/2023)
# Fortnite Automation Toolkit (Java + OpenCV + JNA)

This project is a **Fortnite automation toolkit** built in **Java**, utilizing **OpenCV**, **JNativeHook**, and **JNA** for **low-level Windows API interaction, memory manipulation, pixel detection, and input automation**.

Originally created to explore **game automation, memory reading/writing, and computer vision control** in Java, it includes:

- Aimbot pixel scanning and micro-adjustment
- Auto building and editing macros
- Memory reading/writing using Windows APIs via JNA
- Auto-drum keypress triggers based on pixel detection
- Transparent crosshair overlay
- Mouse event manipulation and control

---

## Features

✅ **Aimbot**: Pixel scanning to detect targets and adjust aim automatically.  
✅ **Auto Build & Edit Macros**: Quick crank edits, fast building with adjustable delays.  
✅ **Memory Processing**: Read and write to Fortnite’s memory using `Kernel32` and `User32` via JNA.  
✅ **Crosshair Overlay**: Transparent on-screen crosshair using Java Swing.  
✅ **Auto Drum**: Detects color changes on specified pixel regions to simulate rhythm game inputs.  
✅ **Mouse & Keyboard Hooks**: Global input hooks using `JNativeHook` to trigger macros.  
✅ **Pixel Color Detection**: Uses `Robot` to read pixels for event-driven triggers.

---

## Tech Stack

- **Java (AWT, Swing)**
- **OpenCV (planned/optional integration)**
- **JNA (Java Native Access)**
- **JNativeHook** (global mouse and keyboard hooks)

---

## File Overview

- `MainFN.java` – Main menu and launcher for enabling features.
- `Aimbot.java` – Target pixel scanning and auto-aim.
- `AutoDrum.java` – Auto keypress for rhythm games based on color detection.
- `Crosshair.java` – Transparent overlay crosshair.
- `KeyHandler.java` & `KeyOutputs.java` – Global keyboard hook and action triggers.
- `JNativeHookMouse.java` – Mouse hooks for aimbot toggling.
- `HandleMouseOutput.java` – Low-level mouse manipulation using `SendInput`.
- `Kernel32.java` & `MemoryProcessing.java` – Memory manipulation using Windows API calls.

---

## Usage

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/fortnite-automation-toolkit
    cd fortnite-automation-toolkit
    ```

2. **Ensure you have OpenCV Java bindings and JNA libraries set up** in your IDE.

3. **Build and run the main launcher**:
    ```bash
    javac MainFN.java
    java MainFN
    ```

4. **Enable desired modules**:
   - Start aimbot for pixel-based aiming
   - Run auto drum module for rhythm games
   - Enable crosshair overlay for improved aim
   - Use macro keys for fast edits or builds in Fortnite

> ⚠️ **Note:** This toolkit interacts with system-level APIs and may be against the Terms of Service of games like Fortnite. Use responsibly, and only in controlled environments for educational exploration.

---

## Why I Built This

> “I wanted to deeply understand low-level programming with Java while exploring practical memory manipulation, automation techniques, and computer vision control within a gaming environment. This toolkit pushed me to learn system programming, API hooking, and structured game automation while strengthening my Java fundamentals.”  
> – Justin Angara

---

## Future Improvements

- Integrate OpenCV for advanced computer vision-based targeting.
- Add GUI toggles for enabling/disabling modules without restarting.
- Optimize pixel detection performance and configurability.
- Cross-platform support where feasible.

---

---

## Disclaimer

This project is for **educational purposes only**. The use of such tools in online games is against most Terms of Service agreements and can lead to account bans or legal consequences. The author takes no responsibility for misuse of this code.


---


## Contributing

Pull requests are welcome for:
- Code cleanups
- Feature modules (e.g., overlay GUI enhancements)
- Performance optimizations
- Cross-platform experimentation



