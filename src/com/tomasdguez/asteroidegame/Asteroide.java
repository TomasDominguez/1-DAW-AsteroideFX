/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomasdguez.asteroidegame;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author tomasdg
 */
public class Asteroide {
    
    // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;
    
    // Declaramos la variable para el asteroide.
    Polygon asteroide;
    
    // Declaramos las variables de Movimiento del Asteroide.
    // Declaramos los ejes de la bola.
    int asterCenterX = 10;
    double asterSpeedX = 1;
    int asterCenterY = 20;
    double asterSpeedY = 1;


    
    // Declramos el metodo del tercer polígono para crear un asteroide.
    public void crearAsteroide(){
        asteroide = new Polygon();
        asteroide.getPoints().addAll(new Double[]{
            -100.0, 80.0,
            -20.0, 60.0,
            60.0, 80.0,
            -20.0, 20.0,
            -40.0, -80.0,
            -120.0, 0.0
        });
        asteroide.setFill(Color.GREY);
    }
    
    public void movimientoAsteroide(){
    // Sentencia Movimiento Asteroide.
        //Eje X
        asteroide.setLayoutX(asterCenterX);
        asterCenterX += asterSpeedX;
        if (asterCenterX >= MEDIDAS_X){
            asterCenterX = 0;
        }
        if (asterCenterX >= MEDIDAS_X){
            asterCenterX = MEDIDAS_X;
        }

        //Eje Y
        asteroide.setLayoutY(asterCenterY);
        asterCenterY += asterSpeedY;
        if (asterCenterY >= MEDIDAS_Y){
            asterCenterY = 0;
        }
        if (asterCenterY >= MEDIDAS_Y){
            asterCenterY = MEDIDAS_Y;
        }

        // Rotación en su propio eje.
        asteroide.setRotate(asterCenterX);
    };        
    
    //Declaramos el metodo para resetGame del asteroide.
    // Declaramos el metodo para la posición del asteroide.
    public void posicionAsteroide(){
        asterCenterX = 10;
        asterSpeedX = 1;
        asterCenterY = 20;
        asterCenterY = 1;
    };

    // Declaramos el motodo para posición aleatoria tras la colision.
    public void randomAsteroide(){
        Random random = new Random();
        asterCenterX = random.nextInt(MEDIDAS_X);
        asterCenterY = random.nextInt(MEDIDAS_Y);
    }
}
