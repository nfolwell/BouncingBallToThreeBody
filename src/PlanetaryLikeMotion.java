/**
 * Calculates positions, velocities and accelerations of two bodies using
 * equations kinda like planetary motion formulas.
 * Runs the animation of the simulation
 */

import java.awt.*;
import javax.swing.*;

public class PlanetaryLikeMotion extends JPanel {
   /* Here's one set I know works with constant 1.0
   Planet p1 = new Planet(10,150, 20, -1, 0);
   Planet p2 = new Planet(10, 150, 150, 1, 0);
    //Planet p3 = new Planet(1, 155, 280, 0, 0);*/

    /* Here's another set I know works with constant 1.0 (it's faster with constant 40 or 50)
   Planet p1 = new Planet(1,150, 20, -1, 0);
   Planet p2 = new Planet(1, 150, 150, 0, 0);
    //Planet p3 = new Planet(1, 150, 280, 1, 0);*/

    Planet p1 = new Planet();
    Planet p2 = new Planet();
    Planet p3 = new Planet();

    // Box height and width
    int width;
    int height;

    public PlanetaryLikeMotion() {

        Thread thread = new Thread() {
            public void run() {
                while (true) {

                    width = getWidth();
                    height = getHeight();
                    //To move planet 1: change location by velocity
                    //(set location to p1 location + p1 velocity)
                    p1.setXLoc(p1.getXLoc() + p1.getXVel());
                    p1.setYLoc(p1.getYLoc() + p1.getYVel());

                    //To move planet 2: change location by velocity
                    //(set location to p2 location + p2 velocity)
                    p2.setXLoc(p2.getXLoc() + p2.getXVel());
                    p2.setYLoc(p2.getYLoc() + p2.getYVel());

                    //To move planet 2: change location by velocity
                    //(set location to p2 location + p2 velocity)
                    p3.setXLoc(p3.getXLoc() + p3.getXVel());
                    p3.setYLoc(p3.getYLoc() + p3.getYVel());

                    //There is a gravitational constant that we can tinker with
                    //to adjust the responsiveness of the simulation
                    double constant = 1.0;

                    //The acceleration (the change in the velocity) for planet 1
                    p1.setXAcc(p2.getMass() * constant * (p2.getXLoc() - p1.getXLoc()) / (p1.distance(p2) * p1.distance(p2))+
                            p3.getMass() * constant * (p3.getXLoc() - p1.getXLoc()) / (p1.distance(p3) * p1.distance(p3)));
                    p1.setYAcc(p2.getMass() * constant * (p2.getYLoc() - p1.getYLoc()) / (p1.distance(p2) * p1.distance(p2))+
                            p3.getMass() * constant * (p3.getYLoc() - p1.getYLoc()) / (p1.distance(p3) * p1.distance(p3)));

                    //The acceleration (the change in the velocity) for planet 2
                    p2.setXAcc(p3.getMass() * constant * (p3.getXLoc() - p2.getXLoc()) / (p3.distance(p2) * p3.distance(p2)) +
                            p1.getMass() * constant * (p1.getXLoc() - p2.getXLoc()) / (p2.distance(p1) * p2.distance(p1)));
                    p2.setYAcc(p3.getMass() * constant * (p3.getYLoc() - p2.getYLoc()) / (p3.distance(p2) * p3.distance(p2)) +
                            p1.getMass() * constant * (p1.getYLoc() - p2.getYLoc()) / (p1.distance(p2) * p1.distance(p2)));

                    //The acceleration (the change in the velocity) for planet 3
                    p3.setXAcc(p1.getMass() * constant * (p1.getXLoc() - p3.getXLoc()) / (p3.distance(p1) * p3.distance(p1)) +
                            p2.getMass() * constant * (p2.getXLoc() - p3.getXLoc()) / (p3.distance(p2) * p3.distance(p2)));
                    p3.setYAcc(p1.getMass() * constant * (p1.getYLoc() - p3.getYLoc()) / (p3.distance(p1) * p3.distance(p1)) +
                            p2.getMass() * constant * (p2.getYLoc() - p3.getYLoc()) / (p3.distance(p2) * p3.distance(p2)));


                    //Change the velocity by the acceleration for planet 1
                    p1.setXVel(p1.getXVel() + p1.getXAcc());
                    p1.setYVel(p1.getYVel() + p1.getYAcc());

                    //Change the velocity by the acceleration for planet 2
                    p2.setXVel(p2.getXVel() + p2.getXAcc());
                    p2.setYVel(p2.getYVel() + p2.getYAcc());

                    //Change the velocity by the accelertion for planet 3
                    //Change the velocity by the acceleration for planet 2
                    p3.setXVel(p3.getXVel() + p3.getXAcc());
                    p3.setYVel(p3.getYVel() + p3.getYAcc());
                    repaint();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                    }

                }
            }
        };
        thread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval((int) (p1.getXLoc() - p1.radius), (int) (p1.getYLoc() - p1.radius), (int) (2 * p1.radius), (int) (2 * p1.radius));
        g.setColor(Color.RED);
        g.fillOval((int) (p2.getXLoc() - p2.radius), (int) (p2.getYLoc() - p2.radius), (int) (2 * p2.radius), (int) (2 * p2.radius));
        g.setColor(Color.GREEN);
        g.fillOval((int) (p3.getXLoc() - p3.radius), (int) (p3.getYLoc() - p3.radius), (int) (2 * p3.radius), (int) (2 * p3.radius));

    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Planet Thing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setContentPane(new PlanetaryLikeMotion());
        frame.setVisible(true);
    }
}


