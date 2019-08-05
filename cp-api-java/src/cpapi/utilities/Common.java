package cpapi.utilities;

import com.ethlo.time.FastInternetDateTimeUtil;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;

public class Common {

    public static LocalDate DateAsLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("America/Costa_Rica")).toLocalDate();
    }

    public static LocalDateTime DateAsLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("America/Costa_Rica")).toLocalDateTime();
    }

    public static Date LocalDateAsDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.of("America/Costa_Rica")).toInstant());
    }

    public static Date LocalDateAsDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.of("America/Costa_Rica")).toInstant());
    }

    public static String decodeBase64(String text) {
        String result = "";
        try {
            if (text != null) {
                result = new String(Base64.getDecoder().decode(text.getBytes()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String encodeBase64(String text) {
        String result = "";
        try {
            if (text != null) {
                result = new String(Base64.getEncoder().encode(text.getBytes()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    private static String formatDecimal(BigDecimal valor, int digits) {
        String result = "";
        try {
            if (valor != null) {
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(digits);
                df.setMinimumFractionDigits(digits);
                df.setGroupingUsed(false);
                result = df.format(valor);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String formatDecimal(BigDecimal valor) {
        String result = "";
        try {
            if (valor != null) {
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);
                df.setGroupingUsed(true);
                result = df.format(valor);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String formatDoubleCurrency(String simbolo, Double valor) {
        return simbolo + " " + formatDecimal(BigDecimal.valueOf(valor));
    }

    public static String formatDecimalCurrency(String simbolo, BigDecimal valor) {
        return simbolo + " " + formatDecimal(valor);
    }

    public static Date getDate(GregorianCalendar cal) {
        Date result = null;
        if (cal != null) {
            try {
                XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
                result = xmlCalendar.toGregorianCalendar().getTime();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public static Date getDate() {
        return Date.from(Instant.now().atZone(ZoneId.of("America/Costa_Rica")).toInstant());
    }

    public static Date getDateFirstDay() {
        return LocalDateAsDate(DateAsLocalDate(getDate()).with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static Date getDateLastDay() {
        return LocalDateAsDate(DateAsLocalDate(getDate()).with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static Date getDateRFC3339(String dateString) {
        Date result;
        try {
            FastInternetDateTimeUtil itu = new FastInternetDateTimeUtil();
            OffsetDateTime date = itu.parseDateTime(dateString);
            result = Date.from(date.toInstant());
        } catch (Exception ex) {
            result = null;
            System.out.println("ERROR 1i >>> " + ex.getMessage());
        }
        if (result == null) {
            /* se hace un segundo intento para leer la fecha  */
            String dateStringSinT = dateString.replaceFirst("T", " ");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                result = sdf.parse(dateStringSinT);
            } catch (Exception ex) {
                System.out.println("ERROR 2i >>>" + ex.getMessage());
            }
        }
        return result;
    }

    public static String getDateRFC3339Str(Date fecha) {
        String result = "";
        try {
            if (fecha != null)
                result = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
                        .format(new Date());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String getDateStr(Date date) {
        String result = "";
        try {
            if (date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                result = sdf.format(date);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String getDateStr() {
        return getDateStr(LocalDateTime.now());
    }

    public static String getDateStr(LocalDateTime dt) {
        String result = "";
        try {
            if (dt != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                result = dtf.format(dt);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String getDateTimeStr() {
        return getDateTimeStr(LocalDateTime.now());
    }

    public static String getDateTimeStr(LocalDateTime dt) {
        String result = "";
        try {
            if (dt != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
                result = dtf.format(dt);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String getTimeStr() {
        return getTimeStr(LocalDateTime.now());
    }

    public static String getTimeStr(LocalDateTime dt) {
        String result = "";
        try {
            if (dt != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                result = dtf.format(dt);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
