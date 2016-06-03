/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesample;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import java.util.Random;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
/**
 *
 * @author xima
 */
public class Container {
    private Point[] points_stars;
    public Container(){
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
        
        create_stars();
    }

    private void create_stars(){
        this.points_stars = new Point[20000];
        Random random = new Random();

        for(int i=0; i < this.points_stars.length; i++){
            //x = random entre  -50 e 50
            //y = random entre -50 e 50
            //z = random entre 0 e -200
            this.points_stars[i] = new Point((random.nextFloat() - 0.5f)*100, (random.nextFloat()-0.5f)*100, random.nextInt(200) - 200);
        }
    }
    
    public void display(){
        while(!Display.isCloseRequested()){
            
            draw_stars();
            
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
}
