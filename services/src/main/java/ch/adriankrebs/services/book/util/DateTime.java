package ch.adriankrebs.services.book.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * Created by Adrian on 8/5/2016.
 */
public class DateTime {


    public static void main(String[] args) {

        // without timezones
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        // just a private constructor so new LocalDate() is no allowed-> just static methods


        // IMMUTABLE!

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date); // 2014-01-20
        date = date.plusDays(2);
        System.out.println(date); // 2014-01-22
        date = date.plusWeeks(1);

        System.out.println(date); // 2014-01-29
        date = date.plusMonths(1);
        System.out.println(date); // 2014-02-28
        date = date.plusYears(5);
        System.out.println(date); // 2019-02-28


        // Formatting

        LocalDate date123 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date
                .format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));


        DateTimeFormatter shortDateTime =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        shortDateTime =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(shortDateTime.format(dateTime)); // 1/20/20
        System.out.println(shortDateTime.format(date)); // 1/20/20
      //  System.out.println(
//                shortDateTime.format(time)); // UnsupportedTemporalTypeException

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

        DateTimeFormatter f12313 = DateTimeFormatter.ofPattern("MM dd yyyy");
//        LocalDate date12321 = LocalDate.parse("01 02 2015", f);
//        LocalTime time123123 = LocalTime.parse("11:22");
//        System.out.println(date12321); // 2015-01-02
//        System.out.println(time123123); // 11:22


        LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT); // only time
        DateTimeFormatter f3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // time and date
        System.out.println(d.format(f2));

        // Period does not allow chaining. Only the last Period method called counts, so only
        //the two years are subtracted.


        LocalDate dateTest = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        // dateTest.plusHours(2); // doesnt work sincce date has no time

//        Period is used to manipulate dates in terms of days, months, and years,
// while Duration is used to manipulate dates in terms of hours, minutes, and seconds.

//        Durations and periods differ in their treatment of daylight savings time when added to ZonedDateTime.
// A Duration will add an exact number of seconds, thus a duration of one day is always exactly 24 hours.
// By contrast, a Period will add a conceptual day, trying to maintain the local time.

        LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        zonedDateTime = zonedDateTime.plus(Duration.ofDays(1));
        System.out.println(zonedDateTime);

        zonedDateTime = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        zonedDateTime = zonedDateTime.plus(Period.ofDays(1));
        System.out.println(zonedDateTime);


        //adjustInto
        // strategy pattern
        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));


        java.time.LocalDate dt = java.time.LocalDate.parse("2015-01-01").minusMonths(1).minusDays(1).plusYears(1);
        System.out.println(dt);
//        System.out.println(LocalDate.of(2015, Month.JANUARY, 01).format(DateTimeFormatter.ISO_DATE_TIME));

        //Note that LocalDateTime class does not contain Zone information but ISO_ZONED_DATE_TIME requires it. Thus, it will throw the following exception:

//        Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds



        /*
Adjusters are a key tool for modifying temporal objects. They exist to externalize the process of adjustment, permitting different approaches, as per the strategy design pattern.
 Examples might be an adjuster that sets the date avoiding weekends, or one that sets the date to the last day of the month.
There are two equivalent ways of using a TemporalAdjuster. The first is to invoke the method on the interface directly. The second is to use Temporal.with(TemporalAdjuster):
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisAdjuster.adjustInto(temporal);
   temporal = temporal.with(thisAdjuster);


         */


        //ChronoUnit to show difference
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate datum = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two)); // 1


        LocalDate daylightDate = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime gemmeTime = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime gemmeDate = ZonedDateTime.of(daylightDate, gemmeTime, zone);
        System.out.println(gemmeDate); // 2016–11–06T01:30–04:00[US/Eastern]
        gemmeDate = gemmeDate.plusHours(1);
        System.out.println(gemmeDate); // 2016–11–06T01:30–05:00[US/Eastern]
        gemmeDate = gemmeDate.plusHours(1);
        System.out.println(gemmeDate); // 2016–11–06T02:30–05:00[US/Eastern]


        System.out.println(Locale.GERMAN); // de
        System.out.println(Locale.GERMANY); // de_DE



        Instant start = Instant.parse("2015-06-25T16:13:30.00z");
        start.plus(10, ChronoUnit.HOURS);
        System.out.println(start);

        Duration timeToCook = Duration.ofHours(1);
        Instant readyTime = start.plus(timeToCook);
        System.out.println(readyTime);

        LocalDateTime ltd = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));
        System.out.println(ltd);


        Duration dura = Duration.ofMillis(1100);
        System.out.println(dura); // PT1.1S
        dura = Duration.ofSeconds(61);
        System.out.println(dura);




        LocalDateTime lat = LocalDateTime.of(2017, 12, 02, 6, 0, 0);
        LocalDateTime nyt = LocalDateTime.of(2017, 12, 02, 9, 0, 0);

        Duration betweenNyAndLa = Duration.between(nyt, lat);
        System.out.println("LOOL: "+betweenNyAndLa);



    }


}
