package tech.saltandsugar.GetData;

import lombok.Getter;
import lombok.NonNull;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TodayKondate extends Kondate{
    @Getter
    private HashMap<String, String> dayKondate;

    /**
     * 指定された日付の献立を返す(該当データがない場合null)
     * @param localDate 検索日付
     * @return 配列番号 : 0固定
     * */
    @Override
    ArrayList<HashMap<String, String>> search(@NonNull LocalDate localDate){
        CSV_FILE_LOCATION = Paths.get(DATA_FOLDER_PATH + "KondateData/" + "kyushoku_" + localDate.getYear() + String.format("%02d", localDate.getMonth().getValue()) + ".csv");
        data = new LoadCSV(CSV_FILE_LOCATION);

        final List<String[]> targetDayLine = data.doSearchLine(4,String.valueOf(localDate.getDayOfMonth()));

        /*給食がない場合は日付のみがCSVデータとしてある*/
        if(targetDayLine.get(0).length > 5){
            ArrayList<HashMap<String, String>> result = new ArrayList<>();
            String[] CSV_header = data.getDataCSV().get(0);
            result.add(new HashMap<>());
            /*主食*/
            result.get(0).put(CSV_header[5], targetDayLine.get(0)[4]);
            /*献立名1*/
            result.get(0).put(CSV_header[6], targetDayLine.get(0)[5]);
            /*献立名2*/
            result.get(0).put(CSV_header[7], targetDayLine.get(0)[6]);
            /*献立名3*/
            result.get(0).put(CSV_header[8], targetDayLine.get(0)[7]);
            /*献立名4*/
            result.get(0).put(CSV_header[9], targetDayLine.get(0)[8]);
            /*献立名5*/
            result.get(0).put(CSV_header[10], targetDayLine.get(0)[9]);
            /*献立名6*/
            result.get(0).put(CSV_header[11], targetDayLine.get(0)[10]);
            /*飲み物*/
            result.get(0).put(CSV_header[12], targetDayLine.get(0)[11]);
            /*カロリー(小学校)*/
            result.get(0).put(CSV_header[13], targetDayLine.get(0)[12]);
            /*カロリー(中学校)*/
            result.get(0).put(CSV_header[14], targetDayLine.get(0)[13]);

            return result;
        }
        /*該当する日付のデータがなかった*/
        return null;
    }

    @Override
    ArrayList<HashMap<String, ?>> search(LocalDate localDate, SchoolClassType schoolClassType) {
        throw new IllegalArgumentException("schoolClassTypeの指定は不要");
    }

    /**
     *
     */
    @Override
    void doSearch() {
        this.dayKondate = search(LocalDate.now()).get(0);
    }
}
