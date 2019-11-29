import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        String matrixCoordinates = stringScanner.nextLine();
        String[] matrixStringCoordinates = matrixCoordinates.split(" ");
        int rows = Integer.parseInt((matrixStringCoordinates[0]));
        int columns = Integer.parseInt((matrixStringCoordinates[1]));

        int seatsNeeded;
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String rowString = stringScanner.nextLine();
            String[] rowSplit = rowString.split(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(rowSplit[j]);
            }
        }


        seatsNeeded = scanner.nextInt();

        System.out.println(countFreeSpaces(matrix,rows,columns,seatsNeeded));
    }
    private static int countFreeSpaces(int[][] inputMatrix, int rows, int columns, int spacesNeeded) {
        for (int i = 0; i < rows; i++) {
            int freeSpaces = 0;
            for (int j = 0; j < columns; j++) {
                if (inputMatrix[i][j] == 0){
                    freeSpaces++;
                }
                if (inputMatrix[i][j] == 1 && freeSpaces != 0){
                    freeSpaces--;
                }
                if(spacesNeeded == freeSpaces){
                    return i+1;
                }
            }
        }
        return -1;
    }
}
