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
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class AnimalTreeLoader {
	
	public static AnimalTree loadFromFile(File file) {
		ArrayList<Response> responses = new ArrayList<Response>();
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String [] splitLine = line.split(", ");
				Response value;
				if (splitLine[1].equals("QUESTION")) {
					value = new Response(splitLine[0], ResponseType.QUESTION);
				} else {
					value = new Response(splitLine[0], ResponseType.ANSWER);
				}
				responses.add(value);
			}
			
			if (responses.size() > 0) {
			AnimalTree tree = new AnimalTree();
			Response root = responses.get(0);
			AnimalNode rootNode = new AnimalNode(root);
			tree.setRoot(rootNode);
			readSubtree(responses, 0, rootNode);
			return tree;
		}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private static int readSubtree(ArrayList<Response> responses, int index, AnimalNode node) {
		if (index >= responses.size()) {
			return index;
		}
		Response value = responses.get(index);
		index++;
		node.setValue(value);
		
		if(value.getType().equals(ResponseType.ANSWER)) {
			return index;
		}
		
		AnimalNode leftChild = new AnimalNode();
		node.setLeftChild(leftChild);
		index = readSubtree(responses, index, leftChild);
		
		AnimalNode rightChild = new AnimalNode();
		node.setRightChild(rightChild);
		index = readSubtree(responses, index, rightChild);
		
		return index;
	}
}
