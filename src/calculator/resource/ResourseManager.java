package calculator.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourseManager {

    INSTANCE;
    ResourseManager(){setLocale(Locale.getDefault());}

    public ResourceBundle resourceBundle;

    public void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle("calculator.resource.text",locale);

    }

    public String get(String key){
        return  resourceBundle.getString(key);
    }
}
