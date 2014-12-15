import java.util.Stack;

public class Resolution extends Grid{
	
	protected int positionNode = 0;
	
	public Resolution(int size){
		super(size);
	}
	public Resolution(Node[][] nodes, int size){
		super(nodes, size);
	}
	
	public int getPositionNode(){
		return this.positionNode;
	}
	
	//public methods
	public Node choixCase(){
		int j = this.positionNode%(this.size*this.size);
		int i = this.positionNode/(this.size*this.size);
		Node res = this.nodes[i][j];
		if(res.getInitial()){
			this.positionNode++;
			res = this.choixCase();
		}
		return res;
	}
	
	public void setPosition(){
		this.positionNode--;
		int j = this.positionNode%(this.size*this.size);
		int i = this.positionNode/(this.size*this.size);
		Node noeud = this.nodes[i][j];
		if(noeud.getInitial()){
			this.setPosition();
		}
	}
	
	public void resoudreSudoku(){
		Stack<Node> stack = new Stack<Node>();
		Node noeud = this.choixCase();
		boolean flag= false;
		while(!this.sudokuResolu()){
			if(noeud.getPossibilities().isEmpty() && !flag)
				noeud.setPossibilities(this.size);
			noeud.setNewValue();
			if(noeud.correctNode()){
				flag = false;
				stack.push(noeud);
				if(!this.sudokuResolu()){
					this.positionNode++;
					noeud = this.choixCase();
				}
			}
			else{
				if(noeud.getPossibilities().isEmpty()){
					//met la valeur du noeud a 0
					noeud.setValue(0);
					noeud = stack.pop();
					this.setPosition();
					flag = true;
				}
			}
		}
	}
}
