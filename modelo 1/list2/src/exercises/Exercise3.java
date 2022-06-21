package exercises;

import java.util.*;

public class Exercise3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String name = "";
        double height = 0.0;
        int age = 0;
        double weight = 0.0;
        int quantityPlayers = 0;
        double heightPlayer = 0.0;
        int oldPlayer = 0;
        double weightPlayer = 0.0;
        double averageHeightPlayers = 0.0;
        System.out.println("Digite informações sobre jogadores de basquete");
        while (!name.equals("SAIR")){
            System.out.print("Nome: ");
            name = sc.nextLine().toUpperCase();
            if (name.equals("SAIR")){
                break;
            } else {
                quantityPlayers++;
            }
            System.out.print("Altura: ");
            height = sc.nextDouble();
            sc.nextLine();
            averageHeightPlayers += height;
            if (height > heightPlayer){
                heightPlayer = height;
            }
            System.out.print("Idade: ");
            age = sc.nextInt();
            sc.nextLine();
            if (age > oldPlayer){
                oldPlayer = age;
            }
            System.out.print("Peso: ");
            weight = sc.nextDouble();
            sc.nextLine();
            if (weight > weightPlayer){
                weightPlayer = weight;
            }
        }
        averageHeightPlayers /= quantityPlayers;
        System.out.printf("Quantidade de jogadores cadastrados: %d\n", quantityPlayers);
        System.out.printf("Altura do maior jogador: %.2f\n", heightPlayer);
        System.out.printf("Jogador mais velho: %d anos\n", oldPlayer);
        System.out.printf("Jogador mais pesado: %.2fKG\n", weightPlayer);
        System.out.printf("Média das alturas dos jogadores: %.2f\n", averageHeightPlayers);
        sc.close();
    }
}
