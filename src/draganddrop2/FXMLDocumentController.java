/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draganddrop2;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import static javafx.scene.Cursor.cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private ImageView Imagen1;
    @FXML
    private ImageView Imagen2;
    @FXML
    private ImageView Imagen3;
    @FXML
    private AnchorPane AnchorPane;
    private int mousePosx = 0;
    private int mousePosy = 0;
    int cont = 0;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("/Recursos/TabAmarillo.jpg");
        Imagen1.setImage(image);
        
    Imagen1.setOnDragDetected((MouseEvent event2) -> {
        Dragboard db = Imagen1.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(Imagen1.getImage());
        db.setContent(content);
        event2.consume();
    });

    Imagen1.setOnDragOver(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            if (event.getGestureSource() != Imagen1 && event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            event.consume();  

             }
    });
   
    Imagen1.setOnDragDone(new EventHandler<DragEvent>() {
        
        public void handle(DragEvent event) {
            cont = 1;
            Dragboard db = event.getDragboard();
           if (db.hasImage()) {
                Imagen2.setImage(db.getImage());
                Imagen1.setImage(null);
            }
             event.consume(); 
        }
    });  
    /*
    Imagen3.setOnDragDone(new EventHandler<DragEvent>() {
        
        public void handle(DragEvent event) {
            
            Dragboard db = event.getDragboard();
           if (db.hasImage()) {
                Imagen3.setImage(db.getImage());
                Imagen1.setImage(null);
            }
             event.consume(); 
        }
    });  
    
    */
    Imagen3.setOnDragEntered(new EventHandler<DragEvent>(){
            @Override
            
            public void handle(DragEvent event) {
                while(true){
                    if(cont == 1){
                        Dragboard db = event.getDragboard();
                        Imagen3.setImage(db.getImage());
                    }
                }
            }
   
    });

    
}
}
