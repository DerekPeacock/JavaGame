import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame
{
    private GamePanel panel;

    public GameFrame(int width, int height, String title)
    {
        panel = new GamePanel(width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(title);

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel getPanel()
    {
        return panel;
    }
}