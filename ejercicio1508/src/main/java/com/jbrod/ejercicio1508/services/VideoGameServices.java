
package com.jbrod.ejercicio1508.services;

import com.jbrod.ejercicio1508.models.VideoGame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class VideoGameServices {

    private List<VideoGame> videoGames; 
    private final String filePath; 
    
    public VideoGameServices(String filePath){
        //Para que funcione en todos los sistemas operativos
        this.filePath = filePath + File.separator+"list.jb";
        this.videoGames = new ArrayList<>();
        
        loadData();
    }
    
    private void saveInFile(){
        
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(this.videoGames);
            
        }catch(Exception e){
            System.out.println("No se pudo guardar la lista\n" + e.getMessage());
        }
    
    }
    private List<VideoGame> returnVideoGameList (Object object){
        if(!(object instanceof List<?>)){
            return null; 
        }
        final List<?> list = (List<?>)object; 
        //Como es una lista generica, debemos saber si están guardados objetos de tipo videogame
        for (Object item : list) {
            if(!(item instanceof VideoGame)) return null; 
        }
        return (List<VideoGame>) list; 
    }
    
    private void loadData(){
        final File file = new File(filePath);
        if(file.exists()){
            try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))){
                
                final Object object = inputStream.readObject();
                final List<VideoGame> list = returnVideoGameList(object);
                if(list == null){
                    System.out.println("No es una lista de videojuegos");
                    return; 
                }
               this.videoGames = list; // por esto videogames no puede ser final, porque puede apuntar a otra direccion 
                System.out.println("Se cargaron los datos correctamente");
                
            }catch(Exception e){
                System.out.println("Hubo un error al cargar el archivo\n " + e.getMessage());
            }
        }
    }
}
