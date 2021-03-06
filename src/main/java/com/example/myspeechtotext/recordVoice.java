package com.example.myspeechtotext;

import javax.sound.sampled.*;
import java.io.*;

public class recordVoice {

    static final long RECORD_TIME = 3000; 
    File wavFile = new File("RecordAudio.wav");
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;
    static AudioFormat format = new AudioFormat(16000, 16, 2, true, true);

    void start() {
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
            AudioInputStream ais = new AudioInputStream(line);
            System.out.println("Start recording...");
            AudioSystem.write(ais, fileType, wavFile);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }


    public static void recordMyVoice(int n) {
        final recordVoice recorder = new recordVoice();
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(n);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
        stopper.start();

        // start recording
        recorder.start();
    }
}
