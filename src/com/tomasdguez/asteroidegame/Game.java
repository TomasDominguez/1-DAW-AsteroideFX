/*
 * Tomás Dominguez Gómez
 * IES Ntra. Sra. Los Remedios
 * Ubrique (Cádiz)
 * 1º Desarrollo Aplicaciones Web
 * Curso 2017 / 2018
 * Asígnatura Programación
 * Juego Asteroide Game Java FX.
 *
 */
package com.tomasdguez.asteroidegame;



import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
/**
 *
 * @author tomasdg (deaquinodg@gmail.com)
 */
public class Game extends Application {

    // Creamos la variable para la Pantalla de root.
    public static Pane root = new Pane();
    
    // Declaramos las constantes de la dimensión de la ventana en pixel.
    final int MEDIDAS_X = 800;
    final int MEDIDAS_Y = 600;
    
    public static Nave miNave = new Nave();
    
    public static Municion bala = new Municion();
    
    @Override
    public void start(Stage primaryStage) {
     
        // Declaramos dimensiones de pantalla y color de fondo GRIS y el titulo.
        root = new Pane();
        Scene ventana = new Scene(root, MEDIDAS_X, MEDIDAS_Y, Color.rgb(249, 249, 249));
        primaryStage.setTitle("Asteroids Game");
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        // Llamada al metodo crearCuerpoNave para su muestra en pantalla
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
        bala.bala();
        root.getChildren().add(bala.circuloBala);
        
        // Controles de teclado.
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
                case F1:
                    ventana.getStylesheets().clear();
                    ventana.getStylesheets().add("resources/css/style1.css");
                    break;
                case F2:
                    ventana.getStylesheets().clear();
                    ventana.getStylesheets().add("resources/css/style2.css");
                    break;
                case F3:
                    ventana.getStylesheets().clear();
                    ventana.getStylesheets().add("resources/css/style3.css");
                    break;
                case SPACE:
                    bala.bala();
                    
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
                Shape colisionBalaAsteroide = Shape.intersect(bala.circuloBala, miAsteroide.asteroide);
                boolean colisionBala = colisionBalaAsteroide.getBoundsInLocal().isEmpty();
                if (colisionBala == false){
                        miAsteroide.posicionAsteroide();
                        miAsteroide.randomAsteroide();
                        bala.bala();
                        bala.resetBala();
                }
             
                //Llamamos a la variable cuerpoNave para ejecutar el movimiento.
                miNave.moverNave();
                
                // Llamamos a la variable colaNave para ejecutar el movimiento.
                //colaNave.acelerarColaNave();

                // Llamamos a la variable asteroide para ejecutar el movimiento.
                miAsteroide.movimientoAsteroide();

            } // Final del handle
            
        };// Cierre del Animation Timer

        // Ejecución de la Animación.        
        animationAsteroide.start();
    
    }; // Ceramos el Start de la animación.

} // The end Asteroide Game.

