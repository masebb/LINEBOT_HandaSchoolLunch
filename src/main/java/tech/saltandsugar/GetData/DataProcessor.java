package tech.saltandsugar.GetData;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

@Slf4j
@Component
public class DataProcessor {
    /**
     * @return 変換したやつ
     * @param CSV_FileLocation ArrayListに変換するCSVファイルの場所を指定します(相対パス、絶対パス)
     */
    public ArrayList<String[]> CSV_toArrayList(@NonNull Path CSV_FileLocation) {
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
            return arrayListCSV;
            //[[データ1,データ2],[データ1,データ2],[データ1,データ2],[データ1,データ2,データ3]]みたいな感じにして返す

        } catch (FileNotFoundException e) {
            log.error(CSV_FileLocation + " : データが取得できませんでした", e);
            return null;
        } catch (IOException e) {
            log.error(null,e);
            return null;
        }
    }

    /**
     * @param data データ
     * @param rowIndex 検索する列番号(1~)
     * @param searchTarget 検索する文字列
     * @return 検索結果(配列の位置で返す)(見つからない場合-1)
     */

    public int doSearchLine(@NonNull ArrayList<String[]> data, int rowIndex , @NonNull String searchTarget){
        int i = -1;//行番号カウンター
        for (String[] line : data) {
            i++;
            if (line[rowIndex].equals(searchTarget)) {
                return i;//行番号を返す
            }
        }
        //該当行が見つからなかった場合(普通そんなことありえない)
        return -1;
    }
}