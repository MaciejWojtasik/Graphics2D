package main;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;

public class Main {
    
    private static final int WINDOW_WIDTH = 320;
    private static final int WINDOW_HEIGHT = 240;
    private static final int FPS = 60;
    
    public static void main(String[] args){
        /*Window w = new Window("Pierwszy test", 640, 480);
        w.setVisibility(true);*/   
        
        final GLProfile profile = GLProfile.get(GLProfile.GL4);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDoubleBuffered(true);
        capabilities.setHardwareAccelerated(true);
        
        GLCanvas canvas = new GLCanvas(capabilities);
        FPSAnimator animator = new FPSAnimator(canvas, FPS);
        Renderer renderer = new Renderer();
        
        Window window = new Window("Drugi test", animator, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        canvas.addGLEventListener(renderer);
        
        window.setGLCanvas(canvas, BorderLayout.CENTER);
        animator.start();
        window.setVisibility(true);
        System.out.print("SIEMA");
        
    }  
}
