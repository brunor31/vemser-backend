import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Exercicio4 {

    public static void main(String[] args) {

        // Exercício 4
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDate localDate = LocalDate.now(zoneId);
        LocalDate showDate = LocalDate.of(2024, 9, 14);
        LocalTime localTime = LocalTime.now(zoneId);
        LocalTime showTime = LocalTime.of(18, 30);

        Period periodo = Period.between(localDate, showDate);
        int years = periodo.getYears();
        int months = periodo.getMonths();
        int days = periodo.getDays();

        long hours = ChronoUnit.HOURS.between(localTime, showTime) ;
        long minutes = ChronoUnit.MINUTES.between(localTime, showTime) - (hours * 60);
        long seconds = ChronoUnit.SECONDS.between(localTime, showTime) - ((hours * 60 * 60) + (minutes * 60));

        System.out.println("Tempo até o Show");
        System.out.println(years + " ANOS, "
                + months + " MESES, "
                + days + " DIAS, "
                + hours + " HORAS, "
                + minutes + " MINUTOS, "
                + seconds + " SEGUNDOS");
    }
}
