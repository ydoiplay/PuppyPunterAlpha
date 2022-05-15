/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projectdrafttesting;

import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author henry
 */
public class ProjectDraftTesting {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        
        frame.setSize(720, 720);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - screenSize.getHeight()/4));
        
        frame.setResizable(false);
        frame.setTitle("Are you proud of me, dad?");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
