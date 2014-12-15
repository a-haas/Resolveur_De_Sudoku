public class Grid {
	protected Node[][] nodes;
	protected int size;
		
	//constructeurs
	public Grid(int size){
		this.size = size;
		this.nodes = new Node[size*size][size*size];
		
		for(int i=0; i<size*size; i++){
			for(int j=0; j<size*size; j++){
				this.nodes[i][j] = new Node(0, i, j, size);
			}
		}
		
		for(int i=0; i<size*size; i++){
			for(int j=0; j<size*size; j++){
				this.setAdjacentNodes(this.nodes[i][j]);
			}
		}
		
		this.resetPossibilities();
	}
	
	public Grid(Node[][] nodes, int size){
		this.nodes = nodes;
		this.size = size;
		for(int i=0; i<size*size; i++){
			for(int j=0; j<size*size; j++){
				this.setAdjacentNodes(this.nodes[i][j]);
			}
		}
	}
	
	//getters/setters
	public Node[][] getNodes(){
		return this.nodes;
	}
	
	public int getSize(){
		return this.size;
	}	
	
	public Node getNode(int i, int j){
		return this.nodes[i][j];
	}
	
	public void setNode(int i, int j, int v){
		this.nodes[i][j].setValue(v);
	}
	
	public boolean sudokuResolu(){
		for(int i=0; i<this.size*this.size; i++){
			for(int j=0; j<this.size*this.size; j++){
				if(!this.nodes[i][j].correctNode()){
					return false;
				}
			}
		}
		return true;
	}
	
	public void print(){
		for(int i = 0; i < this.size*this.size; i++){
			for(int j = 0; j < this.size*this.size; j++){
				System.out.print(this.getNode(i, j).getValue() + "\t");
			}
			System.out.println();
		}
   }
	
	public void resetPossibilities(){
		for(int i=0; i<this.size*this.size; i++){
			for(int j=0; j<this.size*this.size; j++){
				this.getNode(i, j).setPossibilities(this.size);
			}
		}
	}
  
	
	//protected methods
	protected Node[] getRegion(Node n){
        Node[] tab = new Node[(this.size*this.size)-1];
        int pos = 0;
        int c = (n.getColumn()/this.size)*this.size;
        int l = (n.getRow()/this.size)*this.size;
        for(int i = l; i < (l + this.size); i++){
        	for(int j = c; j < (c + this.size); j++){
        		if((n.getRow() != i) || (n.getColumn() != j)){
        			tab[pos] = this.nodes[i][j];
        			pos++;
        		}
        	}
        }
        return tab;
	}
	
	protected Node[] getLine(Node n){
        Node[] tab = new Node[(this.size*this.size)-1];
        int pos = 0; 
        for(int j = 0; j < this.size*this.size; j++){
        	if(n.getColumn() != j){
        		tab[pos] = nodes[n.getRow()][j];
        		pos++;
        	}
        }
        return tab;
	}
	
	protected Node[] getColumn(Node n){
        Node[] tab = new Node[(this.size*this.size)-1];
        int pos = 0;
        for(int i = 0; i < this.size*this.size; i++){
        	if(n.getRow() != i){
        		tab[pos] = nodes[i][n.getColumn()];
        		pos++;
        	}
        }
        return tab;
	}
	
	protected Node[] setAdjacentNodes(Node n){
			int s = ((this.size*this.size)-1)*3 - (this.size - 1)*2;
			Node[] tab = new Node[s];	
			int i;
			int cpt=0;
	    	Node[] tabRegion = getRegion(n);
	    	Node[] tabLine = getLine(n);
	    	Node[] tabColumn = getColumn(n);
	          
	        // REGION
	     	for(i = 0; i < tabRegion.length; i++){
	        	tab[cpt] = tabRegion[i];
	        	cpt++;
	     	}
	          
	        // ROWS
	     	int b = (n.getColumn()/this.size)*this.size;
	     	int e = b+this.size;
	     	for(int j = 0; j < tabLine.length; j++){
	      		if(j<b || j>=(e-1)){
	       			tab[cpt] = tabLine[j];
	       			cpt++;
	      		}
	     	}
	          
	        // COLUMNS
	     	b = (n.getRow()/this.size)*this.size;
	     	e = b+this.size;
	     	for(int k = 0; k < tabColumn.length; k++){
	      		if(k<b || k>=(e-1)){
	       			tab[cpt] = tabColumn[k];
	       			cpt++;
	      		}
	     	}
	     	n.setAdjacentNodes(tab);
	     	return tab;
	}
}
