package exercises;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vect = new int[3];
        System.out.println("Digite 3 números inteiros");
        for (int i=0; i<vect.length; i++){
            System.out.print("Digite o " + (i+1) + "º número: ");
            vect[i] = sc.nextInt();
        }
        if (vect[0] < vect[1] && vect[0] < vect[2]){
            System.out.println("A posição do menor número digitado é: 0");
        } else if (vect[1] < vect[2]){
            System.out.println("A posição do menor número digitado é: 1");
        } else {
            System.out.println("A posição do menor número digitado é: 2");
        }
        sc.close();
    }
}
