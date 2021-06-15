package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Planet {
	BufferedImage image;
	private int radiusPl = 0;
	private int radiusOrb = 0;
	private double period = 0;
	private int xPos = 0;
	private int yPos = 0;
	private double angle = 0;
	private int in = 0;
	
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
    public void setRadiusPl(int radius){
        this.radiusPl = radius;
    }

    public int getRadiusPl(){
        return radiusPl;
    }
    public void setRadiusOrb(int radius){
        this.radiusOrb = radius;
    }

    public int getRadiusOrb(){
        return radiusOrb;
    }
    public void setPeriod(double period){
        this.period = period;
    }

    public double getPeriod(){
        return period;
    }
    public double getAngle() {
		return angle;
	}
	public void setAngle(double aa) {
		this.angle = aa;
	}
	public void addImage(BufferedImage i){
			image = i;
	}
	public double getSpeed() {
		return 2*Math.PI/period;
	}
	public void setIn(int ii) {
		this.in = ii;
	}
	public void paint(Graphics g){
		if(in==0) {
			g.drawImage(image, xPos, yPos,2*radiusPl, 2*radiusPl, null);
		}
		else if(in==1) {
			Graphics2D g2 = (Graphics2D)g;
			TexturePaint tp = new TexturePaint(image, new Rectangle(2*radiusPl,2*radiusPl));

		    g2.setPaint(tp);
		    g2.fill(new Ellipse2D.Float(xPos,yPos,2*radiusPl,2*radiusPl));
		}
    }
}
