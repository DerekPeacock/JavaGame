import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Sprite
{
    private int x = 0;
    private int y = 0;
    private int width = 64;
    private int height = 64;

    private int speed = 4;
    
    private Color color = Color.BLUE;

    private Rectangle boundary;

    public Sprite(Rectangle boundary)
    {
        this.boundary = boundary;
    }   

    public void draw(Graphics2D g2)
    {
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }

    public void update(KeyHandler keyHandler)
    {
        if(keyHandler.upPressed && 
          (y > speed))
        {
            y -= speed;
        }
        if(keyHandler.downPressed && 
          (y < boundary.getHeight() - height - speed))
        {
            y += speed;
        }
        if(keyHandler.leftPressed && x > speed)
        {
            x -= speed;
        }
        if(keyHandler.rightPressed && 
          (x < boundary.getWidth() - width - speed))
        {
            x += speed;
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
}