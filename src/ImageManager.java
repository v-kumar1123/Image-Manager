import com.sun.javafx.iio.ios.IosImageLoaderFactory;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.TreeMap;
import java.util.Set;

public class ImageManager
{
	TreeMap<String, BufferedImage> images = null;

	public ImageManager()
	{
		images =new TreeMap<String,BufferedImage>();
	}

	/* Pre: Receives a name of file
	 * Post: Loads all this images in the file to map of images using the provided load type
	 */
	public boolean loadImages(String fileName) {
		File file=new File(fileName);
		Scanner reader=null;
		try {
			reader = new Scanner(file);
		}catch (FileNotFoundException f) {
			f.printStackTrace();
			return false;
		}

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] readerLine = line.split(",");

			if(readerLine[0].equals("single")) {
				singleLoader(readerLine);
			}

			else if(readerLine[0].equals("SNbL")) {
				snblLoader(readerLine);
			}

			else if(readerLine[0].equals("SSN")) {
			    ssnLoader(readerLine);
			}
			else if(readerLine[0].equals("GNbL")) {
		        gnblLoader(readerLine);
            }

			else if(readerLine[0].equals("GSN")) {
				gsnLoader(readerLine);
			}
			else {
				return false;
			}

		}

		return false;

	}

	public void gnblLoader(String[]readerLine) {
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\" + readerLine[4]));
        }catch (IOException f) {
            f.printStackTrace();
        }
        BufferedImage[][] imgArray=new BufferedImage[Integer.parseInt(readerLine[1])][Integer.parseInt(readerLine[2])];
        ArrayList<BufferedImage> imgs=new ArrayList<BufferedImage>();
        int x=0;
        int divideIntoX=Integer.parseInt(readerLine[1]);
        int divideIntoY=Integer.parseInt(readerLine[2]);
		int subHeight=img.getHeight()/divideIntoY;
		int subWidth=img.getWidth()/divideIntoX;


		int y=0;
		ArrayList<BufferedImage> imgs2=new ArrayList<BufferedImage>();
		BufferedImage[][] array=new BufferedImage[divideIntoY][divideIntoX];
		//Splits via height
		for(int r=0;r<divideIntoY;r++) {
			x=0;
			for (int c = 0; c < divideIntoX; c++) {
				images.put(readerLine[3] + "r" + r + "c" + c, (img.getSubimage(x, y, subWidth, subHeight)));
				//Goes Right
				x+=subWidth;
			}
			//Goes Down
			y+=subHeight;
		}/*

		for(int e=0;e<divideIntoY;e++) {
			if(e%2==0) {
				for (int z = subHeight*e; z < imgs2.size(); z ++) {

				}
			}
			else if(e%2==1) {
				for (int z = subHeight*e; z < imgs2.size(); z ++) {
					images.put(readerLine[3] + "r" + e + "c" + (z - 1) / 2, imgs2.get(z));
				}
			}
		}*/
    }

    public void gsnLoader(String[]readerLine) {
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\" + readerLine[Integer.parseInt(readerLine[1])*Integer.parseInt(readerLine[2])+3]));
		}catch (IOException f) {
			f.printStackTrace();
		}
		BufferedImage[][] imgArray=new BufferedImage[Integer.parseInt(readerLine[1])][Integer.parseInt(readerLine[2])];
		ArrayList<BufferedImage> imgs=new ArrayList<BufferedImage>();
		int x=0;
		int divideIntoX=Integer.parseInt(readerLine[1]);
		int divideIntoY=Integer.parseInt(readerLine[2]);
		int subHeight=img.getHeight()/divideIntoY;
		int subWidth=img.getWidth()/divideIntoX;


		int y=0;
		ArrayList<BufferedImage> imgs2=new ArrayList<BufferedImage>();
		BufferedImage[][] array=new BufferedImage[divideIntoY][divideIntoX];
		//Splits via height\
		int temp=0;
		for(int r=0;r<divideIntoY;r++) {
			x=0;
			for (int c = 0; c < divideIntoX; c++) {
				images.put(readerLine[3+temp], (img.getSubimage(x, y, subWidth, subHeight)));
				//Goes Right
				x+=subWidth;
				temp++;
			}
			//Goes Down
			y+=subHeight;
		}
	}

	public void singleLoader(String[] readerLine) {
		try {
			images.put(readerLine[1], ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\"+readerLine[2])));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}

	public void snblLoader(String[] readerLine) {
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\" + readerLine[3]));
		}catch (IOException f) {
			f.printStackTrace();
		}
		ArrayList<BufferedImage> imgs=new ArrayList<BufferedImage>();
		int x=0;
		int divideInto=Integer.parseInt(readerLine[1]);
		String key=readerLine[2];
		int subWidth=img.getWidth()/divideInto;
		for(int y=0;y<divideInto;y++) {
		    images.put(key+y,img.getSubimage(x,0,subWidth,img.getHeight()));
		    x+=subWidth;
        }
	}


	public void ssnLoader(String[] readerLine) {
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\" + readerLine[Integer.parseInt(readerLine[1])+2]));
        }catch (IOException f) {
            f.printStackTrace();
        }
        ArrayList<BufferedImage> imgs=new ArrayList<BufferedImage>();
        int x=0;
        int divideInto=Integer.parseInt(readerLine[1]);
        String key=readerLine[2];
        int tempX=2;
        int subWidth=img.getWidth()/divideInto;
        for(int y=0;y<divideInto;y++) {
			images.put(readerLine[2+y],img.getSubimage(x,0,subWidth,img.getHeight()));
			x+=subWidth;
            tempX++;
        }
	}
	/* Pre: Receives a key
	 * Post: returns the image that corrisponds to the given key, null if the key is not found
	 */
	public BufferedImage getImage(String key)
	{
		if(images.get(key)!=null) {
			return images.get(key);
		}
		return null;
	}

	/* Pre: Receives a key and a file name
	 * Post: loads the image in the given file to the map with the provided key
	 * Note: null is returned if the file can not be opened
	 */
	public BufferedImage loadImage(String key, String file)
	{
	    try {
            return images.put(key, ImageIO.read(new File(file)));
        }catch (IOException r) {
	        r.printStackTrace();
        }
        return null;
	}

	/* Pre: Receives a key a
	 * Post: removes the key and its image from the map, the removed image is returned.
	 * null is returned if the map does not cantain the given key
	 */
	public BufferedImage removeImage(String key)
	{
		if(images.get(key)!=null) {
			return images.remove(key);
		}
		return null;
	}

	/* Pre: 
	 * Post: empties the map
	 */
	public void clear()
	{
		images.clear();
	}

	/* Pre: 
	 * Post: returns a set of all the keys in the map
	 */
	public Set<String> getKeys()
	{
		return images.keySet();
	}
}