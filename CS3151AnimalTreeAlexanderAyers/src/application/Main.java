package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.AnimalNode;
import model.AnimalTree;
import model.NodeDirection;
import model.Response;
import model.ResponseType;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main {

	
	public static void main(String[] args) {
		Response resp1 = new Response("Is your animal a mammal?", ResponseType.QUESTION);
		Response resp2 = new Response("Lion", ResponseType.ANSWER);
		Response resp3 = new Response("Dolphin", ResponseType.ANSWER);
		AnimalNode node1 = new AnimalNode(resp1);
		AnimalNode node2 = new AnimalNode(resp2);
		AnimalNode node3 = new AnimalNode(resp3);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		AnimalTree tree = new AnimalTree(node1);
		
		Response ans = new Response("Woodpecker", ResponseType.ANSWER);
		Response ques = new Response("Is your animal a bird?", ResponseType.QUESTION);
		
		tree.insert(node3, ans, ques, NodeDirection.YES);
		
		System.out.println(tree.getRoot().getRightChild().getLeftChild().getValue().getValue());
	}
}
