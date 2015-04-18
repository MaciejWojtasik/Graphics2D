package handler;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL4;
import java.nio.FloatBuffer;

public class BufferHandler {
    public static void setupBuffers(int[] objectVaoHandle, 
                                    float[] positionData, 
                                    float[] colorData, 
                                    final int vertexPositionIndex, 
                                    final int colorPositionIndex, 
                                    GL4 gl){
        int[] vboHandles = new int[2];
        gl.glGenBuffers(2, vboHandles, 0x0); //tworzymy 2 bufery
        
        int positionBufferHandle = vboHandles[0];
        int colorBufferHandle = vboHandles[1];
        
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, positionBufferHandle);
        FloatBuffer positionBufferData = Buffers.newDirectFloatBuffer(positionData);
        int numBytes = positionData.length * 4;
        gl.glBufferData(GL4.GL_ARRAY_BUFFER, numBytes, positionBufferData, GL4.GL_STATIC_DRAW);
        
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, colorBufferHandle);
        FloatBuffer colorBufferData = Buffers.newDirectFloatBuffer(colorData);
        numBytes = colorData.length * 4;
        
        gl.glBufferData(GL4.GL_ARRAY_BUFFER, numBytes, colorBufferData, GL4.GL_STATIC_DRAW);
        
        gl.glGenVertexArrays(1, objectVaoHandle, 0);
        gl.glBindVertexArray(objectVaoHandle[0]);
        
        gl.glEnableVertexAttribArray(vertexPositionIndex);
        gl.glEnableVertexAttribArray(colorPositionIndex);
        
        //map index 0 into positionbuffer
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, positionBufferHandle);
        gl.glVertexAttribPointer(vertexPositionIndex, 3, GL4.GL_FLOAT, Boolean.FALSE, 0, 0);
        
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, colorBufferHandle);
        
        gl.glVertexAttribPointer(colorPositionIndex, 3, GL4.GL_FLOAT, Boolean.FALSE, 0, 0);
        
    }
}
