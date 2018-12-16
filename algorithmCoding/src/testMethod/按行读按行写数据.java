package testMethod;

import java.io.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-12-16 20:38
 **/
public class 按行读按行写数据 {

    public static void main(String[] args) {
        readAndWriteData("C:\\Users\\Frank_ni\\Desktop\\Final3g.csv","C:\\Users\\Frank_ni\\Desktop\\newData.csv",10000000-0.001,10000000+0.001);
    }

    public static void readAndWriteData(String readPath,String writePath,double min,double max){
        try (
            FileReader reader = new FileReader(readPath);
            BufferedReader br = new BufferedReader(reader);
            FileWriter writer = new FileWriter(writePath);
            BufferedWriter bw = new BufferedWriter(writer)
        ){

            String str;
            while((str = br.readLine()) != null) {
                double data = Double.valueOf(str);
                if(data <= max && data >= min){
                    bw.write(str+"\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
