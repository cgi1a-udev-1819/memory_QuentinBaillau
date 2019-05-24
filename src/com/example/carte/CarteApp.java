package com.example.carte;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.example.swing.FrameForDemoMaker;
import com.example.util.ResourceUtility;

public class CarteApp extends FrameForDemoMaker {

    private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");
    
    private Jeu jeu = new Jeu();

    public CarteApp() throws IOException{
        super("Mémoire");
        setDefaultBounds(100,100,900,600);
    }

    @Override
    public void init(JFrame frame) {
        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(6, 4));
        
        Deque<ImageIcon> pioche = jeu.creerPioche();
        while(!pioche.isEmpty()) {
            cp.add(createButton2(pioche));
        }
        
        for (int i = 0; i < 6 ; i++) {
        	for (int j =0; j < 4 ; j++ ) {
        		cp.add(createButton());
        	}
        } 
    }
    
    public JComponent createButton() {
        JButton button = new JButton(dosCarte);
        return button;
    }
    
    public JComponent createButton2(Deque<ImageIcon> pioche) {
        JButton button = new JButton(pioche.pop());
        return button;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        CarteApp example = new CarteApp();
        SwingUtilities.invokeLater(example);
    }
}
