package exercises;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Informe um número aleátorio: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Informe um número para adivinhar o número informado pelo programa: ");
        int userNumber = sc.nextInt();
        while (userNumber != number){
            if (userNumber < number){
                System.out.println("O número a ser encontrado é maior do que você digitou");
            } else {
                System.out.println("O número a ser encontrado é menor do que você digitou");
            }
            System.out.print("Digite o número novamente: ");
            userNumber = sc.nextInt();
        }
        System.out.println("Parabéns! Você digitou o número correto");
        sc.close();
    }
}
