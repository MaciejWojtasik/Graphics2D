package main;

import shapes.*;
import handler.*;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Renderer implements GLEventListener {
    
    private int[] triangleVaoHandle = new int[1];
    private int[] squareVaoHandle = new int[1];
    
    

    public Renderer(){
        
    }
    
    @Override
    public void init(GLAutoDrawable drawable) {     // init renderer with shaders
        final GL4 gl = drawable.getGL().getGL4();
        
        int vertexShader = ShaderHandler.createShader("shaders/vertex_shader.glsl", GL4.GL_VERTEX_SHADER, gl);
        int fragmentShader = ShaderHandler.createShader("shaders/fragment_shader.glsl", GL4.GL_FRAGMENT_SHADER, gl);
        
        //@SuppressWarnings("MismatchedReadAndWriteOfArray")
        int shaderList[] = {vertexShader, fragmentShader};
        
        int programHandle = ShaderHandler.createProgram(shaderList, gl);
        
        //location in vertex_shader.glsl
        final int VERTEX_POSITION_INDEX = 0;
        final int VERTEX_COLOR_INDEX = 1;
        
        Triangle triangle = new Triangle();
        BufferHandler.setupBuffers(triangleVaoHandle, triangle.getPositionData(), triangle.getColorData(), VERTEX_POSITION_INDEX, VERTEX_COLOR_INDEX, gl);
        
        //Square square = new Square();
        //BufferHandler.setupBuffers(squareVaoHandle, square.getPositionData(), square.getColorData(), VERTEX_POSITION_INDEX, VERTEX_COLOR_INDEX, gl);
        
        
        ShaderHandler.linkProgram(programHandle, gl);
        gl.glUseProgram(programHandle);
        
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        final GL4 gl = drawable.getGL().getGL4();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL4 gl = drawable.getGL().getGL4();
        
        //clear current buffer and show the new one
        gl.glClear(GL4.GL_COLOR_BUFFER_BIT);
        gl.glBindVertexArray(triangleVaoHandle[0]);
        gl.glDrawArrays(GL4.GL_TRIANGLES, 0, 3);
        gl.glFlush(); // push onto the screen 
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL4 gl = drawable.getGL().getGL4();
    }
    
}
