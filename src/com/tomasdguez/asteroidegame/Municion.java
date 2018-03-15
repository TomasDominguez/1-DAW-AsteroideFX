/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomasdguez.asteroidegame;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author tomasdg
 */
public class Municion {
    // Creamos la variable para la Pantalla de root.
    Pane root;
    
    // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;

    // Declaramos la variable para la bala.
    Circle circuloBala;
        
    //Variable de la bala.
    int balaCenterX = 400;
    int balaCenterY = 300;
    
    // Variable de la velocidad de la bala
    double velMunicion = 10;
    double velocidadBalaX = 0;
    double velocidadBalaY = 0;
    
    // Variable del angulo de la bala.
    double angulo = 0;
    
    // Variable posición de la Bala.
    double posicionX = 0;
    double posicionY = 0;
    
    // Variable dirección seno Angulo.
    double dirSenMuniX;
    
    // Variable dirección coseno Angulo.
    double dirCosMuniY;
    
    double posX;
    double posY;
    double velocidadX;
    double velocidadY;
            
    // Declaramos el metodo para la Munición ó Bala a disparar.
    public void crearMunicion(){
      circuloBala = new Circle(balaCenterX, balaCenterY, 2, Color.BLACK);
      dirSenMuniX=Math.sin(Math.toRadians(Game.miNave.anguloNaveBala()));
      dirCosMuniY=Math.cos(Math.toRadians(Game.miNave.anguloNaveBala()));
      posicionX=posX;
      posicionY=posY;
     // velocidadBalaX= velocidadX+velMunicion*dirSenMuniX;
      //velocidadBalaY= velocidadY+velMunicion*dirCosMuniY;
    }     
    
    // Declaramaos el metodo para el movimiento de la Bala al disparar.
    public void moverBala(){
        circuloBala.setLayoutX(posX);
        circuloBala.setLayoutY(posY);
        posX=posX+velMunicion;
        posY=posY+velMunicion;
        if (posX > root.getWidth()){
                posX=0;
            }
            if (posX < 0){
                posX=root.getWidth();
            }
            if (posY > root.getHeight()){
                posY=0;
            }
            if (posY < 0){
                posY=root.getHeight();
            }
    }
    // Declaramos el metodo para la posición centrla de la bala. (ResetGame).
    public void resetBala(){
                balaCenterX = 400;
                balaCenterY = 300;
    }
}// Fin de la clase Munición.
