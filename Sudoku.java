
public class Sudoku {

	public static void main(String[] args) {
		System.out.println("Simply a sudoku solver \n");

		//sudoku de test / valeur de référence pour un sudoku de taille 3²*3²
		int taille = 3;
		Resolution sudoku;
		Generation s;
		// résolution d'un sudoku vide
		sudoku = new Resolution(taille);
		sudoku.resoudreSudoku();
		// génération d'un nouveau sudoku à partir du sudoku résolu (shuffling, etc)
		s = new Generation(sudoku.getNodes(), taille);
		s.generateSudoku();
		System.out.println("Génération d'un nouveau sudoku : ");
		s.print();
		System.out.println("");
		// résolution du sudoku généré
		sudoku = new Resolution(s.getNodes(), taille);
		sudoku.resoudreSudoku();
		System.out.println("Voici la solution du sudoku : ");	
		sudoku.print();
	}
}
