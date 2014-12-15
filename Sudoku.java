
public class Sudoku {

	public static void main(String[] args) {
		//sudoku de test / valeur de référence pour un sudoku de taille 3²*3²
		int taille = 3;
		
		Resolution sudoku;
		Generation s;
		sudoku = new Resolution(taille);
		sudoku.resoudreSudoku();
		sudoku.print();
		System.out.println("*******************************************");
		s = new Generation(sudoku.getNodes(), taille);
		s.generateSudoku();
		s.print();
		System.out.println("*******************************************");
		sudoku = new Resolution(s.getNodes(), taille);
		sudoku.resoudreSudoku();	
		sudoku.print();
		System.out.println("-----------------------------------------------------------");
	}
}
