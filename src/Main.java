public class Main {

    public static void main(String[] args) {
	// write your code here
	    // Exercise 1
	    import java.util.Scanner;
public class Main {

    public static double firstMethod(double n, double m){

        double result = ((n+1) / (n*n*m+2)) + ((m+n) / (m-n)) + n*n*n;
        return result;
    }

    public static double secondMethod(int n, int m){



        double result = (double) ((n+1) / (n*n*m+2)) + (double) (((m+n) / (m-n)) + n*n*n);
        return result;
    }

    public static int thirdMethod(double n, double m){

        int result = (int) ((n+1) / (n*n*m+2)) + (int) (((m+n) / (m-n)) + n*n*n);
        return result;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("First Method");

        String nStr = "";
        String mStr = "";

        do{
            System.out.print("Input x: ");
            nStr = scan.nextLine();
        } while (!nStr.matches("\\d+") || nStr.equals("0"));
        do{
            System.out.print("Input y: ");
            mStr = scan.nextLine();
        } while (!mStr.matches("\\d+") || mStr.equals("0"));



        double x = Double.valueOf(nStr);
        double y = Double.valueOf(mStr);

        System.out.println("Result: " + firstMethod(x, y));
        System.out.println("Result: " + secondMethod((int) x, (int) y));
        System.out.println("Result: " + thirdMethod(x, y));

    }
}
//Exercise 2
	    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int length = -1;
        while (length <= 0 || length > 500) {
            System.out.print("Input n<=500: ");
            if (scan.hasNextInt()) {
                length = scan.nextInt();
                scan.nextLine();
                if (length <= 0 || length > 500) {
                    System.out.println("Invalid input, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
                scan.nextLine();
            }
        }

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("a["+i+"]= ");
                if (scan.hasNextInt()) {
                    array[i] = scan.nextInt();
                    validInput = true;
                    scan.nextLine();
                } else {
                    System.out.println("Invalid input, please try again.");
                    scan.nextLine();
                }
            }
        }



        System.out.print("A = ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        int[] arr2 = new int[length];
        for (int i = 0; i < array.length; i++) {
            arr2[i] = array[i];
        }

        int checkCountOfElement = 0;
        int nullElement = 0;
        for (int i = 0; i < array.length; i++) {
            checkCountOfElement = 0;
            for (int j = i; j < arr2.length; j++) {
                if(array[i] == arr2[j]){
                    checkCountOfElement++;
                    arr2[j] = 0;
                }
            }
            if(checkCountOfElement>3){
                nullElement = nullElement + checkCountOfElement;
            }
        }

        int indexForFinalArray = 0;
        for (int i = 0; i < array.length; i++) {
            checkCountOfElement = 0;

            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]){
                    checkCountOfElement++;

                }
            }
            if(checkCountOfElement<=3){
                arr2[indexForFinalArray] = array[i];
                indexForFinalArray++;
            }
        }

        System.out.print("\nFinal array A = ");
        for (int i = 0; i < arr2.length - nullElement; i++) {
            System.out.print(arr2[i] + "\t");
        }


    }
}
//Exercise 3
	    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = -1;

        while (n <= 0 || n > 20) {
            System.out.print("Input n<=20: ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                input.nextLine();
                if (n <= 0 || n > 20) {
                    System.out.println("Invalid input, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }

        // Ініціалізуємо матрицю розміром n x n
        int[][] A = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean validInput = false;
                while (!validInput){

                    System.out.print("A[" + i +"," + j + "]= ");
                    if(input.hasNextInt()){
                        A[i][j] = input.nextInt();
                        validInput = true;
                        input.nextLine();
                    }
                    else {
                        System.out.println("Invalid input, please try again.");
                        input.nextLine();
                    }
                }
            }
        }

        for (int i = 0; i < A.length; ++i, System.out.println() ) {
            for (int j = 0; j < A[i].length; ++j) {
                System.out.print(A[i][j] + "\t");
            }
        }

        // Знаходимо стовпчик з мінімальним елементом
        int minCol = 0;
        int minVal = A[0][0];
        for (int j = 0; j < n; j++) {
            if (A[0][j] < minVal) {
                minVal = A[0][j];
                minCol = j;
            }
        }

        // Виконуємо циклічний зсув стовпців
        for (int i = 0; i < n; i++) {
            int temp = A[i][0];
            for (int j = 0; j < n - 1; j++) {
                A[i][j] = A[i][j+1];
            }
            A[i][n-1] = temp;
        }

        // Знаходимо стовпчик з мінімальним елементом після зсуву
        for (int j = 0; j < n; j++) {
            if (A[0][j] == minVal) {
                minCol = j;
                break;
            }
        }

        // Виводимо зсунуту матрицю
        System.out.println("Зсунута матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][(j+minCol)%n] + "\t");
            }
            System.out.println();
        }
    }
}
//Exercise 4
	    import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        String text = "Це приклад, тексту. Зі словами! які не повторються.";
        System.out.println(text);
        String[] words = text.split("[ ,.:;-?!]+");

        for (String word : words) {
            if (hasUniqueChars(word)) {
                System.out.println(word);
            }
        }
    }

    public static boolean hasUniqueChars(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (word.indexOf(c) != i || word.indexOf(c, i + 1) != -1) {
                return false; //
            }
        }
        return true; 
    }
}
//end
        System.out.println("Lab 1 Java");
    }
}
