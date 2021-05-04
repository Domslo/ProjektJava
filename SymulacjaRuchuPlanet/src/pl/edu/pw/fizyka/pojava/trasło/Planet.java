package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Planet {
	BufferedImage image;
	private int radius = 0;
	private int period = 0;
	private int xPos = 0;
	private int yPos = 0;
	
    public int getX() {
		return xPos;
	}
	public void setX(int xPos) {
		this.xPos = xPos;
	}
	public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }
    public void setPeriod(int period){
        this.period = period;
    }

    public int getPeriod(){
        return period;
    }
	public void addImage(BufferedImage i){
			image = i;
	}
	public void paint(Graphics g){
		g.drawImage(image, xPos, yPos,2*radius, 2*radius, null);
    }
}
