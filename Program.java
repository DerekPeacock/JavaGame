/**
 * This is the main game class which controls the 
 * game loop and sets up the drawable window as a JFrame 
 * with a JPanel inside.
 * 
 * Author: Derek Peacock
 * Version: 0
 */
public class Program implements Runnable
{
    // Window Size
    public static final int WIDTH = 720;
    public static final int HEIGHT = WIDTH / 12 * 9;    
    
    private Thread thread;
    private boolean running = false;

    public Program()
    {
        new GameFrame(WIDTH, HEIGHT, "CO452 Example Java Game");
    }

    public static void main(String[] args)
    {
        new Program();
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
    }

    @Override
    public void run() 
    {
        
    }
}