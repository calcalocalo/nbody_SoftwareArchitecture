package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;

/******************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 ******************************************************************************/

public class Body {
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass
    //public static final Color random1 =  new Color RColor();

    public Body(Vector r, Vector v, double mass) {
        this.r = r;
        this.v = v;
        this.mass = mass;
    } // Body( Vector, Vector, double )

    public void move(Vector f, double dt) {
        Vector a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )

    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )
    
    public Color RColor (){
        
int R = (int) (Math.random()*255);
int G = (int) (Math.random()*255);
int B = (int) (Math.random()*255);
Color randomColor = new Color(R,G,B); 
        return randomColor;
    }

    
    public void drawTrace(){
        StdDraw.setPenRadius(.025);//Math.random()/5);
        StdDraw.point(r.cartesian(1), r.cartesian(2));
        StdDraw.setPenColor(Color.WHITE);
    }
    
    public void draw() {
       /* int ar = RColor();//RColor();
        int g= RColor();//RColor();
        int b = RColor();//RColor();*/
       Color random = RColor(); 
       StdDraw.setPenRadius(.025);//Math.random()/5);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        StdDraw.setPenColor(Color.WHITE);
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )

    
} // Body
