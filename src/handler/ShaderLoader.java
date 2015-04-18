package handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ShaderLoader {
    
    public static String loadShaderFile(String filePath){
        
        File f = new File(filePath);
        BufferedReader reader;
        String temp;
        String separator  = System.getProperty("line.separator");
        StringBuilder shaderCode = new StringBuilder();
        
        if(!f.exists()){
            System.err.println("Couldn't not find shader file: " + filePath);
            System.exit(1);
        }
        
        try {
            reader = new BufferedReader(new FileReader(f));
            
            while ((temp = reader.readLine()) != null){
                shaderCode.append(temp);
                shaderCode.append(separator);              
            }
            
            reader.close();
            
            
        } catch(Exception e){
            System.err.println("Error reading: " + filePath + ", " + e.getMessage());
            System.exit(1);
        }
        
        
        return shaderCode.toString();
    }
}
