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
     * @return ArrayList データをCSVファイルから取得してArrayList<String[]>(2次元配列)で返す
     */
    public static ArrayList<String[]> load_data(){
        //TODO ファイル名の変更を動的にしたい
        String dir_File = "./data/kyushoku_202008.csv/";
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
     * @param date 実行時の日付、時刻を入れる(年,月,日に分解します)
     * @param kyusyoku_list CSVから出た2次元配列(ArrayList<String[]>)を入力します
     *
     * @return String[] 入力されたDate型の中の年,月,日全て一致している1行を返します
     * */
    public static String[] data_search(Date date, ArrayList<String[]> kyusyoku_list){
        /*
        * 日付処理
        * */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/d");
        simpleDateFormat.setLenient(false);//厳密化
        String[] Array_date =simpleDateFormat.format(date).split("/");
        Array_date[1] = Array_date[1].replace("0","");
        System.out.println("日付配列"+Arrays.toString(Array_date));
        /*
        * 天才的な検索アルゴリズム
        * */
        //removeIfメゾット作ったやつ国民栄誉賞
        ArrayList<String[]> tmp_kyusyoku_list = (ArrayList<String[]>) kyusyoku_list.clone();
        //年
        tmp_kyusyoku_list.removeIf(data-> (!data[1].equals(Array_date[0])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }
        //月
        tmp_kyusyoku_list.removeIf(data-> (!data[2].equals(Array_date[1])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }
        //日
        tmp_kyusyoku_list.removeIf(data-> (!data[3].equals(Array_date[2])));
        if(tmp_kyusyoku_list.size() == 0){
            return null;
        }

        /*
        最終処理
         */
        //必ず一列でしか結果を出さないため(.get(0)以外はできないように)
        System.out.println(Arrays.deepToString(tmp_kyusyoku_list.toArray()));
        if(!(tmp_kyusyoku_list.size() > 1)) {
            return tmp_kyusyoku_list.get(0);
        }else{
            return null;
        }
    }
}
