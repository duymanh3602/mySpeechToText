package com.example.myspeechtotext;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private TextArea textArea;

    public void initialize() {
        textArea.setWrapText(true);
        textArea.setEditable(false);
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