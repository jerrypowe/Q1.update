/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Tam Pham
 */
public class StraighLine implements Shape{
    private Point p1;
    private Point p2;
    private String color;
    private String info;

    /**
     *
     * @param p1
     * @param p2
     * @param color
     * @param x
     * @param y
     * @param color
     */
   

    

   

    public StraighLine(Point p1, Point p2, String color) {
       
        this.p1 = p1;
        this.p2 = p2;
        this.color = "black";
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getInfo() {
        return info;
    }
    @Override
    public void inputData(){
       
        info = "Add line ("+p1.getX()+","+p1.getY()+")"+"->"+"("+p2.getX()+","+p2.getY()+")\n";
    }
    @Override
    public void draw(){
        
        info = "Line from ("+p1.getX()+","+p1.getY()+")"+"to"+"("+p2.getX()+","+p2.getY()+")\n";
    }
   public float getLength(){
       float length;
       int POW = 2; 
    return   length = (float) Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2)+Math.pow(p2.getY()-p1.getY(), 2));
   }

  
    
}
