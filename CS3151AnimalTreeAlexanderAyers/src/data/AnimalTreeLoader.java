package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.AnimalNode;
import model.AnimalTree;
import model.Response;
import model.ResponseType;

/**
 * Loads an animal tree from a file.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class AnimalTreeLoader {

	public static AnimalTree loadFromFile(File file) {
		ArrayList<Response> loadedValues = new ArrayList<Response>();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] splitLine = line.split(", ");
				Response currentValue;
				if (splitLine[1].equals("QUESTION")) {
					currentValue = new Response(splitLine[0], ResponseType.QUESTION);
				} else {
					currentValue = new Response(splitLine[0], ResponseType.ANSWER);
				}
				loadedValues.add(currentValue);
			}

			if (loadedValues.size() > 0) {
				AnimalTree newTree = new AnimalTree();
				Response rootValue = loadedValues.get(0);
				AnimalNode rootNode = new AnimalNode(rootValue);
				newTree.setRoot(rootNode);
				readSubtree(loadedValues, 0, rootNode);
				return newTree;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static int readSubtree(ArrayList<Response> loadedValues, int index, AnimalNode node) {
		if (index >= loadedValues.size()) {
			return index;
		}
		Response value = loadedValues.get(index);
		node.setValue(value);
		index++;

		if (value.getType().equals(ResponseType.ANSWER)) {
			return index;
		}

		AnimalNode leftChild = new AnimalNode();
		node.setLeftChild(leftChild);
		index = readSubtree(loadedValues, index, leftChild);

		AnimalNode rightChild = new AnimalNode();
		node.setRightChild(rightChild);
		index = readSubtree(loadedValues, index, rightChild);

		return index;
	}
}
