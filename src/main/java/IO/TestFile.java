package IO;


import java.io.*;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String strTmp;
        /*
                create directory c:\tmpDel
                create file: test.txt and write into "hello"
                show file infos
                delete file test.txt   => YES/NO
                delete directory tmpDel   => YES/NO
        */

        File createNewDir = new File("c:\\tmpDel");
        System.out.println(createNewDir.isDirectory()? "dir created" : "dir not created");
        createNewDir.mkdir();
        System.out.println(createNewDir.isDirectory()? "dir created" : "dir not created\n");
        System.out.println("createNewDer.getPath: " + createNewDir.getPath());
        System.out.println("createNewDer.getAbsolutePath: " + createNewDir.getAbsolutePath());

        //create temp directories for testting
        for(int i = 0; i < 2; i++)
            new File("c:\\tmpDel\\tmpDir"+System.nanoTime()).mkdir();

        File file = new File(createNewDir, "test1.txt" );
        System.out.println(file.exists() ? "File exist" : "File isn't exist");
        boolean newFile = file.createNewFile();
        System.out.println(file.exists() ? "File exist" : "File isn't exist");
        System.out.println();
        System.out.println("file.getName: " + file.getName() + " /lastModified(unix time): " + file.lastModified());
        System.out.println("file.path: " + file.getPath());
        System.out.println("file.getParent: " + file.getParent() + " /lastModified(unix time): " + createNewDir.lastModified());
        System.out.println("file.getParentFile: " + file.getParentFile() + " /lastModified(unix time): " + createNewDir.lastModified());
        System.out.println("object createNewDir is: " + (createNewDir.isDirectory() ? "DIRECTORY":"FILE") );
        System.out.println("object file is: " + (file.isFile() ? "FILE" : "DIRECTORY") );
        System.out.println("object file is: " + (file.isHidden() ? "HIDDEN" : "ISN'T HIDDEN") );
        System.out.println("file.hashCode: " + file.hashCode());
        System.out.println("file.length: " + file.length());
        System.out.println();


        FileWriter fw = new FileWriter(file, true);
        fw.write("hello");
        fw.append('\n');
        fw.close();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while( (strTmp = br.readLine()) != null )
            System.out.printf("%s ", strTmp);
        fr.close();
        br.close();

        System.out.println('\n');
        System.out.println("file.hashCode " + file.hashCode());
        System.out.println("file.length: " + file.length());

        System.out.println("\nSubDirs and files in current direcotry:");
        String[] listTxt = createNewDir.list();
        for(String  item : listTxt)
            System.out.println(item);

        System.out.println("\nSubDirs and files in current direcotry:");
        File[] listFiles = createNewDir.listFiles();
        for(File  item : listFiles){
            if(item.isDirectory())
                System.out.println("/" + item.getName());
            else if(item.isFile())
                System.out.println("-" + item.getName());
        }

        //delete
        Scanner scanner = new Scanner(System.in);
        System.out.print("Delete lab file: test.txt ? y/n ");
        String yesno = scanner.next();
        if(yesno.equals("y"))
            System.out.println("test1.txt " + (file.delete() ? "deleted" : "cann't delete"));
        yesno = null;
        boolean deleted;
        System.out.print("Remove directory tmpDel ? y/n");
        yesno = scanner.next();
        if(yesno.equals("y")){
            String[] listAllObj = createNewDir.list();
            for(String item : listAllObj){
                deleted = new File(createNewDir.getPath() + "\\" + item).delete();
                System.out.println(createNewDir.getPath() + "\\" + item + " -> " + ((deleted)? "deleted": "didnot delete"));
            }
            createNewDir.delete();
        }
        System.out.println("/tempDel - " + (createNewDir.exists() ? "exist" : "dont exists"));
    }
}

