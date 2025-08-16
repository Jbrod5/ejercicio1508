
package com.jbrod.ejercicio1508.models;

import java.io.Serializable;
import java.util.UUID;
import jdk.jfr.SettingDefinition;
import lombok.Getter; 
import lombok.Setter; 



/**
 *
 * @author jorge
 */

@Setter
@Getter
@EqualsHashCode(of = "id")
public class VideoGame implements Serializable{
    
    private final UUID id; 
    private String title; 
    private int hoursPlayed; 
    private boolean completed; 

    public  VideoGame(String title, int hoursPlayed){
        this.id = UUID.randomUUID();
        this.title = title; 
        this.hoursPlayed = hoursPlayed; 
        
    }
    
    @Override
    public String toString(){
        return this.title + " " + this.id + " " + this.completed; 
    } 

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
    
    
    
    
}
