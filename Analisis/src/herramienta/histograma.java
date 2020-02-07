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
        XYPlot rojo = rojos.grafica.getXYPlot();
        rojo.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));

        grafica azules = new grafica ( "x","y","azules");
        azules.agregarSerie(this.blue, "azul");
        XYPlot azul = azules.grafica.getXYPlot();
        azul.getRenderer().setSeriesPaint(0, new Color(Color.blue.getRGB()));

        grafica verdes = new grafica ( "x","y","verdes");
        verdes.agregarSerie(this.green, "verde");
        XYPlot verde= verdes.grafica.getXYPlot();
        verde.getRenderer().setSeriesPaint(0, new Color(Color.green.getRGB()));

        grafica grises = new grafica ( "x","y","grises");
        grises.agregarSerie(this.hgris, "gris");
        XYPlot gris = grises.grafica.getXYPlot();
        gris.getRenderer().setSeriesPaint(0, new Color(Color.gray.getRGB()));

        rojos.creaYmuestraGrafica();
        azules.creaYmuestraGrafica();
        verdes.creaYmuestraGrafica();
        grises.creaYmuestraGrafica();
    }
}