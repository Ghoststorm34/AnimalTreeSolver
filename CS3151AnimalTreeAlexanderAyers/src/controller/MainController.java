package controller;

import java.util.Random;

import model.AnimalNode;
import model.AnimalTree;
import model.Response;
import model.ResponseType;

/**
 * Controller for whole GUI.
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class MainController {
	private AnimalTree tree;
	
	/**
	 * Zero-parameter constructor.
	 * 
	 * @precondition none
	 * @postcondition getTree() != null
	 */
	public MainController() {
		this.tree = new AnimalTree();
	}
	
	public void startGame() {
		String[] animals = {"Lion", "Whale", "Dog", "Dolphin", "Hawk"};
		Random random = new Random();
		int index = random.nextInt(animals.length);
		AnimalNode node = new AnimalNode(new Response(animals[index], ResponseType.ANSWER));
		this.tree.setRoot(node);
		this.tree.resetCurrent();
	}
	
	/**
	 * Gets the tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the tree
	 */
	public AnimalTree getTree() {
		return this.tree;
	}
}
