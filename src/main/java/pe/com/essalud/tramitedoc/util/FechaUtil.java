package pe.com.essalud.tramitedoc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {

    public static Date parseStringDateToDate(String stringDate, String formatDate) throws Exception {
        Date date = null;
        if (stringDate != null && !stringDate.equals(Constantes.CADENA_VACIA)
                && formatDate != null && !formatDate.equals(Constantes.CADENA_VACIA)) {
            date = new SimpleDateFormat(formatDate).parse(stringDate);
        }
        return date;
    }


}
