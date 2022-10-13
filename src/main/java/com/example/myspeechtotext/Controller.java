package com.example.myspeechtotext;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;

public class Controller {

    FileChooser fileChooser = new FileChooser();

    File file = null;
    @FXML
    private TextArea res;
    @FXML
    private ToggleButton toggle;
    @FXML
    private ImageView microphone;

    public void initialize() throws FileNotFoundException {
        res.setWrapText(true);
        res.setEditable(false);

    }

//    public void getVoice(MouseEvent event) throws FileNotFoundException {
//        if (toggle.isSelected()) {
//            recordVoice.recordMyVoice(10000);
//            String temp = speechToText.voiceToText();
//        } else {
//        }
//    }
    public void copyToClipboard(MouseEvent event) {
        String text = res.getText();
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
    }
//    public void getAudio(MouseEvent event) {
//        recordVoice.recordMyVoice(10000);
//        String temp = speechToText.voiceToText();
//        res.setText(speechToText.makeTrueForm(temp));
//    }

    public void getFile() throws InterruptedException {
        file = fileChooser.showOpenDialog(new Stage());
    }

    public void getRes() {
        System.out.println(file.getAbsoluteFile());
        if (file.isFile()) {
            String ans = speechToText.voiceToText(file);

            System.out.println("Getting...!");
            res.setText(speechToText.makeTrueForm(ans));
        } else {
            System.out.println("False to get File");
        }

    }

}