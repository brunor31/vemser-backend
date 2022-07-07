package exercises;

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vect = {2,3,5,7,11,13,17,23,29,31};
        System.out.print("Digite um número para buscar no vetor: ");
        int number = sc.nextInt();
        sc.nextLine();
        boolean thereIs = false;
        for (int i=0; i< vect.length; i++) {
            if (number == vect[i]) {
                thereIs = true;
            }
        }
        if (thereIs == true){
            System.out.println("O vetor contém este número");
        } else {
            System.out.println("O vetor não contém este número");
        }
        sc.close();
    }
}
