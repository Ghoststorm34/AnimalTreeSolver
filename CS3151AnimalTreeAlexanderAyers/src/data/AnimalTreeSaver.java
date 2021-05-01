package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.AnimalTree;
import model.Response;

/**
 * Saves an animal tree to a file.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class AnimalTreeSaver {

	/**
	 * Saves a specified tree to a specified file.
	 * 
	 * @precondition none
	 * @postcondition file has been saved
	 * 
	 * @param file the specified file
	 * @param tree the specified tree
	 */
	public static void saveToFile(File file, AnimalTree tree) {
		try (PrintWriter writer = new PrintWriter(file)) {
			for (Response current : tree) {
				String line = current.getValue() + ", " + current.getType();
				writer.println(line);
			}
		} catch (FileNotFoundException | NullPointerException e) {
			e.printStackTrace();
		}
	}
}
