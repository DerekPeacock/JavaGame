import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This Panel hosts the game, and uses a Thread to ensure
 * that the run() method is called FPS frames per second
 * to ensure smooth animation.
 * @author: Derek Peacock
 * @version: 0
 */
public class GamePanel extends JPanel implements Runnable
{
    private Thread thread;
    private boolean running = false;
    
    public static final int FPS = 30; // Frames/Second
    private long frameTime = 1000 / FPS;

    private int width, height;

    private Image backgroundImage;
    private Image playerImage;

    private KeyHandler keyHandler = new KeyHandler();

    // Player's Position and size

    private Sprite player;

    /**
     * Setup the panel with a fixed size of width and
     * height.  Add the KeyHanlder and load any images
     * @param width: The width in pixels of the panel
     * @param height: The height in pixels of the panel
     */
    public GamePanel(int width, int height)
    {
        this.width = width; this.height = height;
        this.setPreferredSize(new Dimension(width, height)) ; 
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        System.out.println("Game Panel is Created!");
        loadImages();
        start();
    }

    /**
     * Load any images used in drawing the screen.
     */
    public void loadImages()
    {
        backgroundImage = new ImageIcon("images/green_background_600.png").getImage();
        playerImage = new ImageIcon("images/0_Golem_Running_002.png").getImage(); 

        player = new Sprite(new Rectangle(0, 0, width, height));
    }

    /**
     * Create a Thread and start it, which wiil lead to
     * the run() methods being called repeatedly.
     */
    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Stop the Thread from calling the run method
     * repeatedly.
     */
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

        long currentTime = System.currentTimeMillis();
        long nextDrawTime = currentTime + frameTime;

        while (running)
        {
            update();
            repaint();

            long remainingTime = nextDrawTime - System.currentTimeMillis();
            
            if(remainingTime > 0)
                delay(remainingTime);

            //System.out.println("Elapsed Time = " + 
            //    (System.currentTimeMillis() - currentTime));
            //currentTime = System.currentTimeMillis();
            
            nextDrawTime += frameTime;
        }

        stop();
    }

    private void delay(long milliseconds)
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
        player.update(keyHandler);
        // System.out.println("Game is Updating!");
    }

    /**
     * This method draws all the sprites and any other
     * images onto the panel.
     */
    public void paintComponent (Graphics g)
    {
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(backgroundImage, 0, 0, width, height, null);
        g2D.drawImage(playerImage, 200, 200, Color.green, null);
        g2D.drawString("Derek", 220, 280);

        player.draw(g2D);

        //System.out.println("Painting the screen!");

        g2D.dispose();
    }    
}