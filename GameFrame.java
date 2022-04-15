import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame
{
    private GamePanel panel;

    public GameFrame()
    {
        panel = new GamePanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}