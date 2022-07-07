package exercises;

import java.util.Locale;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite suas 4 notas do semestre para obter a média");
        System.out.print("Nota 1: ");
        double note1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nota 2: ");
        double note2 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nota 3: ");
        double note3 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nota 4: ");
        double note4 = sc.nextDouble();
        sc.nextLine();
        double average = (note1+note2+note3+note4)/4;
        System.out.printf("Sua média é: %.2f%n", average);
        if(average > 5 && average < 7){
            System.out.println("Você está em exame");
        } else if(average >= 7){
            System.out.println("Você foi aprovado");
        } else {
            System.out.println("Você foi reprovado");
        }
        sc.close();
    }
}
