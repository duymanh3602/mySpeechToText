package com.example.myspeechtotext;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;

public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private ToggleButton toggle;
    @FXML
    private ImageView microphone;

    public void initialize() throws FileNotFoundException {
        textArea.setWrapText(true);
        textArea.setEditable(false);
        InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\img\\voice_off.png");
        Image image = new Image(stream,80,80,false,true);
        microphone.setImage(image);
    }

    public void getVoice(MouseEvent event) throws FileNotFoundException {
        if (toggle.isSelected()) {
            textArea.setText("Clicked!");
            InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\img\\voice_on.png");
            Image image = new Image(stream,80,80,false,true);
            microphone.setImage(image);

        } else {
            textArea.setText("UnClicked!");
            InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\img\\voice_off.png");
            Image image = new Image(stream,80,80,false,true);
            microphone.setImage(image);
        }
    }
    public void copyToClipboard(MouseEvent event) {
        String text = textArea.getText();
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
    }
    public void getAudio(MouseEvent event) {
        recordVoice.recordMyVoice();
        String temp = speechToText.voiceToText();
        textArea.setText(speechToText.makeTrueForm(temp));
    }

}