package exercises;

import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número total de eleitores: ");
        int totalVoters = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o número de votos em branco: ");
        int blankVote = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o número de votos nulos: ");
        int nullVote = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o número de votos válidos: ");
        int validVotes = sc.nextInt();
        sc.nextLine();
        System.out.printf("O percentual de votos brancos é %.2f%%\n", (double) blankVote / totalVoters * 100);
        System.out.printf("O percentual de votos nulos é %.2f%%\n", (double) nullVote / totalVoters * 100);
        System.out.printf("O percentual de votos válidos é %.2f%%\n", (double) validVotes / totalVoters * 100);
        sc.close();
    }
}
