package Snake;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//controls the size of the applet and the background

public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;


    public void init(){
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
    }


    public void paint(Graphics g){
        //off screen graphics
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 400, 400);
        this.addKeyListener(this);
        snake.draw(gfx);
        //image
        g.drawImage(img, 0,0, null);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void repaint(Graphics g){
        paint(g);
    }

    public void run() {
        for(;;){

            snake.move();

            this.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(!snake.isMoving()){
            if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT){
                snake.setIsMoving(true);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            //if going down already can't go up/reverse the action
            //if the snake is not going down we're allowing it to go up
            if(snake.getYDir() != 1){
                snake.setYDir(-1);
                snake.setXDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(snake.getYDir() != -1){
                snake.setYDir(1);
                snake.setXDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(snake.getXDir() != 1){
                snake.setXDir(-1);
                snake.setYDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(snake.getXDir() != -1){
                snake.setXDir(1);
                snake.setYDir(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
