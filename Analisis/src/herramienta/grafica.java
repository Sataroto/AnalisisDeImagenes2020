/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramienta;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author CRUZLEIJA
 */
public class grafica {
    
    // grafica 
    public JFreeChart grafica;
    // colección de series 
    private XYSeriesCollection series;
    private String ejeX,ejeY,titulo;
    
    public JFreeChart getgrafica(){
        return this.grafica;
    }
    public grafica (String ejeX,String ejeY,String titulo){
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.titulo = titulo;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    } 
    
    public void agregarSerie(double[] datos, String id){
     // crear la serie
        XYSeries serie = new XYSeries(id);
        for(int x=0;x<datos.length;x++){
            serie.add(x, datos[x]);
        }
        this.series.addSeries(serie);
    
    }
        public void agregarSerie(Double[] datos, String id){
     // crear la serie
        XYSeries serie = new XYSeries(id);
        for(int x=0;x<datos.length;x++){
            serie.add(x, datos[x]);
        }
        this.series.addSeries(serie);
    }
    public void creaYmuestraGrafica(Color opcion){
        this.grafica=ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
        XYPlot plot = this.grafica.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, opcion );
        ChartFrame panel = new ChartFrame(titulo, grafica);
        panel.pack();
        panel.setVisible(true);
    }
    public void creaYmuestraGrafica(Color[] muestras){
        this.grafica=ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
        XYPlot plot = this.grafica.getXYPlot();
        for ( int i =0 ;i<muestras.length;i++){
            plot.getRenderer().setSeriesPaint(i, muestras[i] );
        }
    }
    public void creaYmuestraGrafica(){
        this.grafica=ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
        /*XYPlot plot = this.grafica.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, Color.RED );
        plot.getRenderer().setSeriesPaint(1, Color.blue );
        plot.getRenderer().setSeriesPaint(2, Color.green);
        plot.getRenderer().setSeriesPaint(3, Color.GRAY);*/
        ChartFrame panel = new ChartFrame(titulo, grafica);
        panel.pack();
        panel.setVisible(true);
            
    }
    
}