package exercises;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome da cidade onde você reside: ");
        String city = sc.nextLine();
        System.out.print("Digite o nome do estado onde você reside: ");
        String state = sc.nextLine();
        System.out.printf("Olá, seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado do %s", name, age, city, state);
        sc.close();
    }
}

