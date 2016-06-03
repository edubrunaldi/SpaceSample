/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
/**
 *
 * @author xima
 */
public class LWJGLHelloWorld {
    public LWJGLHelloWorld(){
        try{
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("hello lwjgl");
            Display.create();
        } catch(LWJGLException e){
            e.printStackTrace();
        }
        //inicializa codigo opengl
        
        while( !Display.isCloseRequested()){
            //Render
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
    public static void main(String[]  args){
        new LWJGLHelloWorld();
    }
}
