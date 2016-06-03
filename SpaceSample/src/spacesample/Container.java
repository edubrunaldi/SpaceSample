/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesample;
import codeanticode.glgraphics.GLModel;
import codeanticode.glgraphics.GLGraphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import java.util.Random;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
/**
 *
 * @author xima
 */
public class Container {
    private Point[] points_stars;
    private float speed_z, speed_x, rotate_x, rotate_y;
    int objectDisplayList;
    public Container() throws IOException{
        try{
            Display.setDisplayMode(new DisplayMode(800, 800));
            Display.setTitle("SpaceSample");
            Display.create();
        }catch(LWJGLException e){
            e.printStackTrace();
        }
        
         //inicializa codigo openGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        //
        gluPerspective((float)30, 640f/480f, 0.001f, 100f);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();       
        
        
        create_stars();
        speed_x = 0.0f;
        speed_z = 0.0f;
    }

    private void create_stars(){
        this.points_stars = new Point[200000];
        Random random = new Random();

        for(int i=0; i < this.points_stars.length; i++){
            //x = random entre  -50 e 50
            //y = random entre -50 e 50
            //z = random entre 0 e -200
            this.points_stars[i] = new Point((random.nextFloat() - 0.5f)*400, (random.nextFloat()-0.5f)*400, random.nextInt(800) - 400);
        }
    }
    
    public void display(){
        while(!Display.isCloseRequested()){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            draw_stars();
            moveCamera();
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }
    private void draw_stars(){
        glBegin(GL_POINTS);
                for(Point p: this.points_stars){
                    glVertex3f(p.x, p.y, p.z);
                }
        glEnd();
    }
    
    private void moveCamera(){
        //GLU.gluLookAt(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        //glColor3f(0.0f, 1.0f, 0.0f);
        this.rotate_x=0.0f;
        this.rotate_y=0.0f;
        this.speed_x=0.0f;
        this.speed_z=0.0f;
        getKey();
        glTranslatef(speed_x, 0.0f, speed_z);
        glRotatef(rotate_x, 1, 0, 0);
        glRotatef(this.rotate_y, 0, 1, 0);
    }
    
    private void getKey(){
        if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
            this.speed_z = 0.5f;
        } else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
            this.speed_z = -0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
            this.speed_x = 0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
            this.speed_x = -0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_C)){
            glLoadIdentity();
            this.speed_x = 0.0f;
            this.speed_z = 0.0f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            this.speed_x = 0.0f;
            this.speed_z = 0.0f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            this.rotate_x = 0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            this.rotate_x = -0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
            this.rotate_y = -0.5f;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_E)){
            this.rotate_y = 0.5f;
        }
    }
}
