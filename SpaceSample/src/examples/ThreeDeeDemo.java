/*
PERSPECTIVA!!!
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

/**
 *
 * @author xima
 */
public class ThreeDeeDemo {
    
    public ThreeDeeDemo(){
        //Inicializa display
        try{
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("Three Dee Demo");
            Display.create();
        } catch(LWJGLException e){
            e.printStackTrace();
        }
        //inicializa codigo openGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        //
        gluPerspective((float)30, 640f/480f, 0.001f, 100f);
        glMatrixMode(GL_MODELVIEW);
        
        //inicializa cada ponto
        Point[] points = new Point[10000];
        Random random = new Random();
        
        for(int i=0; i < points.length; i++){
            //x = random entre  -50 e 50
            //y = random entre -50 e 50
            //z = random entre 0 e -200
            points[i] = new Point((random.nextFloat() - 0.5f)*100, (random.nextFloat()-0.5f)*100, random.nextInt(200) - 200);
        }
        
        //the speed in which the "camera" travels
        float speed = 0.0f;
        
        while(!Display.isCloseRequested()){
            //render
            
            //clear the screen of it filthy contents
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            //push the screen inwards  at  the amount of speed 
            glTranslatef(0, 0, speed);
            
            //Begin draw points
            glBegin(GL_POINTS);
            for(Point p: points){
                glVertex3f(p.x, p.y, p.z);
            }
            glEnd();
            
            if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
                speed += 0.01f;
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
                speed -= 0.01f;
            }
            
            while(Keyboard.next()){
                if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
                    speed = 0f;
                }
                
                if(Keyboard.isKeyDown(Keyboard.KEY_C)){//reseta
                    speed = 0f;
                    glLoadIdentity();
                }
            }
            
            Display.update();
            Display.sync(60);

        }
    }
    
    private static class Point {
        float x, y, z;
        
        public Point(float x, float y, float z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args){
        new ThreeDeeDemo();
    }
}
