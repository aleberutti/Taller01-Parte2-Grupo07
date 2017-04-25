/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.ArrayList;


/**
 *
 * @author mdominguez
 */ 

public class OrdenarRadix extends OrdenadorService{
        
    @Override
    public ArregloDied ordenar(ArregloDied arreglo) {
        arregloOrdenado = arreglo.clonar();
        arregloOrdenado.inicializarContadores();
        ArrayList<ColaDied> Urnas = new ArrayList<>(10);
           
        long mod;
        
        for(int i=0; i<10; i++){
            Urnas.add(i, new ColaDied(arregloOrdenado.tamanio()));
        }
        
        long maxDig = arregloOrdenado.datos[0].valorOrdenamiento();
            for(int i=0;i<arregloOrdenado.tamanio();i++){
                if(maxDig < arregloOrdenado.datos[i].valorOrdenamiento()){
                maxDig = arregloOrdenado.datos[i].valorOrdenamiento();
             }
            }
                    for(mod = 1l; maxDig/mod>0; mod=mod*10)
        while(maxDig/mod>0){
            Integer contador=0;
            for(int j=0;j<arregloOrdenado.tamanio();j++){
                Long d;
                d=((arregloOrdenado.datos[j].valorOrdenamiento()/mod))%10;
                Urnas.get(d.intValue()).enqueue(arregloOrdenado.datos[j]);
                ArregloDied.comparaciones++;
            }
            for(int w=0; w<10; w++){
                while(!(Urnas.get(w).isEmpty())){
                    arregloOrdenado.agregarEnPosicion(contador, Urnas.get(w).dequeue());
                    contador++;
                }
            }
            mod*=10;
        }        
      return arregloOrdenado;
    }
}
