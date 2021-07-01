package tech.saltandsugar.GetData;

import lombok.Getter;
import lombok.NonNull;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodayKondateAllergies extends Kondate{
    /*小学校*/
    @Getter
    private HashMap<String, ?> dayKondateAllergies_shou;
    /*中学校*/
    @Getter
    private HashMap<String, ?> dayKondateAllergies_chu;

    /**
     * @param localDate 検索を実行する日付
     * @param schoolClassType CSVファイルが別れているため
     * @return 検索結果(該当がなかった場合Null)
     */
    @Override
    ArrayList<HashMap<String, ?>> search(@NonNull LocalDate localDate, @NonNull SchoolClassType schoolClassType) {
        ArrayList<HashMap<String,?>> result = new ArrayList<>();
        result.add(new HashMap<>());
        if(schoolClassType.equals(SchoolClassType.SHOU)){
            CSV_FILE_LOCATION = Paths.get(DATA_FOLDER_PATH + "KondateAllergyData/" + "allergies_shou_" + localDate.getYear() + String.format("%02d", localDate.getMonth().getValue()) + ".csv");
            data = new LoadCSV(CSV_FILE_LOCATION);
            result.add(searchProcess(data));
            return result;

        }else if(schoolClassType.equals(SchoolClassType.CHU)){
            CSV_FILE_LOCATION = Paths.get(DATA_FOLDER_PATH + "KondateAllergyData/" + "allergies_chu_" + localDate.getYear() + String.format("%02d", localDate.getMonth().getValue()) + ".csv");
            data = new LoadCSV(CSV_FILE_LOCATION);
            result.add(searchProcess(data));
            return result;
        }
        return null;
    }

    /**
     * 検索を実行します
     */
    @Override
    void doSearch() {
        this.dayKondateAllergies_shou = search(LocalDate.now(),SchoolClassType.SHOU).get(0);
        this.dayKondateAllergies_chu = search(LocalDate.now(),SchoolClassType.CHU).get(0);
    }
    @Override
    ArrayList<HashMap<String, String>> search(LocalDate localDate) {
        throw new IllegalArgumentException("schoolClassTypeが未指定");
    }
    /**
     * 指定されたCSVからパースしてアレルギーデータを検索します
     */
    private HashMap<String, ?> searchProcess(@NonNull LoadCSV loadCSV){
        Map<Integer, String> kondateCSVHeader = loadCSV.getHeaderCSV();
        Map<String, List<List<String>>> map = new HashMap<>();
        for (Map.Entry<Integer, String> entry : loadCSV.getHeaderCSV().entrySet()) {
            if (entry.getKey() > 5) {
                map.put(entry.getValue(), new ArrayList<>());
                map.get(entry.getValue()).add(new ArrayList<>());
                map.get(entry.getValue()).add(new ArrayList<>());
            }
        }
        loadCSV.getDataCSV().forEach(line -> {
        String menuName = line[4];
        int columnNum = 0;
        for (String itemByLine : line) {
            columnNum++;
            if (5 < columnNum) {
                switch (itemByLine) {
                    /*該当のアレルギー対象食品を含む*/
                    case "1" -> map.get(kondateCSVHeader.get(columnNum)).get(0).add(menuName);
                    /*使用されている調味料に該当のアレルギー対象食品を含む*/
                    case "2" -> map.get(kondateCSVHeader.get(columnNum)).get(1).add(menuName);
                    /*"1"と"2"両方に該当のアレルギーが含まれる*/
                    case "3" -> {
                       map.get(kondateCSVHeader.get(columnNum)).get(0).add(menuName);
                       map.get(kondateCSVHeader.get(columnNum)).get(1).add(menuName);
                    }
                }
            }
        }

});
        return (HashMap<String, ?>) map;
    }
}
