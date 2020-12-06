package tech.saltandsugar;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    /**
     * @return Array Date型で渡されたデータを「年」「月」「日」に分解して配列で返します
     * @pram date
     */
    public static String[] toArray(@NonNull Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/M/d");
        simpleDateFormat.setLenient(false);//厳密化
        String[] Array_date = simpleDateFormat.format(date).split("/");
        return Array_date;
    }

}
