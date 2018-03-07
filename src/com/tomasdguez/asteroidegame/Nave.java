/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomasdguez.asteroidegame;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author tomasdg
 */
public class Nave {
    // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;
    
    // Creamos la variable para la Pantalla de root.
    Pane root;
    
    // Declaramos las variables de ejes de la nave y del la llama.
    int naveCenterX = 400;
    int naveCenterY = 300;
    int colaCenterX = 400;
    int colaCenterY = 300;
    
    // Declaramos la variable para la nave.
    Polygon cuerpoNave;
    
    // Declaramos la variable para la "llama/cola" de la nave.
    Polygon colaNave;
    
    // Declaramos las variables de Movimiento.
    // Angulo de la nave.
    double anguloNave;
   
    // Variable dirección.
    double dirNave;
    
    // Variable dirección en Radianes.
    double radNave;
    
    // Variable dirección seno Angulo.
    double dirSenNaveX;
    
    // Variable dirección coseno Angulo.
    double dirCosNaveY;
    
    // Variable velocidad.
    double velNaveX;
    double velNaveY;
    double velNave;
    
    // Variable velocidad giro.
    double velGiroNave;
    private Object app;
    
    // Declaramos el metodo del polígono triangulo para nuestra nave color Negro.
    public void crearCuerpoNave() {    
        cuerpoNave = new Polygon();
        cuerpoNave.getPoints().addAll(new Double[]{
           -10.0, 10.0,
           30.0, 0.0,
           -10.0, -10.0
        });
        cuerpoNave.setFill(Color.BLACK);
        root.getChildren().add(cuerpoNave);
    }
    
    // Declaramos el metodo del segundo polígono en la parte trasera cuando acelere color Gris.
    public void crearColaNave() {
        colaNave = new Polygon();
        colaNave.getPoints().addAll(new Double[]{
            30.5, 10.5,
            10.5, 30.5,
            31.0, 31.0    
        });
        colaNave.setFill(Color.ORANGE);
        root.getChildren().add(colaNave);
    }
    
    // Declaramos el metodo del movimiento de la nave.
    public void moverNave(){
        // la dirección es el resto del angulo entre 360.
                dirNave = anguloNave % 360;
                radNave = Math.toRadians(dirNave);
                
                // giro de la nave.
                anguloNave += velGiroNave;
                cuerpoNave.setRotate(dirNave);
                
                // Modificamos la posición en relación a la velocidad.
                naveCenterX += velNaveX;
                //System.out.println(velNaveX);// Muesta valor en Pantalla.
                naveCenterY += velNaveY;
                
                // hacemos que la pantalla no tenga final.
                if (naveCenterX >= MEDIDAS_X){
                    naveCenterX = 0;
                }
                if (naveCenterY >= MEDIDAS_Y){
                    naveCenterY = 0;
                }
                if (naveCenterX < 0){
                    naveCenterX = MEDIDAS_X;
                }
                if (naveCenterY < 0){
                    naveCenterY = MEDIDAS_Y;
                }
    }
}
