package Snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    /**
     * snake gonna be represented by list of points to be modified
     * snake runs over a token
     */

    List<Point> snakePoints; //front of the snake always gonna be element 0 of this list
    int xDir, yDir;
    boolean isMoving, elongate;
    final int STARTSIZE = 20, STARTX = 150, STARTY = 150;

    public Snake(){
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0; //xdir, ydir = 0 means snake is not moving
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(STARTX, STARTY));
        for(int i = 1; i < STARTSIZE; i++){
            snakePoints.add(new Point(STARTX - i * 4, STARTY)); //push the snake body to the left
        }
    }

    //create a snake object in snake game
    public void draw(Graphics g){
        g.setColor(Color.white);
        //draw each points in the snake, snake is made up of several tiny rectangles
        for (Point p : snakePoints){
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }

    public void move(){
        if(isMoving){
            /**
             * Both temp and last defines where the snake currently is
             */
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size()-1); //
            Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
            for(int i = snakePoints.size() - 1; i >= 1; i--){
                snakePoints.set(i, snakePoints.get(i - 1));
            }
            snakePoints.set(0, newStart);
        }
    }

    public boolean isMoving(){
        return isMoving;
    }

    public void setIsMoving(boolean b){
        isMoving = b;
    }

    public int getXDir(){
        return xDir;
    }

    public int getYDir(){
        return yDir;
    }

    public void setXDir(int xDir){
        this.xDir = xDir;
    }

    public void setYDir(int yDir){
        this.yDir = yDir;
    }

    //x position of the head of the snake
    public int getX(){
        return snakePoints.get(0).getX();
    }

    public int getY(){
        return snakePoints.get(0).getY();
    }
}
