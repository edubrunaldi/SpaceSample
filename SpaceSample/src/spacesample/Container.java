/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesample;

import org.lwjgl.opengl.*;
import org.lwjgl.*;
/**
 *
 * @author xima
 */
public class Container {
    public Container(){
        try{
            Display.setDisplayMode(new DisplayMode(800, 800));
            Display.setTitle("SpaceSample");
            Display.create();
        }catch(LWJGLException e){
            e.printStackTrace();
        }
    }
    
    public void display(){
        while(!Display.isCloseRequested()){
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }
}
