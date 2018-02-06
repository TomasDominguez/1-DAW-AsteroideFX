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

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

// Declaramos las variables de ejes de la nave y del la llama.
    int naveCenterX = 10;
    int naveCurrentSpeedX = 3;
    int naveCenterY = 30;
    int naveCurrentSpeedY = 3;
    
// Declaramos la variable puntos.
    int puntos = 0;

// Declaramos las variables de texto para la puntuación
    int textScore = 2;
    
// Declaramos el giro de la nave con 90º, usando la teclas izquierda y derecha.
// Declaramos el polígono triangulo para nuestra nave color Negro.
    private void cuerpoNave() {    
        Polygon nave = new Polygon();
        nave.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0
        });
        nave.setFill(Color.BLACK);
        root.getChildren().add(nave);    
    }
    
// Declaramos el segundo polígono en la parte trasera cuando acelere color Gris.
    private void colaNave() {
        Polygon navetras = new Polygon();
        navetras.getPoints().addAll(new Double[]{
            20.5, 10.5,
            10.5, 20.5,
            21.0, 21.0    
        });
        navetras.setFill(Color.GREY);
        root.getChildren().add(navetras);
    }
   
// Declaramos el metodo de reinicio del Juego.
    private void resetGame(){
        puntos = 0;
        textScore.setText(String.valueOf(puntos));
        naveCenterX = 10;
        naveCurrentSpeedY = 3;
        // Posicion de inicio de bola aleatoria en el eje Y.
        Random random = new Random();
        naveCenterY = random.nextInt(MEDIDAS_Y);
    }

    @Override
    public void start(Stage primaryStage) {
 
// Declaramos dimensiones de pantalla y color de fondo GRIS y el titulo.
        root = new Pane();
        Scene ventana = new Scene(root, MEDIDAS_X, MEDIDAS_Y, Color.rgb(249, 249, 249));
        primaryStage.setTitle("Asteroids Game");
        primaryStage.setScene(ventana);
        primaryStage.show();
        
// Mostramos la nave y la cola.
        cuerpoNave();
        colaNave();
        
// Mover la nave a una velocidad constante al acelara pulsando la tecla arriba.     
    }   
        
/*// Creamos la clase animación para el movimiento .
        AnimationTimer animationRocket = null;
        animationRocket = new AnimationTimer(){
        
        @Override
        public void handle (long now){

// Creamos la sentencia para el movimiento de la nave.

// Creamos la sentencia para la activación de la cola de la nave.

        }
// Cominezo de la Animación.
        animationBall.start();

      
        }*/

};

