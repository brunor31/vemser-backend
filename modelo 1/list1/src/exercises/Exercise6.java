package exercises;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a palavra que você deseja traduzir, com a primeira letra MAIÚSCULA");
        String word = sc.nextLine();
        if (word.equals("Cachorro")){
            System.out.println("Dog");
        } else if (word.equals("Dog")){
            System.out.println("Cachorro");
        } else if (word.equals("Tempo")){
            System.out.println("Time");
        } else if (word.equals("Time")){
            System.out.println("Tempo");
        } else if (word.equals("Amor")){
            System.out.println("Love");
        } else if (word.equals("Love")){
            System.out.println("Amor");
        } else if (word.equals("Feliz")){
            System.out.println("Happy");
        } else if (word.equals("Happy")){
            System.out.println("Feliz");
        } else if (word.equals("Triste")){
            System.out.println("Sad");
        } else if (word.equals("Sad")){
            System.out.println("Triste");
        } else if (word.equals("Deveria")){
            System.out.println("Should");
        } else if (word.equals("Should")){
            System.out.println("Deveria");
        } else if (word.equals("Poderia")){
            System.out.println("Could");
        } else if (word.equals("Could")){
            System.out.println("Poderia");
        } else {
            System.out.println("Essa palavra não é válida");
        }
        sc.close();
    }
}
