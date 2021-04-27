package model;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
/**
 * Models a tree containing questions and answers for animals.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class AnimalTree implements Iterable<Response> {
	private AnimalNode root;
	private AnimalNode current;

	/**
	 * Instantiates an empty animal guessing game tree
	 *
	 * @pre none
	 * @post getRoot() == null
	 */
	public AnimalTree() {
		this.root = null;
		this.current = this.root;
	}

	/**
	 * Instantiates an new animal guessing game tree
	 *
	 * @pre root is the root node of a animal guessing game tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public AnimalTree(AnimalNode root) {
		this.root = root;
		this.current = this.root;
	}

	/**
	 * Returns the root node
	 * 
	 * @pre none
	 * @post none
	 * @return the root node of this tree
	 */
	public AnimalNode getRoot() {
		return this.root;
	}

	/**
	 * Traverses to the right child of the current node and sets the current node to
	 * the right child.
	 * 
	 * @precondition getCurrent() != null
	 * @postcondition ( getCurrent().getValue().getType() != ResponseType.ANSWER AND
	 *                getCurrent().getHasRightChild() ) IMPLIES ( getCurrent() ==
	 *                getCurrent().getRightChild() )
	 * 
	 * @return whether the node was traversed or not.
	 */
	public boolean traverseRightChild() {
		if (this.current == null) {
			return false;
		}
		if (!this.current.getValue().getType().equals(ResponseType.ANSWER) && this.current.hasRightChild()) {
			this.current = this.current.getRightChild();
			return true;
		}
		return false;
	}

	/**
	 * Traverses to the left child of the current node and sets the current node to
	 * the left child.
	 * 
	 * @precondition getCurrent() != null
	 * @postcondition ( getCurrent().getValue().getType() != ResponseType.ANSWER AND
	 *                getCurrent().hasLeftChild() ) IMPLIES ( getCurrent() ==
	 *                getCurrent().getLeftChild() )
	 * 
	 * @return whether the node was traversed or not.
	 */
	public boolean traverseLeftChild() {
		if (this.current == null) {
			return false;
		}
		if (!this.current.getValue().getType().equals(ResponseType.ANSWER) && this.current.hasLeftChild()) {
			this.current = this.current.getRightChild();
			return true;
		}
		return false;
	}

	/**
	 * Resets the current node to the start of the tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void resetCurrent() {
		this.current = this.root;
	}

	/**
	 * Resets the root of this tree
	 * 
	 * @pre root is the root node of a animal guessing game tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public void setRoot(AnimalNode root) {
		this.root = root;
	}

	/**
	 * Returns an iterator that traverses this animal guessing game tree in
	 * level-order
	 * 
	 * @pre none
	 * @post none
	 * @return a level-order iterator
	 */
	@Override
	public Iterator<Response> iterator() {
		return new LevelOrderIterator();
	}

	public void insert(AnimalNode selectedNode, Response newAnswer, Response newQuestion, NodeDirection direction) {
		AnimalNode newAnimal = new AnimalNode(newAnswer);
		AnimalNode questionNode = new AnimalNode(newQuestion);
		if (this.root.getValue().getType().equals(ResponseType.ANSWER)) {
			this.firstTimeInsert(selectedNode, direction, newAnimal, questionNode);
		} else {
			this.primaryInsert(selectedNode, direction, newAnimal, questionNode);
		}

	}

	/**
	 * @param selectedNode
	 * @param direction
	 * @param newAnimal
	 * @param questionNode
	 */
	private void firstTimeInsert(AnimalNode selectedNode, NodeDirection direction, AnimalNode newAnimal,
			AnimalNode questionNode) {
		this.root = questionNode;
		if (direction.equals(NodeDirection.YES)) {
			this.root.setLeftChild(newAnimal);
			this.root.setRightChild(selectedNode);
		} else {
			this.root.setRightChild(newAnimal);
			this.root.setLeftChild(selectedNode);
		}
	}

	/**
	 * @param selectedNode
	 * @param direction
	 * @param newAnimal
	 * @param questionNode
	 */
	private void primaryInsert(AnimalNode selectedNode, NodeDirection direction, AnimalNode newAnimal,
			AnimalNode questionNode) {
		AnimalNode parent = selectedNode.getParent();
		if (parent.getLeftChild().getValue().equals(selectedNode.getValue())) {
			parent.setLeftChild(questionNode);
		} else {
			parent.setRightChild(questionNode);
		}
		if (direction.equals(NodeDirection.YES)) {
			questionNode.setLeftChild(newAnimal);
			questionNode.setRightChild(selectedNode);
		} else {
			questionNode.setRightChild(newAnimal);
			questionNode.setLeftChild(selectedNode);
		}
	}

	public AnimalNode getCurrent() {
		return current;
	}

	/**
	 * Class LevelOrderIterator
	 * 
	 * An iterator that traverses this animal guessing game tree in level-order
	 */
	protected class LevelOrderIterator implements Iterator<Response> {
		private Queue<AnimalNode> nodeQueue;

		public LevelOrderIterator() {
			this.nodeQueue = new ArrayDeque<AnimalNode>();
			this.nodeQueue.add(AnimalTree.this.root);
		}

		@Override
		public boolean hasNext() {
			return !this.nodeQueue.isEmpty();
		}

		@Override
		public Response next() {
			AnimalNode node = this.nodeQueue.remove();
			if (node.hasLeftChild()) {
				this.nodeQueue.add(node.getLeftChild());
			}
			if (node.hasRightChild()) {
				this.nodeQueue.add(node.getRightChild());
			}
			return node.getValue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
