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
    int naveCenterX = 400;
    int naveCenterY = 300;
//  int colaCenterX = 400;
//  int colaCenterY = 300;
    
    // Declaramos la variable para la nave.
    Polygon cuerpoNave;
    
    // Declaramos la variable para la "llama/cola" de la nave.
    Polygon colaNave;
    
    // Declaramos la variable para el asteroide.
    Polygon asteroide;
    
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
    
    // Declaramos las variables de Movimiento del Asteroide.
    // Declaramos los ejes de la bola.
    int asterCenterX = 10;
    double asterSpeedX = 1;
    int asterCenterY = 20;
    double asterSpeedY = 1;

    // Declaramos el metodo del polígono triangulo para nuestra nave color Negro.
    private void crearCuerpoNave() {    
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
    private void crearColaNave() {
        colaNave = new Polygon();
        colaNave.getPoints().addAll(new Double[]{
            30.5, 10.5,
            10.5, 30.5,
            31.0, 31.0    
        });
        colaNave.setFill(Color.ORANGE);
        root.getChildren().add(colaNave);
    }
    
    // Declramos el metodo del tercer polígono para crear un asteroide.
    private void crearAsteroide(){
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
        root.getChildren().add(asteroide);
    }
    
    private void resetGame(){
            asterCenterX = 10;
            asterSpeedX = 1;
            asterCenterY = 20;
            asterSpeedY = 1;
            naveCenterX = 400;
            naveCenterY = 300;
            // Incio aleatorio del Asteroide.
            Random random = new Random();
            asterCenterX = random.nextInt(MEDIDAS_X);
            asterCenterY = random.nextInt(MEDIDAS_Y);
    }
    
    @Override
    public void start(Stage primaryStage) {
     
        // Declaramos dimensiones de pantalla y color de fondo GRIS y el titulo.
        root = new Pane();
        Scene ventana = new Scene(root, MEDIDAS_X, MEDIDAS_Y, Color.rgb(249, 249, 249));
        primaryStage.setTitle("Asteroids Game");
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        // Mostramos crearCuerpoNave y  crearColaNave.
        // Llamada al metodo crearCuerpoNave para su muestra en pantalla
        crearCuerpoNave();
        
        // Llama al metodo crearColaNave para su muestra en pantalla
//        crearColaNave();
        
        // Llama al metodo asteroide para su muestra en pantalla
        crearAsteroide();
        
        // Movimiento.
        ventana.setOnKeyPressed((KeyEvent event)->{
            switch(event.getCode()){
                case RIGHT:
                    velGiroNave = 2;
                    break;
                case LEFT:
                    velGiroNave = -2;
                    break;
                case UP:
                    // Dirección Nave.
                    dirSenNaveX = Math.cos(radNave);
                    dirCosNaveY = Math.sin(radNave);
                    // Calcular Velocidad.
                    velNaveY += (dirCosNaveY * 0.3);
                     //System.out.println(dirSenNaveX);
                    velNaveX += (dirSenNaveX * 0.3);
                    break;
            }
        });
        
        // Con esta sentencia se para el movimiento al dejar de pulsar las teclas.
        ventana.setOnKeyReleased((KeyEvent event) -> {
            // No se pulsa ninguna tecla.
            velGiroNave = 0;  
        });
        
        // Sentencia para la activación de la llama de la nave al acelerar.
/*        ventana.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case UP:
                    // Dirección Nave.
                    dirSenNaveX = Math.sin(radNave);
                    dirCosNaveY = Math.cos(radNave);
                    // Caluclo de velocidad.
                    velNaveY -= (dirCosNaveY * 0.3);
                    velNaveX -= (dirSenNaveX * 0.3);
                    break;
            }
        });
*/       
        
        // Reinicio del Juego.
        resetGame();
        
        // Declaramos la Animación.
        AnimationTimer animationAsteroide; // Final de la Animación.
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
                
                // Sentencia de colisión.
                Shape shapeColision = Shape.intersect(cuerpoNave, asteroide);
                boolean colisionNave = shapeColision.getBoundsInLocal().isEmpty();
                if (colisionNave == false){
                     resetGame();
                }
                
                // Llamamos a la variable cuerpoNave para ejecutar el movimiento.
                cuerpoNave.setLayoutX(naveCenterX);
                cuerpoNave.setLayoutY(naveCenterY);
                
                
                // Llamamos a la variable colaNave para ejecutar el movimiento.
//            colaNave.setLayoutX(naveCenterX);
//            colaNave.setLayoutY(naveCenterY);

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

                // Llamamos a la variable asteroide para ejecutar el movimiento.
                asteroide.setLayoutX(asterCenterX);
                asteroide.setLayoutY(asterCenterY);

            } // Final del handle
            
        };
                
        // Ejecución de la Animación.        
        animationAsteroide.start();
    
    }; // Ceramos el Start de la animación.

} // The end Asteroide Game.

