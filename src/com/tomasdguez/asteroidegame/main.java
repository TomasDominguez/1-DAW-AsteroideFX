/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomasdguez.asteroidegame;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 *
 * @author tomasdg
 */
public class main extends Application {
 // Creamos la variable para root
    Pane root;
    
 // Declaramos las constantes de la dimensión de la ventana.
    final int SCENES_TAM_X = 800;
    final int SCENES_TAM_Y = 600;
   
   
    @Override
    public void start(Stage primaryStage) {
 
        // Declaramos dimensiones de pantalla de 800 x 600 px y color de fondo GRIS, titulo.
        root = new Pane();
        Scene scene = new Scene(root, SCENES_TAM_X, SCENES_TAM_Y, Color.GREY);
        primaryStage.setTitle("Asteroids Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}