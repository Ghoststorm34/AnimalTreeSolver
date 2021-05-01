package model;
/**
 * Nodes for the animal guessing game tree.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class AnimalNode {
	private Response value;
	private AnimalNode leftChild;
	private AnimalNode rightChild;
	private AnimalNode parent;

	/**
	 * Instantiates a new animal node
	 * 
	 * @pre none
	 * @post getValue() == null AND !hasLeftChild() AND !hasRightChild() AND
	 *       !hasParent()
	 */
	public AnimalNode() {
		this(null);
	}

	/**
	 * Instantiates a new animal node
	 *
	 * @pre none
	 * @post getValue() == value AND !hasLeftChild() AND !hasRightChild() AND
	 *       !hasParent()
	 * @param value the value of the new node
	 */
	public AnimalNode(Response value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	/**
	 * Returns the left child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the left child of this node
	 */
	public AnimalNode getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Returns the right child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the right child of this node
	 */
	public AnimalNode getRightChild() {
		return this.rightChild;
	}

	/**
	 * Returns the parent
	 * 
	 * @pre none
	 * @post none
	 * @return returns the parent of this node
	 */
	public AnimalNode getParent() {
		return this.parent;
	}

	/**
	 * Returns the value
	 * 
	 * @pre none
	 * @post none
	 * @return returns the value of this node
	 */
	public Response getValue() {
		return this.value;
	}

	/**
	 * Sets the left child
	 * 
	 * @pre none
	 * @post getLeftChild() == child
	 * @param child the new left child of this node
	 */
	public void setLeftChild(AnimalNode child) {
		this.leftChild = child;
		child.parent = this;
	}

	/**
	 * Sets the right child
	 *
	 * @pre none
	 * @post getRightChild() == child
	 * @param child the new right child of this node
	 */
	public void setRightChild(AnimalNode child) {
		this.rightChild = child;
		child.parent = this;
	}

	/**
	 * Sets the node value
	 *
	 * @pre none
	 * @post getValue() == value
	 * @param value the new value of this node
	 */
	public void setValue(Response value) {
		this.value = value;
	}

	/**
	 * Checks if this node has a left child
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a left child
	 */
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	/**
	 * Checks if this node has a right child
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a right child
	 */
	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	/**
	 * Checks if this node has a parent
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a parent
	 */
	public boolean hasParent() {
		return this.parent != null;
	}
}
