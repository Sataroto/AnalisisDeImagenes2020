package herramienta;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.jfree.chart.plot.XYPlot;

import gui.JframeImagen;
import open.AbrirImagen;

public class histograma{
    public double[] red;
    public double[] blue;
    public double[] green;
    public double[] hgris;
    public histograma(Image imagen){
        red = new double[256];
        blue = new double[256];
        green = new double[256];
        hgris = new double[256];
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color muestra;
        for(int x = 0 ; x< bi.getWidth(); x++){
            for(int y =0; y<bi.getHeight();y++){
                muestra =new Color( bi.getRGB(x, y));
                red[muestra.getRed()]++;
                blue[muestra.getBlue()]++;
                green[muestra.getGreen()]++;
                int prom = (muestra.getBlue() + muestra.getRed() + muestra.getGreen())/3;
                hgris[prom]++;
            }
        }
    }
    public histograma(){
        red = new double[256];
        blue = new double[256];
        green = new double[256];
        hgris = new double[256];
        Color muestra;
        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        for(int x = 0 ; x< bi.getWidth(); x++){
            for(int y =0; y<bi.getHeight();y++){
                muestra =new Color( bi.getRGB(x, y));
                red[muestra.getRed()]++;
                blue[muestra.getBlue()]++;
                green[muestra.getGreen()]++;
                int prom = (muestra.getBlue() + muestra.getRed() + muestra.getGreen())/3;
                hgris[prom]++;
            }
        }

    }
    public void imprimirGrafica(){
        //Imprime rojos
        grafica rojos = new grafica ("x","y","rojos");
        rojos.agregarSerie(this.red, "rojo");
        rojos.creaYmuestraGrafica(Color.RED);


        grafica azules = new grafica ( "x","y","azules");
        azules.agregarSerie(this.blue, "azul");
        azules.creaYmuestraGrafica(Color.BLUE);

        grafica verdes = new grafica ( "x","y","verdes");
        verdes.agregarSerie(this.green, "verde");
        verdes.creaYmuestraGrafica(Color.GREEN);

        grafica grises = new grafica ( "x","y","grises");
        grises.agregarSerie(this.hgris, "gris");
        grises.creaYmuestraGrafica(Color.GRAY);


    }
}