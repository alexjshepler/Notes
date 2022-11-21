public class SudokuTest {
    public static void main(String[] args) {
        char[][] puzzle = SudokuP.puzzle();

        // char[][] puzzle = { 
                // { '1', '.', '.', '.', '.', '.', '.', '.', '.' },
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
                // { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

        Sudoku.print(puzzle);

        System.out.println("Is valid: " + Sudoku.check(puzzle));

        System.out.println("\n\n--------------------\n\n");

        Sudoku.solve(puzzle);
        // Sudoku.print(puzzle);
        System.out.println("Is valid: " + Sudoku.check(puzzle));
    }
}