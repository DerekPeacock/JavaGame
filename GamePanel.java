import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{
    private Thread thread;
    private boolean running = false;

    private int width, height;

    private Image backgroundImage;
    private Image playerSprite;

    public GamePanel(int width, int height)
    {
        this.width = width; this.height = height;
        this.setPreferredSize(new Dimension(width, height)) ; 
        
        System.out.println("Game Panel is Created!");
        loadImages();
        start();
    }

    public void loadImages()
    {
        backgroundImage = new ImageIcon("images/green_background_600.png").getImage();
        playerSprite = new ImageIcon("images/0_Golem_Running_002.png").getImage(); 
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try 
        {
            thread.join();
            running = false;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        System.out.println("Thread has been stopped!");
    }

    /**
     * This method is repeatedly called by the thread, once the
     * thread has started and before it is stopped.  This is
     * the main game loop.
     */
    @Override
    public void run() 
    {
        while (running)
        {
            update();
            repaint();
            delay(330);
        }

        stop();
    }

    private void delay(int milliseconds)
    {
        try 
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * This method implements the main actions in the
     * game, by repositioning the sprites and checking
     * for collisions
     */
    private void update() 
    {
        System.out.println("Game is Updating!");
    }

    /**
     * This method draws all the sprites and any other
     * images onto the panel.
     */
    public void paintComponent (Graphics g)
    {
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(playerSprite, 200, 200, Color.green, null);

        g2D.setPaint(Color.blue);

        g2D.drawLine(0,0, 600, 500);
        g2D.drawRect(300, 100, 100, 100);
        g2D.fillRect(100, 100, 100, 100);

        g2D.drawString("Derek", 50, 50);

        System.out.println("Painting the screen!");
        g2D.dispose();
    }    
}