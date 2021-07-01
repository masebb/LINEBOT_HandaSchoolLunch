package tech.saltandsugar.GetData;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LoadCSV {
    @Getter
    private Path CSV_FILE_LOCATION;
    @Getter
    private ArrayList<String[]> dataCSV;
    @Getter
    private Map<Integer, String> headerCSV;

    LoadCSV(Path path){
        CSV_FILE_LOCATION = path;
        dataCSV = CSV_toArrayList(path);
        headerCSV = extractionCSVHeader(dataCSV);
    }
    /**
     * @param rowIndex     検索する列番号(1~)
     * @param searchTarget 検索する文字列
     * @return 検索結果(数字配列)
     */
    public List<String[]> doSearchLine(@NonNull int rowIndex, @NonNull String searchTarget) {
        List<String[]> tmpLine = new ArrayList<>();
        for (String[] line : dataCSV) {
            if (line[rowIndex-1].equals(searchTarget)) {
                tmpLine.add(line);
            }
        }
        return tmpLine;
    }
    /**
     * CSV_toArrayList()で出したArrayList<String[]>からHashMapにしたCSVヘッダを吐く
     * Keyは1~n(ヘッダ項目数)まで
     * @param data ヘッダを抽出したい
     **/
    private static Map<Integer, String> extractionCSVHeader(@NonNull ArrayList<String[]> data) {
        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        for (String headerItem : data.get(0)) {
            i++;
            map.put(i, headerItem);
        }
        return map;
    }
    /**
     * @param CSV_FileLocation ArrayList<String[]>に変換するCSVファイルのパス
     */
    private static ArrayList<String[]> CSV_toArrayList(@NonNull Path CSV_FileLocation) {
        try {
            log.info(CSV_FileLocation + "を読み込みます");
            //ファイル読み込み
            BufferedReader buffReader = new BufferedReader(
                    new FileReader(CSV_FileLocation.toFile())
            );
            String tmp_line;
            ArrayList<String[]> arrayListCSV = new ArrayList<>();
            while ((tmp_line = buffReader.readLine()) != null) {
                arrayListCSV.add(tmp_line.split(","));
            }
            //読み込み終了(ArrayListに格納済み)
            buffReader.close();

            if(arrayListCSV.isEmpty()){
                log.error("正常にCSVファイルを読み込めなかったようなので、アプリケーションを終了します。 csvFileLocation : " + CSV_FileLocation.toString());
                System.exit(1);
            }
            return arrayListCSV;
            //[[データ1,データ2],[データ1,データ2],[データ1,データ2],[データ1,データ2,データ3]]みたいな感じにして返す

        } catch (FileNotFoundException e) {
            log.error(CSV_FileLocation + " : ファイルが見つかりませんでした", e);
            return null;
        } catch (IOException e) {
            log.error(null, e);
            return null;
        }
    }
}
