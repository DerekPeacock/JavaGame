import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;

    public GamePanel()
    {
       this.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT)); 
    }

    public void paint(Graphics g)
    {
        Graphics2D g2D = (Graphics2D)g;

        g2D.fillRect(100, 200, 100, 100);
    }    
}