package gameplayer.classes;

import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle {
    protected int x;
    protected int y;
    protected int r;
    protected Color color;

    public FilledCircle(){}   //empty default constructor

    public FilledCircle(int x, int y, int r, Color color) {   //initializing constructor
        this();   // invoke the default constructor
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getR() {return r;}
    public Color getColor() {return color;}

    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setR(int r) { this.r = r;}
    void setColor(Color color) { this.color = color;}

    public String toString() {
        String returnMe = "I am a FilledCircle: ";
        returnMe += "\tx=" + getX();
        returnMe += "\ty=" + getY();
        returnMe += "\tr=" + getR();
        returnMe += "\tcolor=" + getColor();
        return returnMe;
    } // toString()
    
    void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(x-r, y-r, r*2, r*2);
    }
}

