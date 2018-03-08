/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomasdguez.asteroidegame;

import java.util.Random;
import javafx.scene.layout.Pane;

/**
 *
 * @author tomasdg
 */
public class ResetGame {
  
    // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;
        
    // Declaramos las variables de ejes de la nave y del la llama.
    int naveCenterX = 400;
    int naveCenterY = 300;
    int colaCenterX = 400;
    int colaCenterY = 300;
    
    // Declaramos las variables de Movimiento del Asteroide.
    // Declaramos los ejes de la bola.
    int asterCenterX = 10;
    double asterSpeedX = 1;
    int asterCenterY = 20;
    double asterSpeedY = 1;
    
    // Declaramos el metodo de Reinicio del Juego. en caso de colisión.
    public void resetGame(){
            asterCenterX = 10;
            asterSpeedX = 1;
            asterCenterY = 20;
            asterSpeedY = 1;
            
            // Posición Central del asteroide al colisionar con el asteroide.
            naveCenterX = 400;
            naveCenterY = 300;
            
            // Incio aleatorio del Asteroide.
            Random random = new Random();
            asterCenterX = random.nextInt(MEDIDAS_X);
            asterCenterY = random.nextInt(MEDIDAS_Y);
    }

}
