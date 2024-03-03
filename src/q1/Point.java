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
public class Point implements Shape{
    private int x;
    private int y;
    private String color ;
    private String info;

    public Point(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = "black";
        
    }

   

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
    public void draw(){
        
        info = "Point (" +this.x+","+this.y+")\n";
    }
   @Override
    public void inputData(){
        
        info = "Add point(" + this.x + "," + this.y+ ")\n";
}
}