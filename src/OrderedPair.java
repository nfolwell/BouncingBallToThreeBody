public class OrderedPair
{
    /** can be the location or the x-component of the velocity or the acceleration */
    private double xVal;
    /** can be the location or the y-component of the velocity or the acceleration */
    private double yVal;

    /** Initializes xVal and yVal */
    public OrderedPair(double x, double y)
    {
        xVal = x;
        yVal = y;
    }
    /** Standard getters and setters  */
    public double getX() {return xVal;}
    /** Standard getters and setters */
    public double getY() {return yVal;}
    /** Standard getters and setters */
    void setX(double x) { xVal = x;}
    /** Standard getters and setters */
    void setY(double y) { yVal = y;}
}

