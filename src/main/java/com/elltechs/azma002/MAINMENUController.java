/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elltechs.azma002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;

/**
 * FXML Controller class
 *
 * @author Soheil
 */
public class MAINMENUController implements Initializable {

    @FXML
    private ImageView user_guide_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userGuidHoverAnim.start();
        // TODO
    }

    @FXML
    private void user_guide_tpress(TouchEvent event) {

        System.out.println("BUTTON CLICK");
    }

    @FXML
    private void user_guide_tmove(TouchEvent event) {

    }


    boolean userGiudEnter = false;
    
    @FXML
    private void user_guide_mexit(MouseEvent event) {
        userGiudEnter = false;
        
        
    }

    @FXML
    private void user_guide_menter(MouseEvent event) {
        userGiudEnter = true;
        
        
        
    }

    private int frameCnt = 0;
    private String header = "userGiuld_animation_AME/Layer9_006_USERGUILD";
    private String ender = ".png";

    @FXML
    private void user_guide_mclick(MouseEvent event) {

    }

     Thread userGuidHoverAnim = new Thread() {
         @Override
        public void run() {
            while(true){
                try {
                     if (userGiudEnter == true && frameCnt< 60)
                     {
                         Platform.runLater(() -> {
                         frameCnt++;
                         String frameCntStr = String.format("%02d", frameCnt);
                         user_guide_btn.setImage(new Image(getClass().getResource(header + frameCntStr + ender).toString()));
                    });
                    }
                     else if (userGiudEnter == false && frameCnt> 0){
                         Platform.runLater(() -> {
                         frameCnt--;
                         String frameCntStr = String.format("%02d", frameCnt);
                         user_guide_btn.setImage(new Image(getClass().getResource(header + frameCntStr + ender).toString()));
                    }); 
                     }
                    
                    Thread.sleep(1000 / 120);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                }
        };
     };
    
}
