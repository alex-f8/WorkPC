package IO;

import java.io.*;

public class TestIO {
    public static void main(String ...args) throws IOException {
        String path = "C:\\LAB\\java_code\\PROJECTS\\workPC\\src\\main\\resources\\";
        String filename1 = "test.txt";
        String filename2 = "test2.txt";
        File file1 = new File(path, filename1);
        file1.createNewFile();
        int i;
        //File file2 = new File(path, filename2);
        try(FileWriter fw = new FileWriter(path + filename1, true);
                                                    FileReader fr = new FileReader(file1)){
            fw.write("Hello World!");
            fw.append('/');
            fw.close();
            while( (i = fr.read()) != - 1){
                System.out.print((char)i);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(FileReader fr = new FileReader(file1); FileWriter fw = new FileWriter(file1, true)){

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n\n tram tam tam, tram tam tam\n");
            bw.close();

            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
            br.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
