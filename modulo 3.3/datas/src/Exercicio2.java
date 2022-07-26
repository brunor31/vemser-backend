import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Exercício 2
        System.out.println("Informe duas datas no padrão (dd/MM/yyyy)");
        System.out.print("Data 1: ");
        LocalDate date1 = LocalDate.parse(sc.next(), formatter);
        System.out.print("Data 2: ");
        LocalDate date2 = LocalDate.parse(sc.next(), formatter);
        if (date1.isBefore(date2)){
            long diffDias = ChronoUnit.DAYS.between(date1,date2);
            long diffMes = ChronoUnit.MONTHS.between(date1,date2);
            long diffAno = ChronoUnit.YEARS.between(date1,date2);
            System.out.println("DIAS: "+diffDias);
            System.out.println("MÊs: "+diffMes);
            System.out.println("ANO: "+diffAno);
        }else {
            long diffDias = ChronoUnit.DAYS.between(date2,date1);
            long diffMes = ChronoUnit.MONTHS.between(date2,date1);
            long diffAno = ChronoUnit.YEARS.between(date2,date1);
            System.out.println("DIAS: "+diffDias);
            System.out.println("MÊs: "+diffMes);
            System.out.println("ANO: "+diffAno);
        }
    }
}
