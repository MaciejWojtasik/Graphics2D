package shapes;

public class Square extends Shape {

    private float[] positionData = {
        -0.8f,  0.8f, 0.0f,  //lewy górny
         0.8f,  0.8f, 0.0f,  //prawy górny
         0.8f, -0.8f, 0.0f,  //prawy dolny
        -0.8f, -0.8f, 0.0f   //lewy dolny
    }; // X, Y, Z 
    
    private float[] colorData = {
        1.0f, 0.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        0.0f, 0.0f, 1.0f,
        0.5f, 0.5f, 0.5f,
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
