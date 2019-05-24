package com.example.carte;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.example.util.ResourceUtility;

public class Jeu {  
	int rows = 4;
    int cols = 3;
    private ImageIcon[][] figures = loadImages();
    
    public Jeu() throws IOException {}
    
    public ImageIcon[][] loadImages() throws IOException {
      
        int num_img = 1;
        ImageIcon[][] images = ResourceUtility.splitImageIcon(
                ResourceUtility.loadBufferedImage("images/butterfly2.png")
                , rows, cols);
        for (int i = 0; i < rows ; i++) {
        	for (int j =0; j < cols ; j++ ) {
        images[i][j].setDescription("image_" + num_img);
        num_img++;
           }
    }
      return images; 
    }

	public Deque<ImageIcon> creerPioche(){
		LinkedList<ImageIcon> liste = new LinkedList<ImageIcon>();
		for (int i = 0; i < rows ; i++) {
        	for (int j =0; j < cols ; j++ ) {
        		liste.add(figures[i][j]);
        	}
		}
		Collections.shuffle(liste);
		return liste;
	} 
	}