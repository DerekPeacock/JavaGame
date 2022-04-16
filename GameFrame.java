import javax.swing.*;

public class GameFrame extends JFrame
{
    // Window Size
    public static final int WIDTH = 720;
    public static final int HEIGHT = WIDTH / 12 * 9;  
    
    private GamePanel panel;

    public GameFrame()
    {
        panel = new GamePanel(WIDTH, HEIGHT);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("CO452 Example Java Game");

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}