package exercises;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("1: Rio Grande do Sul \n" +
                "2: Santa Catarina \n" +
                "3: São Paulo \n");
        System.out.print("Digite o número do seu estado de escolha: ");
        int state = sc.nextInt();
        sc.nextLine();
        switch (state){
            case 1:
                System.out.printf("1: Igrejinha \n" +
                        "2: Dois Irmãos \n");
                System.out.printf("Digite o número da cidade de sua escolha: ");
                int city = sc.nextInt();
                sc.nextLine();
                if(city == 1){
                    System.out.println("População estimada: 37.754");
                    System.out.println("Principal festa: Oktoberfest de Igrejinha");
                    System.out.println("IDH: 0,721");
                } else if (city == 2){
                    System.out.println("População estimada: 33.547");
                    System.out.println("Principal festa: Kerb de São Miguel");
                    System.out.println("IDH: 0,743");
                }
                break;
            case 2:
                System.out.printf("1: Blumenau \n" +
                        "2: Florianópolis \n");
                System.out.printf("Digite o número da cidade de sua escolha: ");
                city = sc.nextInt();
                sc.nextLine();
                if(city == 1){
                    System.out.println("População estimada: 366.418");
                    System.out.println("Principal festa: Oktoberfest de Blumenau");
                    System.out.println("IDH: 0,805");
                } else if (city == 2){
                    System.out.println("População estimada: 516.524");
                    System.out.println("Principal festa: Festa nacional do camarrão");
                    System.out.println("IDH: 0,847");
                }
                break;
            case 3:
                System.out.printf("1: São Paulo \n" +
                        "2: Barretos \n");
                System.out.printf("Digite o número da cidade de sua escolha: ");
                city = sc.nextInt();
                sc.nextLine();
                if(city == 1){
                    System.out.println("População estimada: 12.396.372");
                    System.out.println("Principal festa: Lollapalooza");
                    System.out.println("IDH: 0,805");
                } else if (city == 2){
                    System.out.println("População estimada: 123.546");
                    System.out.println("Principal festa: Festa do Peão de Barretos");
                    System.out.println("IDH: 0,789");
                }
                break;
            default:
                System.out.println("Digite uma opção válida: ");
                break;
        }
        sc.close();
    }
}
