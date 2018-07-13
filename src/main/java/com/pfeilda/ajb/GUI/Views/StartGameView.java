package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.Arrays;

public class StartGameView extends JFrame {
    public StartGameView() throws HeadlessException {
        super("Spielstart");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLayout(new FlowLayout());

        this.addAnalyseElements();
    }

    private void addAnalyseElements() {
        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();
        final AnalyseElement[] analyseElements = analyseElementFactory.getAll();

        Arrays.stream(analyseElements).forEach((AnalyseElement analyseElement) -> {

        });
    }
}
