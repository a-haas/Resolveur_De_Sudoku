
public class Sudoku {

	public static void main(String[] args) {
		System.out.println("Simply a sudoku solver \n");

		//sudoku de test / valeur de r�f�rence pour un sudoku de taille 3�*3�
		int taille = 3;
		Resolution sudoku;
		Generation s;
		// r�solution d'un sudoku vide
		sudoku = new Resolution(taille);
		sudoku.resoudreSudoku();
		// g�n�ration d'un nouveau sudoku � partir du sudoku r�solu (shuffling, etc)
		s = new Generation(sudoku.getNodes(), taille);
		s.generateSudoku();
		System.out.println("G�n�ration d'un nouveau sudoku : ");
		s.print();
		System.out.println("");
		// r�solution du sudoku g�n�r�
		sudoku = new Resolution(s.getNodes(), taille);
		sudoku.resoudreSudoku();
		System.out.println("Voici la solution du sudoku : ");	
		sudoku.print();
	}
}
