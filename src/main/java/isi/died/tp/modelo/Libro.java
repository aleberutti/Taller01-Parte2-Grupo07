/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
    }    

    public Libro(String titulo, Double costo, String isbn, Integer paginas) {
        super(titulo);
        this.costo = costo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.estado=EstadoPromocion.ACCESO_TEMPRANO;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }    
    
    @Override
    public void suscribir(){
        super.suscribir();
        if(super.getSuscripciones()==2){
            this.estado=EstadoPromocion.REGULAR;
        }
    }
    
    @Override
    public Double precio(){
        Double p1=0.0;        
        switch(this.estado){
            case REGULAR:
               p1=(this.costo+(this.costo*0.03*(int)(this.paginas/150))); 
               break;
            case ACCESO_TEMPRANO:
               p1=(this.costo+(this.costo*0.03*(int)(this.paginas/150)))*0.9;
               break;
            case LANZAMIENTO:
               p1=(this.costo+(this.costo*0.03*(int)(this.paginas/150)))*1.2;
               break;
            case OFERTA:
               p1=(this.costo*0.8);
               break;   
        }
        return p1;       
    }
          
    @Override
    public void liquidar() {
        this.estado=EstadoPromocion.OFERTA;
    }    
    
}