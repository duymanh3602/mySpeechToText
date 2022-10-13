package com.example.myspeechtotext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import javafx.stage.FileChooser;

public class speechToText {
    public static String voiceToText(File file) {
        IamAuthenticator authenticator = new IamAuthenticator("4SANb7kQZ3Cdhte07CFds2qCMGnRlM902VlcOi1kleO8");
        SpeechToText speechToText = new SpeechToText(authenticator);
        speechToText.setServiceUrl("https://api.au-syd.speech-to-text.watson.cloud.ibm.com/instances/becc0e4d-12c7-4910-9b62-d1d136b97c79");

        RecognizeOptions recognizeOptions = null;
        try {
            recognizeOptions = new RecognizeOptions.Builder()
                    .audio(new FileInputStream("test.mp3"))
                    .contentType("audio/mp3")
                    .build();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        SpeechRecognitionResults speechRecognitionResults =
                speechToText.recognize(recognizeOptions).execute().getResult();
        //System.out.println(speechRecognitionResults);
        String results = speechRecognitionResults.toString();
        return results;
    }

    public static String makeTrueForm(String s) {
        int index = s.lastIndexOf("transcript");
        int index2 = s.indexOf("\"",index+16);
        String res = s.substring(index+14,index2);
        return res;
    }
}

