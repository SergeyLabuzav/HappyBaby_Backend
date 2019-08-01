package by.minsk.ussr.auth.service.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public final class DateUtil {
    private static final String DATE_PATTERN = "^(19[6-9][0-9]|20[0-9][0-9])-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])$"; // yyyy-mm-dd
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    private DateUtil () { }

    public static Instant stringToInstant(String formattedDate, String pattern) {
        if (isInvalid(formattedDate)) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);

        return parsedDate
            .atStartOfDay()
            .toInstant(ZoneOffset.UTC);
    }

    private static boolean isInvalid(String formattedDate) {
        return !pattern
            .matcher(formattedDate)
            .find();
    }
}
