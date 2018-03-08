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
    Circle crearBala;
        
    //Variable de la bala.
    int balaCenterX = 400;
    int balaCenterY = 300;
            
    // Declaramos el metodo para la Munición ó Bala a disparar.
    public void crearMunicion(){
      crearBala = new Circle(balaCenterX, balaCenterY, 2, Color.BLACK);
    }     
    
}
