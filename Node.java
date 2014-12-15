import java.util.*;

public class Node {
	private int value;
	private Node[] adjacentNodes;
	private int row;
	private int column;
	private boolean initial = false;
	private ArrayList<Integer> possibilities = new ArrayList<Integer>();
	
	public Node(){}
	
	public Node(int value, int row, int column, int size){
		this.value = value;
		this.row = row;
		this.column = column;
		this.adjacentNodes = new Node[((size*size)-1)*3 - (size - 1)*2];
		if(value != 0)
			this.initial = true;
	}
	
	public Node(int value, Node[] adjacentNodes){
		this.value = value;
		this.adjacentNodes = adjacentNodes;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public Node[] getAdjacentNodes(){
		return this.adjacentNodes;
	}
	
	public void setAdjacentNodes(Node[] adjacentNodes){
		for(int i=0; i<adjacentNodes.length; i++){
			this.adjacentNodes[i] = adjacentNodes[i];
		}
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}
	
	public boolean getInitial(){
		return this.initial;
	}
	
	public boolean correctNode(){
		if(this.initial){
			return true;
		}
		if(this.value == 0){
			return false;
		}
		for(int i=0; i<this.adjacentNodes.length; i++){
			if(this.adjacentNodes[i].getValue() == this.value){
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Node n){
        return (this.row == n.row)&&(this.column == n.column);
	}
	
	public boolean caseVide(){
		if(this.value == 0){
			return true;
		}
		return false;
	}
	
	public void setPossibilities(int size){
		int tab[] = new int[size*size+1];
		for(Node n : this.adjacentNodes){
			tab[n.getValue()]++; 
		}
		this.possibilities.clear();
		for(int i=0; i<tab.length; i++){
			if(i != 0 && tab[i] == 0 && i!=this.value){
				this.possibilities.add(i);
			}
		}
	}
	
	public ArrayList<Integer> getPossibilities(){
		return this.possibilities;
	}
	
	public void setNewValue(){
		if(!this.possibilities.isEmpty()){
			this.value = this.possibilities.remove(0).intValue();
		}
		else
			this.value = 0;
	}
}
