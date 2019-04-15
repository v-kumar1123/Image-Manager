import java.awt.Color;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class TestingWindow extends JFrame
{
	ImageManager im = new ImageManager();
	int x = -1;
	public TestingWindow()
	{
		im.loadImages("C:\\Users\\OTHSCS097\\Desktop\\Image-Manager\\src\\ImageList.txt");

		setUndecorated(true);
		setSize(400,400);
		setVisible(true);
		while(true)
		{
			try
			{
				Thread.sleep(4000);
				repaint();
			}
			catch(Exception e)
			{}
		}
	}

	public void paint(Graphics g)
	{

		g.setColor(Color.GRAY);
		g.fillRect(0,0,400,400);
		g.setColor(Color.RED);
		g.drawString(""+x,300,300);
		if(x==0)
		{
			g.drawImage(im.getImage("box"),0,0,null);
		}
		else if(x==1)
		{
			g.drawImage(im.getImage("strip2"),0,0,null);
			g.drawImage(im.getImage("strip0"),105,0,null);
			g.drawImage(im.getImage("strip1"),210,0,null);
		}
		else if(x==2)
		{
			g.drawImage(im.getImage("stripBlack"),0,0,null);
			g.drawImage(im.getImage("stripRed"),105,0,null);
			g.drawImage(im.getImage("stripGreen"),210,0,null);
		}
		else if(x==3)
		{
			g.drawImage(im.getImage("gridr0c2"),0,0,null);
			g.drawImage(im.getImage("gridr1c2"),105,0,null);
			g.drawImage(im.getImage("gridr0c0"),210,0,null);
			g.drawImage(im.getImage("gridr1c0"),0,105,null);
			g.drawImage(im.getImage("gridr0c1"),105,105,null);
			g.drawImage(im.getImage("gridr1c1"),210,105,null);
		}
		else if(x==4)
		{
			g.drawImage(im.getImage("gridRed"),0,0,null);
			g.drawImage(im.getImage("gridBlue"),105,0,null);
			g.drawImage(im.getImage("gridBlack"),210,0,null);
			g.drawImage(im.getImage("gridYellow"),0,105,null);
			g.drawImage(im.getImage("gridGreen"),105,105,null);
			g.drawImage(im.getImage("gridBrown"),210,105,null);
		}
		x=(x+1)%5;
	}



}