import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
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

			else if(true) {
			}
			else {
				return false;
			}

		}

		return false;

	}

	public void singleLoader(String[] readerLine) {
		try {
			images.put(readerLine[1], ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\"+readerLine[2])));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}

	public void snblLoader(String[] readerLine) {
		try {
			images.put(readerLine[2]+readerLine[1], ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\"+readerLine[3])));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}


	public void ssnLoader(String[] readerLine) {
		try {
			images.put(readerLine[2]+readerLine[1], ImageIO.read(new File("C:\\Users\\varun\\Desktop\\Image-Manager\\src\\"+readerLine[3])));
		}catch (IOException e ) {
			e.printStackTrace();
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
		return null;
	}

	/* Pre: Receives a key a
	 * Post: removes the key and its image from the map, the removed image is returned.
	 * null is returned if the map does not cantain the given key
	 */
	public BufferedImage removeImage(String key)
	{
		return null;
	}

	/* Pre: 
	 * Post: empties the map
	 */
	public void clear()
	{
	
	}

	/* Pre: 
	 * Post: returns a set of all the keys in the map
	 */
	public Set<String> getKeys()
	{
		return images.keySet();
	}
}