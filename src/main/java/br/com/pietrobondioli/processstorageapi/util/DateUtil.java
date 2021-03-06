package br.com.pietrobondioli.processstorageapi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static java.sql.Date convertStringToSqlDate(String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(stringDate);
        return new java.sql.Date(date.getTime());
    };

}
