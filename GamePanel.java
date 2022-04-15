import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel
{
    private int width, height;

    private Image image;

    public GamePanel(int width, int height)
    {
       this.width = width; this.height = height;

       this.setPreferredSize(new Dimension(width, height)) ; 

       image = new ImageIcon("image.png").getImage();
    }

    public void updateScreen()
    {
        repaint();
    }

    public void paintComponent (Graphics g)
    {
        Graphics2D g2D = (Graphics2D)g;

        g2D.drawImage(image, 0, 0, null);
        g2D.setPaint(Color.blue);

        g2D.drawLine(0,0, 600, 500);
        g2D.drawRect(300, 100, 100, 100);
        g2D.fillRect(100, 100, 100, 100);

        g2D.drawString("Derek", 50, 50);
    }    
}