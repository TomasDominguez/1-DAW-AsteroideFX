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
public class Game extends Application {

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
        
        // Llamada al metodo crearCuerpoNave para su muestra en pantalla
        Nave miNave = new Nave();
        miNave.crearCuerpoNave();
        root.getChildren().add(miNave.cuerpoNave);
        
//        // Llama al metodo crearColaNave para su muestra en pantalla
//        Nave colaNave = new Nave();
//        colaNave.crearColaNave();
//        root.getChildren().add(colaNave.colaNave);
       
        // Llama al metodo asteroide para su muestra en pantalla
        Asteroide miAsteroide = new Asteroide();
        miAsteroide.crearAsteroide();
        root.getChildren().add(miAsteroide.asteroide);
        
        // LLama al metodo crearMunicion para su muestra en pantalla.
        Municion crearBala = new Municion();
        crearBala.crearMunicion();
        root.getChildren().add(crearBala.circuloBala);
        
        // Sentencia para el disparo.
        ventana.setOnKeyPressed((KeyEvent event) ->{
              switch(event.getCode()){
                  case SPACE:
              }
           });
                
        // Movimiento para la nave.
        ventana.setOnKeyPressed((KeyEvent event)->{
            switch(event.getCode()){
                case RIGHT:
                    miNave.giroDerecha();
                    break;
                case LEFT:
                    miNave.giroIzquierda();
                    break;
                case UP:
                    miNave.acelerarNave();
                    break;
                case Q:
                    ventana.getStylesheets().add("resources/css/style1.css");
                    break;
                case W:
                    ventana.getStylesheets().clear();
                    ventana.getStylesheets().add("resources/css/style2.css");
                    break;
                case E:
                    ventana.getStylesheets().clear();
                    ventana.getStylesheets().add("resources/css/style3.css");
                    break;
                case SPACE:
                    crearBala.moverBala();
                    break;
            }
        });
        // Con esta sentencia se para el movimiento al dejar de pulsar las teclas.
        ventana.setOnKeyReleased((KeyEvent event) -> {
            // No se pulsa ninguna tecla.
            miNave.stopGiroNave();
        });
        
                 
        // Declaramos la Animación.
        AnimationTimer animationAsteroide; // Final de la Animación.
        animationAsteroide = new AnimationTimer(){
            
            @Override
            public void handle(long now){
                
                // Sentencia de colisión. Nave Asteroide.
                Shape colisionNaveAsteroide = Shape.intersect( miNave.cuerpoNave , miAsteroide.asteroide);
                boolean colisionNave = colisionNaveAsteroide.getBoundsInLocal().isEmpty();
                if (colisionNave == false){
                        miNave.posicionCentral();
                        miAsteroide.posicionAsteroide();
                        miAsteroide.randomAsteroide(); 
                }
                
                // Sentencia de colisión. Munición, Asteroide.
                Shape colisionBalaAsteroide = Shape.intersect(crearBala.circuloBala, miAsteroide.asteroide);
                boolean colisionBala = colisionBalaAsteroide.getBoundsInLocal().isEmpty();
                if (colisionBala == false){
                        miAsteroide.posicionAsteroide();
                        miAsteroide.randomAsteroide();
                        crearBala.crearMunicion();
                        crearBala.resetBala();
                }
             
                //Llamamos a la variable cuerpoNave para ejecutar el movimiento.
                miNave.moverNave();

                
                // Llamamos a la variable colaNave para ejecutar el movimiento.
                //colaNave.acelerarColaNave();

                // Llamamos a la variable asteroide para ejecutar el movimiento.
                miAsteroide.movimientoAsteroide();

            } // Final del handle
            
        };

        // Ejecución de la Animación.        
        animationAsteroide.start();
    
    }; // Ceramos el Start de la animación.

} // The end Asteroide Game.

