/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.Ordenable;
import java.util.Date;

/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    private Integer suscripciones;

    public MaterialCapacitacion() {
        this.suscripciones=0;
    }      

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
   
    } 
       
    public String getTitulo() {
        return titulo;
    }
    
    public Integer getSuscripciones() {
        return suscripciones;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    
    
    protected Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
    
    public void suscribir(){
        this.suscripciones++;
    }
    
    public void cancelarSuscripcion(){
        this.suscripciones--;
    }
    
    public abstract Double precio();
    
    public abstract void liquidar();

    @Override
    public String toString() {
        return "MaterialCapacitacion{" + "titulo=" + titulo + '}';
    }   
    
    @Override
    public Long valorOrdenamiento() {
    return Long.valueOf(numerarString(this.titulo)+""+formatoPrecio(this.precio()));
    }
    
    private Long numerarString(String arg){
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar ;
        for(int i =0;i<4;i++){
            Integer aux;
            if(i>origen.length()-1) {
                aux = 37;
            }
            else {
            unChar = origen.charAt(i);
                if(unChar>='A' && unChar <='Z'){ 
                    aux = unChar-54;                
                }
                else{ 
                    aux = 38; }
                }
                resultado +=aux;
        }   
      return Long.valueOf(resultado);
    }

    private Long formatoPrecio(Double precio){
    Long precioEntero = Math.round(precio);
    Long x = precioEntero%10000 ;
    Long formato = 10000+ x;
    return formato;
     }
    
   }
