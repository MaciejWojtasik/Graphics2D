package main;

import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
    private final JPanel mainPanel;
    
    public Window(String title, FPSAnimator animator, int width, int height){
        super(title);
        setupWindow(animator, width, height);
        mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
    
    private void setupWindow(final FPSAnimator animator, int width, int height){
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                if(animator.isStarted()){
                    System.out.println("Stopping FPSAnimator...");
                    animator.stop();
                    System.out.println("animator stopped successfully");
                    
                }
                System.exit(0);
                
            }
        });
    } 
    
    public void setVisibility(boolean isVisible){
        this.setVisible(isVisible);           
    }
    
    public void setGLCanvas(GLCanvas canvas, String position){
        mainPanel.add(canvas, position);
            
        
    }
        
    
}
