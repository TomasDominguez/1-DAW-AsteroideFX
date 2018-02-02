/*
 * Tomás Dominguez Gómez
 * IES Ntra. Sra. Los Remedios
 * Ubrique (Cádiz)
 * 1º Desarrollo Aplicaciones Web
 * Curso 2017 / 2018
 * Asígnatura Programación
 *
 */
package com.tomasdguez.asteroidegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
/**
 *
 * @author tomasdg
 */
public class main extends Application {
 // Creamos la variable para la Pantalla de root.
    Pane root;
    
 // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;
   
    @Override
    public void start(Stage primaryStage) {
 
// Declaramos dimensiones de pantalla y color de fondo GRIS y el titulo.
        root = new Pane();
        Scene ventana = new Scene(root, MEDIDAS_X, MEDIDAS_Y, Color.rgb(249, 249, 249));
        primaryStage.setTitle("Asteroids Game");
        primaryStage.setScene(ventana);
        primaryStage.show();
        
    
// Declaramos el polígono triangulo para nuestra nave color Negro.
        Polygon nave = new Polygon();
        nave.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0
        });
        nave.setFill(Color.BLACK);
        root.getChildren().add(nave);
    }  
        // Declaramos el giro de la nave con 90º, usando la teclas izquierda y derecha.

        // Mover la nave a una velocidad constante al acelara pulsando la tecla arriba.

// Mostramos otro polígono en la parte trasera cuando acelere color Gris.
        Polygon fuego = new Polygon();
        fuego.getPoints().addAll(new Double[]{
            21.0, 11.0,
            11.0, 21.0,
            25.0, 25.0,    
        });
        fuego.setFill(Color.GREY);
        root.getChildren().add(llama);
        
       
        // Creamos la clase animación para el movimiento .
        //AnimationTimer animationRocket = null;
        //animationRocket = new AnimationTimer(){
    
        // Cominezo de la Animación.
        //animationBall.start();
    };

