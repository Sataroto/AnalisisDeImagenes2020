package herramienta;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.jfree.chart.plot.XYPlot;

import gui.JframeImagen;
import open.AbrirImagen;

public class filtros{
    public double[] red;
    public double[] blue;
    public double[] green;
    public double[] hgris;
    private BufferedImage bi;
    public filtros(){
        red = new double[256];
        blue = new double[256];
        green = new double[256];
        hgris = new double[256];

        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        this.bi = AbrirImagen.toBufferedImage(imagen);
    }
    public filtros(Image imagen){
        this.bi = AbrirImagen.toBufferedImage(imagen);
    }


    public Image negativos(){
        for ( int x = 0; x<bi.getWidth();x++){
            for(int y =0; y<bi.getHeight();y++){
               Color muestra = new Color(bi.getRGB(x, y));
               Color muestralista = new Color(255-muestra.getRed(),255-muestra.getGreen(),255-muestra.getBlue());
               bi.setRGB(x,y,muestralista.getRGB()); 
            }
        }
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi));
        return AbrirImagen.toImage(bi);
    }

    public void grises(){
        for ( int x = 0; x<bi.getWidth();x++){
            for(int y =0; y<bi.getHeight();y++){
               Color muestra = new Color(bi.getRGB(x, y));
               int prom = (muestra.getBlue() + muestra.getRed() + muestra.getGreen())/3;
               Color muestralista = new Color(prom,prom,prom);
               bi.setRGB(x,y,muestralista.getRGB()); 
            }
        }
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi));
        
    }
    public void temperatura(int tem){
        for (int x = 0 ; x<bi.getWidth();x++ ){
            for(int y = 0; y<bi.getHeight();y++){
                Color muestra = new Color(bi.getRGB(x, y));
                int temred= this.validar(tem+muestra.getRed());
                int temblue=this.validar(muestra.getBlue()-tem);
                    bi.setRGB(x,y, (new Color(temred,muestra.getGreen(),temblue)).getRGB());
            }
        }
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi)); 
    }
    public void iluminacion(int light){
        for (int x = 0 ; x<bi.getWidth();x++ ){
            for(int y = 0; y<bi.getHeight();y++){
                Color muestra = new Color(bi.getRGB(x, y));
                int lred= this.validar(light+muestra.getRed());
                int lblue=this.validar(muestra.getBlue()+light);
                int lgreen =this.validar(light+muestra.getGreen()); 
                    bi.setRGB(x,y, (new Color(lred,lgreen,lblue)).getRGB());
            }
        }
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi)); 
    }
    public int validar(int aux){
        if (aux>255)
        aux=255;
        else if(aux<0)
        aux=0;

        return aux;
    }
}
