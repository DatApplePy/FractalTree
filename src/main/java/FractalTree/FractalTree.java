/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalTree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author where-is-the-semicolon
 */
public class FractalTree extends JPanel {
    private final int WIDTH = 1200;
    private final int HEIGHT = 900;
    private int levelNum;
    private final double originX;
    private final double originY;
    private final double length;
    private double lengthOffset;
    private final double angle;
    private double angleOffset;
    private Graphics2D g2d;

    public FractalTree(int levelNum, double originX, double originY, double length, double lengthOffset, double angle, double angleOffset) {
        this.levelNum = levelNum;
        this.originX = originX;
        this.originY = originY;
        this.length = length;
        this.lengthOffset = lengthOffset;
        this.angle = angle;
        this.angleOffset = angleOffset;
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.GRAY);
    }
    
    public void setLengthOffset(double newLength) {
        lengthOffset = newLength;
    }
    
    public void setAngleOffset(double newAngle) {
        angleOffset = newAngle;
    }
    
    public void setLevelNum(int x) {
        levelNum = x;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.translate(WIDTH/2, HEIGHT);
        g2d.rotate(Math.PI);
        g2d.setBackground(Color.GRAY);
        createFractalTree(g2d, originX, originY, length, angle, levelNum);
    }
    
    public void createFractalTree(Graphics2D g2d, double branchX,
            double branchY, double branchLength, double branchAngle,
            int level) {
        if(level > 0) {
            g2d.setColor(Color.WHITE);
            double nextBranchX = branchX + branchLength*Math.cos(branchAngle);
            double nextBranchY = branchY + branchLength*Math.sin(branchAngle);
            g2d.drawLine((int)branchX, (int)branchY, (int)nextBranchX, (int)nextBranchY);
            double nextBranchLength = branchLength * lengthOffset;
            createFractalTree(g2d, nextBranchX, nextBranchY, nextBranchLength, branchAngle+angleOffset, level-1);
            createFractalTree(g2d, nextBranchX, nextBranchY, nextBranchLength, branchAngle-angleOffset, level-1);
        }
    }
}
