
package com.jbrod.ejercicio1508.utils;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author jorge
 */
public class FileChooser {

    private final static JFileChooser filechooser = new JFileChooser();
    
    //Es como un constructor
    static{
    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    filechooser.setDialogTitle("Seleccione una carpeta");
    }
    
    public static String selectPath(){
        final int result = filechooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            final File folder = filechooser.getSelectedFile(); 
            final String path = folder.getAbsolutePath(); 
            System.out.println("Se selecciono la carpeta: " + path);
            return path; 
        }else{
            System.out.println("Accion cancelada");
            return null; 
        }
    }
}
