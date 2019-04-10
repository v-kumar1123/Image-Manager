import java.awt.Graphics;
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
	public boolean loadImages(String fileName)
	{
		return true;
	}

	/* Pre: Receives a key
	 * Post: returns the image that corrisponds to the given key, null if the key is not found
	 */
	public BufferedImage getImage(String key)
	{
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