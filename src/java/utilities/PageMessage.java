/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lucas Ernesto Kindinger
 */
public class PageMessage {
    private String title;
    private String type;
    private String text;
    
    
    public PageMessage(String type, String title, String text)
    {
        this.setTitle(title);
        this.setType(type);
        this.setText(text);
    }

    public PageMessage() {
        
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title.trim();
    }

    /**
     * @return the type
     */
    public String getType() {
        return type.trim();
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
       List<String> permitted = Arrays.asList("warning", "info", "danger", "success");
        
       this.type = permitted.contains(type) ? type : "info";
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text.trim();
    }
    
    
}
