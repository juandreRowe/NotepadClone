/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import models.CustomFile;
import views.View;

/**
 *
 * @author juandre
 */
public class NotepadController {
    private final View view;
    private final CustomFile model;
    private final JFileChooser fc;
    
    
    public NotepadController(View view, CustomFile model){
        this.view = view;
        this.model = model;
        this.view.saveListener(new SaveListener());
        this.view.openListener(new OpenListener());
        fc = new JFileChooser();
    }
    
    private class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int returnVal = fc.showSaveDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try{
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileWriter writer = new FileWriter(file.getAbsolutePath());
                    writer.write(view.getContent());
                    writer.close();
                    model.setName(file.getName());
                    model.setAbsolutePath(file.getAbsolutePath());
                    model.setContent(view.getContent());
                    System.out.println(model);
                }catch(IOException ex){
                    System.err.println(ex.getMessage());
                }
            }
        }
        
    }
    
    private class OpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int returnVal = fc.showOpenDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                model.setName(file.getName());
                model.setAbsolutePath(file.getAbsolutePath());
                //read content
                try{
                    model.setContent(new String(Files.readAllBytes(Paths.get(model.getAbsolutePath()))));
                    view.setContent(model.getContent());
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
        }
        
    }
    
}
