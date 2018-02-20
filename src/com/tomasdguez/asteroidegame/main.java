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
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
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
    double naveCenterX = 400;
    double naveCenterY = 300;
    
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
        colaNave = new Polygon();
        colaNave.getPoints().addAll(new Double[]{
            20.5, 10.5,
            10.5, 20.5,
            21.0, 21.0    
        });
        colaNave.setFill(Color.ORANGE);
        root.getChildren().add(colaNave);
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
        // Llamada al metodo crearCuerpoNave para su muestra en pantalla
        crearCuerpoNave();
        
        // Llama al metodo crearColaNave para su muestra en pantalla
        crearColaNave();
        
        // Movimiento.
        root.setOnKeyPressed((KeyEvent event)->{
            switch(event.getCode()){
                case RIGHT:
                    velGiroNave = 2;
                    break;
                case LEFT:
                    velGiroNave = -2;
                    break;
                case UP:
                    // Dirección Nave.
                    dirSenNaveX = Math.sin(radNave);
                    dirCosNaveY = Math.cos(radNave);
                    // Calular Velocidad.
                    velNaveX += (velNave * 0.2);
                    velNaveY += (velNave * 0.2);
                    break;
            }
        });
        
        // Velocidad del giro.
        root.setOnKeyReleased((KeyEvent event) -> {
            velGiroNave = 0;
        });

        
        // Declaramos la Animación.
        AnimationTimer animationAsteroide = null;
        animationAsteroide = new AnimationTimer(){
            
            @Override
            public void handle(long now){
                
            // la dirección es el resto del angulo entre 360.
            dirNave = anguloNave % 360;
            radNave = Math.toRadians(dirNave);
            
            // giro de la nave.
            anguloNave += velGiroNave;
            cuerpoNave.setRotate(dirNave);
            
            // Modificamos la posición en relación a la velocidad.
            naveCenterX += velNaveX;
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
            // Llamamos a la variable cuerpoNave para ejecutar el movimiento.
            cuerpoNave.setLayoutX(naveCenterX);    
            cuerpoNave.setLayoutY(naveCenterY);
            
            
            // Llamamos a la variable colaNave para ejecutar el movimeinto.
            colaNave.setLayoutX(naveCenterX);
            colaNave.setLayoutY(naveCenterY);
            
            // Comineza la sentencia de los controles. Respondiendo al movimiento.
            
            } // Final del handle
            
        }; // Final de la Animación.

                
        // Ejecución de la Animación.        
        animationAsteroide.start();
    
    }; // Ceramos el Start de la animación.

} // The end Asteroide Game.

