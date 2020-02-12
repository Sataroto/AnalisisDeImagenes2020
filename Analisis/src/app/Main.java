package app;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import gui.JframeImagen;
import open.AbrirImagen;
import herramienta.*;
public class Main {

    public static void main(String[] args) 
    
        /*{ //Lectura de Imagen y Circulo
        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color = new Color(57,255,20);
        bi.setRGB(50,50,color.getRGB());
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi));
       
        System.out.println();
        }*/

    {   /*//GeneracionHistograma;
        histograma uwu = new histograma();
        uwu.imprimirGrafica();*/
        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        filtros uwu = new filtros(imagen);
        histograma normal = new histograma(imagen);
        normal.imprimirRGB();
        histograma negativo = new histograma(uwu.negativos());
        negativo.imprimirRGB();
    }
}