import java.util.*;
public class Planet
{
    /** the current location of the planet in the windos (upper left is (0,0), lower right is (length, height) */
    private OrderedPair loc;
    /** velocity is the change in the x and y location for each step */
    private OrderedPair vel;
    /** acceleration is the change in the x and y velocity for each step */
    private OrderedPair acc;

    /** Mass can simulate what the motion might look like for two bodies with different masses */
    private double mass = 1.0;

    /** radius is just for drawing to the screen */
    public double radius = 5.0;

    /** construct using input from user */
    public Planet()
    {
        System.out.println("Enter: Mass xLoc yLoc xVel yVel");
        Scanner s = new Scanner(System.in);
        mass = s.nextInt();
        if (mass > 1.0) radius = 10; //not proportional, but shows the 'heavier' bodies.
        int xLoc = s.nextInt();
        int yLoc = s.nextInt();
        loc = new OrderedPair(xLoc,yLoc);
        int xVel = s.nextInt();
        int yVel = s.nextInt();
        vel = new OrderedPair(xVel,yVel);
        acc = new OrderedPair(0,0);
    }
    /** construct using just location */
    public Planet(OrderedPair location)
    {
        loc = location;
        vel = new OrderedPair(0,0);
        acc = new OrderedPair(0,0);
    }

    /** construct using location, velocity */
    public Planet(OrderedPair location, OrderedPair velocity)
    {
        loc = location;
        vel = velocity;
        acc = new OrderedPair(0,0);
    }
    /** construct with actual location values and initial velocity values */
    public Planet(int mass, int xLoc, int yLoc, int xVel, int yVel)
    {
        this.mass = mass;
        if (mass > 1.0) radius = 10; //not proportional, but shows the 'heavier' bodies.
        loc = new OrderedPair(xLoc,yLoc);
        vel = new OrderedPair(xVel, yVel);
        acc = new OrderedPair(0,0);
    }

    /** get the x location */
    double getXLoc() {return loc.getX();}
    /** get the y location */
    double getYLoc() {return loc.getY();}
    /** get the x velocity */
    double getXVel() {return vel.getX();}
    /** get the y velocity */
    double getYVel() {return vel.getY();}
    /** get the x accleration */
    double getXAcc() {return acc.getX();}
    /** get the y acceleration */
    double getYAcc() {return acc.getY();}

    public OrderedPair getLoc() { return loc;}
    public OrderedPair getVel() { return vel;}
    public OrderedPair getAcc() { return acc;}

    public void setLoc(OrderedPair l) {this.loc  = l;}
    public void setVel(OrderedPair v) {this.vel  = v;}
    public void setAcc(OrderedPair a) {this.acc  = a;}

    /** set the x location */
    public void setXLoc(double x) { loc.setX(x);}
    /** set the y location */
    public void setYLoc(double y) { loc.setY(y);}
    /** set the x velocity */
    public void setXVel(double x) { vel.setX(x);}
    /** set the y velocity */
    public void setYVel(double y) { vel.setY(y);}
    /** set the x accleration */
    public void setXAcc(double x) { acc.setX(x);}
    /** set the y acceleration */
    public void setYAcc(double y) { acc.setY(y);}
    /** get the mass */
    public double getMass() { return mass;}
    /** set the mass */
    public void setMass(double m) { mass = m;
        radius = radius*mass;
    }
    /** set the location using a Location object as the parameter */
    public void setLocation(OrderedPair location)
    {
        loc = location;
    }
    /** use distance formula to find the distance */
    public double distance(Planet other)  {
        return Math.sqrt(Math.pow(this.getXLoc()-other.getXLoc(),2) + Math.pow(this.getYLoc()-other.getYLoc(),2));
    }
}

