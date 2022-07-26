import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Exercício 1
        LocalDate now = LocalDate.now();
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Informe a data de seu aniversário (dd/MM/yyyy): ");
        LocalDate birthDay = LocalDate.parse(sc.next(), formatter);
        int month = Period.between(now, birthDay).getDays();
        int days = Period.between(now, birthDay).getDays();
        System.out.println("Faltam " + month + " meses e " + days + " dias para seu aniversario");

        // Exercício 2
        System.out.println("Informe duas datas no padrão (dd/MM/yyyy)");
        System.out.print("Data 1: ");
        LocalDate date1 = LocalDate.parse(sc.next(), formatter);
        System.out.print("Data 2: ");
        LocalDate date2 = LocalDate.parse(sc.next(), formatter);
        int years = Period.between(date1, date2).getYears();
        int month1 = Period.between(date1, date2).getDays();
        int days1 = Period.between(date1, date2).getDays();
        System.out.println("Diferenca em anos: " + years);
        System.out.println("Diferenca em meses: " + month1);
        System.out.println("Diferenca em dias: " + days1);

        // Exercício 3
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.plusDays(15).plusHours(10).getDayOfWeek());
        System.out.println(date.plusDays(15).plusHours(10).getDayOfYear());

        // Exercício 4
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDate localDate = LocalDate.now(zoneId);
        LocalDate showDate = LocalDate.of(2024, 9, 14);
        LocalTime localTime = LocalTime.now(zoneId);
        LocalTime showTime = LocalTime.of(18, 30);

        int anos = Period.between(localDate, showDate).getYears();
        int meses = Period.between(localDate, showDate).getMonths();
        int dias = Period.between(localDate, showDate).getDays();

        long horas = ChronoUnit.HOURS.between(localTime, showTime);
        long minutos = ChronoUnit.MINUTES.between(localTime, showTime) - (horas * 60);
        long segundos = ChronoUnit.SECONDS.between(localTime, showTime) - ((horas * 60 * 60) + (minutos * 60));

        System.out.println("Tempo até o dia do show");
        System.out.println(anos + " ANOS, "
                + meses + " MESES, "
                + dias + " DIAS, "
                + horas + " HORAS, "
                + minutos + " MINUTOS, "
                + segundos + " SEGUNDOS");
    }
}
