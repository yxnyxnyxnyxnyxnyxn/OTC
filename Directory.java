import java.io.*;
import java.util.*;

class Shell {
    private String finalPath = "/";
    private Vector<String> directories = new Vector<String>();
    Shell cd(final String path){
        finalPath = "";
        if (path == "/"){
            finalPath = "/";
        }
        else {
            for (String s : path.split("/"))
                 directories.add(s);
            int i = 0;
           while (i <directories.size()){
                
                if (directories.get(i).equals("..")){
                    directories.remove(i);
                    directories.remove(i-1);
                }
                else if (directories.get(i).equals(".")){
                    directories.remove(i);
                }
                i++;
            }
            if (directories.isEmpty()){
                finalPath = "/";
            }else{
                
                for (int j = 0 ; j <directories.size();j++){
                    while (directories.get(j).equals("")){
                        finalPath = "";
                        j++;
                    }
                    
                    finalPath += "/";
                    finalPath += directories.get(j);

                }
            }
        }
       
        return this;
    }
    
    public String path(){
        return finalPath;
    }
}

public class Directory {
    public static void main(String[] args) {
        final Shell shell = new Shell();
        assert shell.path().equals("/");
        
        shell.cd("/");
        assert shell.path().equals("/");
        

        shell.cd("usr/..");
        assert shell.path().equals("/");
       

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");
        
        
        shell.cd("..");
        assert shell.path().equals("/usr");
       
        shell.cd("//lib///");
        assert shell.path().equals("/lib");
        
    }
} 

