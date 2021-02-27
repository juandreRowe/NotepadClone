/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

import controllers.NotepadController;
import models.CustomFile;
import views.View;

/**
 *
 * @author juandre
 */
public class JavaApplication27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        View view = new View();
        CustomFile model = new CustomFile();
        NotepadController notepad = new NotepadController(view, model);
        view.setVisible(true);
    }
    
}
