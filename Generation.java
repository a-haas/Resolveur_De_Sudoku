import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generation extends Grid{
   
	public Generation(int size){
        super(size);
    }
    
    public Generation(Node[][] nodes, int size){
        super(nodes, size);
    }
    
    public void swapValues(Node n1, Node n2){
        int temp;
        temp = n1.getValue();
        n1.setValue(n2.getValue());
        n2.setValue(temp);
    }
  
    public void swapRows(){
        for(int i = 0; i < (this.size*this.size)/2; i++){
            for(int j = 0; j < this.size*this.size; j++){
                Node n1 = this.getNode(i, j);
                Node n2 = this.getNode(this.size*this.size - 1 - i, j);
                this.swapValues(n1, n2);
            }
        }
    }

    public void swapColumns(){
        for(int i = 0; i < this.size*this.size; i++){
            for(int j = 0; j < (this.size*this.size)/2; j++){
                Node n1 = this.getNode(i, j);
                Node n2 = this.getNode(i, this.size*this.size-1-j);
                this.swapValues(n1, n2);
            }
        }
    }

    public void swapDiagonalOne(){
        for(int i = 0; i < this.size*this.size; i++){
            for(int j = i; j < this.size*this.size; j++){
                Node n1 = this.getNode(i, j);
                Node n2 = this.getNode(j, i);
                this.swapValues(n1, n2);
            }
        }
    }
    public void swapDiagonalTwo(){
        for(int i = 0; i < this.size*this.size; i++){
            for(int j = this.size*this.size - 1 - i; j > 0; j--){
                Node n1 = this.getNode(i, j - 1);
                Node n2 = this.getNode((this.size*this.size - 1 - i ) - (j - 1) + i, this.size*this.size - 1 - i);
                this.swapValues(n1, n2);
            }
        }
    }

    public void deleteElements(){
        this.resetPossibilities();
        ArrayList<Integer> l = new ArrayList<Integer>();
    
        // INITIALISE THE ARRAY
        for(int i = 0; i < this.size*this.size; i++){
            for(int j = 0; j < this.size*this.size; j++){
                l.add(i*this.size*this.size + j);
            }
        }
    
        // SHUFFLE THE LIST
        Collections.shuffle(l);
        int i = 0;
        int pos;
        Node n;
        while(!l.isEmpty() && i < l.size()){
            pos = l.get(i);
            int column = pos%(this.size*this.size);
            int row = pos/(this.size*this.size);
            if(this.getNode(row, column).getPossibilities().size() == 1 || this.getNode(row, column).getPossibilities().isEmpty()){
                this.setNode(row, column, 0);
                l.remove(i);
                n = this.getNode(row, column);
                for(int j=0; j<n.getAdjacentNodes().length; j++){
                    n.getAdjacentNodes()[j].setPossibilities(this.size);
                }
            }
            else
                i++;
        }
    }

    public void generateSudoku(){
        Random random = new Random();
        int c = random.nextInt(7);
        int choice;
        for(int i = 0; i < c; i++){
            choice = random.nextInt(4);
            switch(choice){
                case 0:
                    this.swapRows();
                    break;
                case 1:
                    this.swapColumns();
                    break;
                case 2:
                    this.swapDiagonalOne();
                    break;
                case 3:
                    this.swapDiagonalTwo();
                    break;
            }
        }
        this.deleteElements();
    }
}