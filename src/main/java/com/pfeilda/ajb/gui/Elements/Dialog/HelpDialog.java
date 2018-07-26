package com.pfeilda.ajb.gui.Elements.Dialog;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class HelpDialog extends JDialog {
    private final List<ImageIcon> imageIcons;
    private final JLabel currentLabel;
    private int index = 0;

    public HelpDialog() {
        this.setLayout(new BorderLayout());

        this.imageIcons = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            this.imageIcons.add(new ImageIcon(this.getClass().getResource("/Help/00" + i + ".jpeg")));
        }
        for (int i = 10; i < 17; i++) {
            this.imageIcons.add(new ImageIcon(this.getClass().getResource("/Help/0" + i + ".jpeg")));
        }

        this.currentLabel = new JLabel(this.imageIcons.get(this.index));

        final JScrollPane jScrollPane = new JScrollPane(this.currentLabel);
        this.add(jScrollPane);

        final JButton next = new JButton("Next");
        final JButton last = new JButton("Last");

        this.add(next, BorderLayout.LINE_END);
        this.add(last, BorderLayout.LINE_START);

        next.addActionListener(actionEvent -> {
            this.index++;
            if (this.index >= this.imageIcons.size()) {
                this.index = 0;
            }
            this.currentLabel.setIcon(this.imageIcons.get(this.index));
            this.repaint();
        });

        last.addActionListener(actionEvent -> {
            this.index--;
            if (this.index < 0) {
                this.index = this.imageIcons.size() - 1;
            }
            this.currentLabel.setIcon(this.imageIcons.get(this.index));
            this.repaint();
        });

        this.pack();
        this.setDefaultCloseOperation(
                WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
