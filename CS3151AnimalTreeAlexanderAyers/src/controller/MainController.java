package controller;

import java.util.Random;

import model.AnimalNode;
import model.AnimalTree;
import model.NodeDirection;
import model.Response;
import model.ResponseType;

// TODO: Auto-generated Javadoc
/**
 * Controller for whole GUI.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class MainController {

	/** The tree. */
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
	 * Starts the game with a random animal at the root.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void startGame() {
		String[] animals = { "Lion", "Whale", "Dog", "Dolphin", "Hawk" };
		Random random = new Random();
		int index = random.nextInt(animals.length);
		AnimalNode node = new AnimalNode(new Response(animals[index], ResponseType.ANSWER));
		this.tree.setRoot(node);
		this.tree.resetCurrent();
	}

	/**
	 * Adds the new animal into the tree along with the specified question.
	 * 
	 * @precondition none
	 * @postcondition getTree() has two additional nodes.
	 * 
	 * @param answer    the answer
	 * @param question  the question
	 * @param direction the direction
	 */
	public void addNewAnimal(String answer, String question, NodeDirection direction) {
		this.tree.insert(this.tree.getCurrent(), new Response(answer, ResponseType.ANSWER),
				new Response(question, ResponseType.QUESTION), direction);
	}

	/**
	 * Resets the game within the existing tree.
	 * 
	 * @precondition none
	 * @postcondition getTree().getCurrent() == getTree().getRoot()
	 */
	public void resetGame() {
		this.tree.resetCurrent();
	}

	/**
	 * Gets the text of current node.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the text of current
	 */
	public String getTextOfCurrent() {
		return this.tree.getCurrent().getValue().getValue();
	}

	/**
	 * Traverses the current node to the right.
	 * 
	 * @precondition none
	 * @postcondition getTree().getCurrent() == @prev getTree().getCurrent().getRightChild()
	 */
	public void traverseRight() {
		this.tree.traverseRightChild();
	}

	/**
	 * Traverses the current node to the left.
	 * 
	 * @precondition none
	 * @postcondition getTree().getCurrent() == @prev getTree().getCurrent().getLeftChild()
	 */
	public void traverseLeft() {
		this.tree.traverseLeftChild();
	}

	/**
	 * Gets the tree.
	 *
	 * @return the tree
	 * @precondition none
	 * @postcondition none
	 */
	public AnimalTree getTree() {
		return this.tree;
	}
}
