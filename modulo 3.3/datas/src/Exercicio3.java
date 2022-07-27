import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Exercicio3 {

    public static void main(String[] args) {

        // Exercício 3
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime day = date.plusDays(15).plusHours(10);
        System.out.println(day.getDayOfWeek());
        System.out.println(day.getDayOfYear());
    }
}
