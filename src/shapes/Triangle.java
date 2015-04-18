
package shapes;

public class Triangle extends Shape {

    private float[] positionData = {
        -1.0f, -1.0f, 0.0f,
         1.0f, -1.0f, 0.0f,
         0.0f,  1.0f, 0.0f
    };          // X, Y, Z - lewy, prawy, górny
    
    private float[] colorData = { // from 0 to 1 -> R G B
        0.0f, 0.0f, 1.0f, 
        0.0f, 1.0f, 0.0f,
        1.0f, 0.0f, 0.0f        
    };
    
    @Override
    public float[] getPositionData() {
        return this.positionData;
        
    }

    @Override
    public float[] getColorData() {
        return this.colorData;
    }
    
    
}
