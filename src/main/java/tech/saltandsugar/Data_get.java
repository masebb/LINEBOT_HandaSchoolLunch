package tech.saltandsugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Data_get {
    /**
     * @return Array Date型で渡されたデータを「年」「月」「日」に分解して配列で返します
     * @pram date
     */
    public static String[] DatetoArray(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/d");
        simpleDateFormat.setLenient(false);//厳密化
        String[] Array_date = simpleDateFormat.format(date).split("/");
        Array_date[1] = Array_date[1].replace("0", "");

        return Array_date;
    }
    /**
     * @return ArrayList データをCSVファイルから取得してArrayList<String[]>(2次元配列)で返す
     * @param nowDate_Array ファイル名の推測に利用します(DatetoArrayメゾットを使ってDateから生成してください)
     */
    public static ArrayList<String[]> load_data(String[] nowDate_Array){
        //TODO ナンセンス?(とりあえず回避)
        String dir_File;
        System.out.println(nowDate_Array[1].length());
        if(nowDate_Array[1].length()==1) {
            dir_File = "./data/kyushokumenu/kyushoku_20200" + nowDate_Array[1] + ".csv/";
        }else{
            dir_File = "./data/kyushokumenu/kyushoku_2020" + nowDate_Array[1] + ".csv/";
        }
        try {
            System.out.println("//ファイル読み込み開始//");
            //ファイル読み込み
            BufferedReader buffReader = new BufferedReader(
                    new FileReader(dir_File)
            );
            String tmp_line;
            ArrayList<String[]> lineList = new ArrayList<>();
            while((tmp_line = buffReader.readLine()) != null){
                lineList.add(tmp_line.split(","));
            }
            System.out.println("//ファイル読み込み終了//");
            //読み込み終了(ArrayListに格納済み)
            buffReader.close();
            return lineList;
        } catch (IOException e) {
            System.out.print("ファイルが見つかりませんでした");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @param nowDate_Array ファイル名の推測に利用します(DatetoArrayメゾットを使ってDateから生成してください)
     * @param kyusyoku_list CSVから出た2次元配列(ArrayList<String[]>)を入力します
     *
     * @return String[] 入力されたDate型の中の年,月,日全て一致している1行を返します
     * */
    public static String[] data_search(String[] nowDate_Array, ArrayList<String[]> kyusyoku_list){
        //TODO なんかアルゴリズムとかやってみたいよね
        //removeIfメゾット作ったやつ国民栄誉賞
        ArrayList<String[]> tmp_kyusyoku_list = (ArrayList<String[]>) kyusyoku_list.clone();
        //年
        tmp_kyusyoku_list.removeIf(data-> (!data[1].equals(nowDate_Array[0])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }
        //月
        tmp_kyusyoku_list.removeIf(data-> (!data[2].equals(nowDate_Array[1])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }
        //日
        tmp_kyusyoku_list.removeIf(data-> (!data[3].equals(nowDate_Array[2])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }

        /*
        最終処理
         */
        //必ず一列でしか結果を出さないため(.get(0)以外はできないように)
        if(!(tmp_kyusyoku_list.size() > 1)) {
            return tmp_kyusyoku_list.get(0);
        }else{
            return null;
        }
    }
}
