/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrafttesting;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author henry
 */
public class Wall {
    
    int x;
    int y;
    int width;
    int height;
    
    Rectangle hitBox;
    
    public Wall(int x , int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        hitBox = new Rectangle(x, y, width, height);
    }
    
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x+1, y+1, width-2, height-2);
    }
}
