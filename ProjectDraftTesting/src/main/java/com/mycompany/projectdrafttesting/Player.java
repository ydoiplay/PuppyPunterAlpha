/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrafttesting;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author henry
 */
public class Player {
    
    GamePanel panel;
    
    int x;
    int y;
    int width;
    int height;
    
    double xspeed;
    double yspeed;
    
    Rectangle hitBox;
    Image img = new ImageIcon("C:\\Users\\henry\\Desktop\\reconstruction pics\\icon.png").getImage();
    ImageObserver observer;
    
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    
    public Player(int x, int y, GamePanel panel){
        
        this.panel = panel;
        this.x = x;
        this.y = y;
        
        width = 50;
        height = 100;
        hitBox = new Rectangle(x,y,width,height);
    }
    
    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= 0.8;
        else if(keyLeft && !keyRight) xspeed--;
        else if(keyRight && !keyLeft) xspeed++;
        
        if(xspeed > 0 && xspeed < 0.75 || xspeed < 0 && xspeed > -0.75) xspeed =0;
        
        if(xspeed > 8) xspeed = 8;
        if(xspeed < -8) xspeed = -8;
        
        if(keyUp){
            
            hitBox.y++;
            for(Wall wall: panel.walls){
                if(wall.hitBox.intersects(hitBox)) yspeed= -7.5;
            }
            hitBox.y--;
            
            
            
        }
        
        yspeed += 0.3;
        
        //Horizontal Collision
        hitBox.x += xspeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox))hitBox.x += Math.signum(xspeed);
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }
        }
        
        
        //Vertical Collision
        hitBox.y += yspeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox))hitBox.y += Math.signum(yspeed);
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }
        
        x += xspeed;
        y += yspeed;
        
        hitBox.x = x;
        hitBox.y = y;
    }
    
    public void draw(Graphics2D gtd){
        gtd.drawImage(img, x, y, observer);
    }
    
}
