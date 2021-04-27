package controller;

import model.AnimalTree;

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
