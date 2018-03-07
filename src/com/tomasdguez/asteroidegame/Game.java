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
        
        //Estilos CSS Java FX
        ventana.setOnKeyPressed((KeyEvent event)->{
            switch(event.getCode()){
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
            }
    });        
        // Mostramos crearCuerpoNave y  crearColaNave.
        // Llamada al metodo crearCuerpoNave para su muestra en pantalla
//        crearCuerpoNave();
        
        // Llama al metodo crearColaNave para su muestra en pantalla
//        crearColaNave();
        
        // Llama al metodo asteroide para su muestra en pantalla
//        crearAsteroide();
        
        // LLama al metodo crearMunicion para su muestra en pantalla.
//        crearMunicion();
       
        // Sentencia para la activación de la llama de la nave al acelerar.
/*        ventana.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case UP:
                    // Dirección Nave.
                    dirSenNaveX = Math.cos(radNave);
                    dirCosNaveY = Math.sin(radNave);
                    // Caluclo de velocidad.
                    velNaveY += (dirCosNaveY * 0.3);
                    velNaveX += (dirSenNaveX * 0.3);
                    break;
            }
        });
*/       
        // Sentencia para el disparo.
        ventana.setOnKeyPressed((KeyEvent event) ->{
              switch(event.getCode()){
                  case SPACE:
              }
           });
       
        // Reinicio del Juego.
//        resetGame();
        
        // Declaramos la Animación.
        AnimationTimer animationAsteroide; // Final de la Animación.
        animationAsteroide = new AnimationTimer(){
            
            @Override
            public void handle(long now){

//                // Sentencia de colisión. Nave Asteroide.
//                Shape colisionNaveAsteroide = Shape.intersect(cuerpoNave, asteroide);
//                boolean colisionNave = colisionNaveAsteroide.getBoundsInLocal().isEmpty();
//                if (colisionNave == false){
//                     resetGame();
//                }
//                
//                // Sentencia de colisión. Munición, Asteroide.
//                Shape colisionBalaAsteroide = Shape.intersect(crearBala, asteroide);
//                boolean colisionBala = colisionBalaAsteroide.getBoundsInLocal().isEmpty();
//                if (colisionBala == false){
//                    
//                }
//                
                // Llamamos a la variable cuerpoNave para ejecutar el movimiento.
//                cuerpoNave.setLayoutX(naveCenterX);
//                cuerpoNave.setLayoutY(naveCenterY);
                
                
                // Llamamos a la variable colaNave para ejecutar el movimiento.
//            colaNave.setLayoutX(naveCenterX);
//            colaNave.setLayoutY(naveCenterY);

                // Llamamos a la variable asteroide para ejecutar el movimiento.
//                asteroide.setLayoutX(asterCenterX);
//                asteroide.setLayoutY(asterCenterY);

            } // Final del handle
            
        };

        // Ejecución de la Animación.        
        animationAsteroide.start();
    
    }; // Ceramos el Start de la animación.

} // The end Asteroide Game.

