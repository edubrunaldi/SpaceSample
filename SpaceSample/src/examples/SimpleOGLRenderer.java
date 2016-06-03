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
public class SimpleOGLRenderer {
    public SimpleOGLRenderer(){
        try{
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("hello lwjgl");
            Display.create();
        } catch(LWJGLException e){
            e.printStackTrace();
        }
        //inicializa codigo opengl
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,  640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        
        
        while( !Display.isCloseRequested()){
            //Render
            
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            
            glBegin(GL_LINES);
                glVertex2i(100, 100);
                glVertex2i(200, 200);
            glEnd();
            
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
    public static void main(String[]  args){
        new SimpleOGLRenderer();
    }
}
