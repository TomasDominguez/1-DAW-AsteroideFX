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
import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 *
 * @author tomasdg (deaquinodg@gmail.com)
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
    
    // Declaramos la variable para la nave.
    Polygon cuerpoNave;
    
    // Declaramos la variable para la "llama/cola" de la nave.
    Polygon cola;
    
    // Declaramos el giro de la nave con 90º, usando la teclas izquierda y derecha.

    // Declaramos el metodo del polígono triangulo para nuestra nave color Negro.
    private void crearCuerpoNave() {    
        cuerpoNave = new Polygon();
        cuerpoNave.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0
        });
        cuerpoNave.setFill(Color.BLACK);
        root.getChildren().add(cuerpoNave);
    }
    
    // Declaramos el metodo del segundo polígono en la parte trasera cuando acelere color Gris.
    private void crearColaNave() {
        cola = new Polygon();
        cola.getPoints().addAll(new Double[]{
            20.5, 10.5,
            10.5, 20.5,
            21.0, 21.0    
        });
        cola.setFill(Color.GREY);
        root.getChildren().add(cola);
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

        // Mover la nave a una velocidad constante al acelara pulsando la tecla arriba.

        // Creamos la clase animación para el movimiento .

        // Creamos la clase animación para el movimiento .

        // Creamos la sentencia para el movimiento de la nave.

        // Creamos la sentencia para la activación de la cola de la nave.

        // Declaramos la Animación.
        AnimationTimer animationAsteroide = null;
        animationAsteroide = new AnimationTimer(){
            
            @Override
            public void handle(long now){
                
        // Llamamos a la variable cuerpoNave para ejecutar el movimiento.
            cuerpoNave();
                
            } // Final del handle
            
        }; // Final de la Animación.
        
// Ejecución de la Animación.        
    animationAsteroide.start();
    
    };

} // The end Asteroide Game.

