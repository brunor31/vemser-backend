package exercises;

import java.util.*;

public class Exercise3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Double> heights = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<Double> weigths = new ArrayList<>();
        System.out.println("Digite informações de alguns jogadores de basquete");
        System.out.print("Nome: ");
        String name = sc.nextLine().toUpperCase();
        while(!name.equals("SAIR")) {
            names.add(name);
            System.out.print("Altura: ");
            double height = sc.nextDouble();
            sc.nextLine();
            heights.add(height);
            System.out.print("Idade: ");
            int age = sc.nextInt();
            sc.nextLine();
            ages.add(age);
            System.out.print("Peso: ");
            double weight = sc.nextDouble();
            sc.nextLine();
            weigths.add(weight);
            System.out.print("Nome: ");
            name = sc.nextLine().toUpperCase();
        }
        System.out.println("Quantidade de jogadores cadastrados: " + names.size());
        double heightPlayer = 0;
        double averageHeight = 0;
        for (int i=0; i<heights.size(); i++){
            averageHeight += heights.get(i);
            if (heights.get(i) > heightPlayer){
                heightPlayer = heights.get(i);
            }
        }
        System.out.printf("Altura do jogador mais alto: %.2f%n", heightPlayer);
        int agePlayer = 0;
        for (int i=0; i<ages.size(); i++){
            if (ages.get(i) > agePlayer){
                agePlayer = ages.get(i);
            }
        }
        int position = 0;
        for (int i=0; i<ages.size(); i++){
            if (agePlayer == ages.get(i)){
                position = ages.indexOf(ages.get(i));
            }
        }
        System.out.println("O jogador mais velho é: " + names.get(position));
        double weightPlayer = 0;
        for (int i=0; i<weigths.size(); i++){
            if (weigths.get(i) > weightPlayer){
                weightPlayer = weigths.get(i);
            }
        }
        for (int i=0; i<weigths.size(); i++){
            if (weightPlayer == weigths.get(i)){
                position = weigths.indexOf(weigths.get(i));
            }
        }
        System.out.println("O jogador mais pesado é: " + names.get(position));
        System.out.printf("Altura média dos jogadores: %.2f%n", (averageHeight / heights.size()));
        sc.close();
    }
}
