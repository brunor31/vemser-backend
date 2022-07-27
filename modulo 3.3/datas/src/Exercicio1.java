import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        // Exercício 1
        LocalDate now = LocalDate.now();
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Informe sua data de aniversário? ");
        LocalDate dtAniversario = LocalDate.parse(sc.nextLine(), formatter);
        if (now.isAfter(dtAniversario.withYear(now.getYear()))) {
            Period periodo = Period.between(now, dtAniversario.withYear(now.plusYears(1).getYear()));
            System.out.println("FALTAM " + periodo.getDays() + " DIAS E " + periodo.getMonths() + " MESES PARA SEU ANIVERÁRIO!");
        } else {
            Period periodo = Period.between(now, dtAniversario.withYear(now.getYear()));
            System.out.println("FALTAM " + periodo.getDays() + " DIAS E " + periodo.getMonths() + " MESES PARA SEU ANIVERÁRIO!");
        }
    }
}

