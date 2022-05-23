
package folder;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Car extends Pane{
    //Timeline animation1 ;
    private int x ;
    private int y;
   
    public Car(int x, int y){
        this.x =x;
        this.y=y;
        paintCar(x,y);
    }
    public void paintCar(int x, int y){
        
        Circle c1 = new Circle(x+15,y-5,5);
        c1.setFill(Color.BLACK);
        c1.setStroke(Color.BLACK);
        
        Circle c2 = new Circle(x+35,y-5,5);
        c2.setFill(Color.BLACK);
        c2.setStroke(Color.BLACK);
        
        Rectangle r = new Rectangle(x,y-20,50,10);
        r.setFill(Color.BLACK);
        r.setStroke(Color.BLACK);
        
        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(new Double[]{
            x+10.0,y-20.0,
                x+20.0,y-20.0,
                x+20.0,y-30.0
        });
        Polygon poly = new Polygon();
        poly.getPoints().addAll(new Double[]{
          x+10.0, y-20.0,
            
            x + 20.0, y - 30.0,
           x + 30.0, y - 30.0, 
           x + 40.0, y - 20.0
        });
        poly.setFill(Color.BLACK);
        poly.setStroke(Color.BLACK);
        getChildren().clear();
        getChildren().addAll(c1,c2,r,poly);
       
        
    }
   
    public int getX(){
        return x;
        
    }
    public int getY(){
        return y;
        
    }
    public void StartRunning( Timeline animation,int x){
        
        
        animation.setRate(x);
        
    }
    
}

