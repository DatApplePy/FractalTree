/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalTree;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author where-is-the-semicolon
 */
public class MainFrame extends JFrame{
    private JPanel controlPanel;
    private JSlider iterateSlider;
    private JSlider angleSlider;
    private JSlider lengthSlider;
    
    public MainFrame() {
        
        setTitle("Fractal Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.SOUTH);
        
        iterateSlider = new JSlider(1, 10, 5);
        iterateSlider.setPaintTrack(true);
        iterateSlider.setPaintTicks(true);
        iterateSlider.setPaintLabels(true);
        iterateSlider.setMajorTickSpacing(1);
        controlPanel.add(iterateSlider, BorderLayout.NORTH);
        
        angleSlider = new JSlider(0, 90, 45);
        angleSlider.setPaintTrack(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        angleSlider.setMajorTickSpacing(5);
        angleSlider.setMinorTickSpacing(1);
        controlPanel.add(angleSlider, BorderLayout.SOUTH);
        
        lengthSlider = new JSlider(40, 100, 70);
        lengthSlider.setPaintTrack(true);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.setMajorTickSpacing(5);
        lengthSlider.setMinorTickSpacing(1);
        controlPanel.add(lengthSlider, BorderLayout.CENTER);
        
        FractalTree canvas = new FractalTree(iterateSlider.getValue()*2, this.getSize().width/2,
        this.getSize().height, 200, 0.75, Math.PI/2, Math.PI/6);
        add(canvas, BorderLayout.CENTER);
        
        iterateSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                canvas.setLevelNum(iterateSlider.getValue()*2);
                canvas.repaint();
            }
        });
        
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                canvas.setAngleOffset(angleSlider.getValue()*Math.PI/180);
                canvas.repaint();
            }
        });
        
        lengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                canvas.setLengthOffset((double)(lengthSlider.getValue())/100);
                canvas.repaint();
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
