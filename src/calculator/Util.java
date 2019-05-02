package calculator;

import java.io.File;

public class Util {
    private Util(){}

    static String getPath(Class<?> clazz){
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName,"");
        path=path.replace(".",File.separator);
        String root = System.getProperty("user.dir");
        String rezultat = root+File.separator+"src"+File.separator+path;
        return rezultat;
    }

    static String getPath(){
        return getPath(Util.class);
    }

    static String getPath(String fileName){
        return getPath()+fileName;
    }
}
