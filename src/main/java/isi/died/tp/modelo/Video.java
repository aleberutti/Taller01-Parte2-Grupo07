/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

/**
 *
 * @author st
 */
public class Video extends MaterialCapacitacion{
    private double duracion;
    private double costo;

    public Video() {
    }

    public double getDuracion() {
        return duracion;
    }

    public double getCosto() {
        return costo;
    }
    
    
    
    public Video(String titulo, double duracion, double costo) {
        super(titulo);
        this.duracion = duracion;
        this.costo = costo;
        super.estado=EstadoPromocion.REGULAR;
    }    
    
    @Override
    public Double precio(){
        Double p1=0.0;        
        switch(this.estado){
            case REGULAR:
               p1=(this.duracion*this.costo);
               break;            
            case OFERTA:
               p1=(this.duracion*this.costo)*0.5;
               break;   
        }
        return p1;       
    }
    @Override
    public void liquidar() {
        this.estado=EstadoPromocion.OFERTA;
    } 
    
}
