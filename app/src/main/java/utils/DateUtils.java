package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtils {


    public static List<String> daysOfMonth() {

        List<String> days = new ArrayList<>();

        days.add("Today");
        days.add("Tomorrow");
        days.add("Third Day");
        days.add("Fourth Day");
        days.add("Fifth Day");
        days.add("Sixth Day");
        days.add("Seventh Day");
        days.add("Eighth Day");
        days.add("Ninth Day");
        days.add("Tenth Day");

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        return days;

    }

}
