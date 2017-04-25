/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arreglo) {       
                arregloOrdenado=arreglo.clonar();
                arregloOrdenado.inicializarContadores();
                this.MergeSort(arregloOrdenado, 0, arreglo.tamanio()-1);
                return arregloOrdenado;
    }
    
    public void MergeSort(ArregloDied vec, int prim, int ult){
        int med;
        if (prim<ult){
            med=(prim+ult)/2;
            MergeSort(vec, prim, med);
            MergeSort(vec, med+1, ult);
            merge(vec, prim, med, ult);
        }
    }
    
    public void merge(ArregloDied vec, int prim, int med, int ult){
      int primAux=prim, medAux=(med+1), primAux2=prim;
      ArregloDied arAux=new ArregloDied(vec.tamanio());
      
      while(primAux<=med && medAux<=ult){
          if(vec.mayorIgual(medAux, primAux)){
              arAux.agregarEnPosicion(primAux2++, vec.get(primAux++));
          }
          else{
              arAux.agregarEnPosicion(primAux2++, vec.get(medAux++));
          }
      }
      
      while(primAux<=med){
          arAux.agregarEnPosicion(primAux2++, vec.get(primAux++));
      }
      while(medAux<=ult){
          arAux.agregarEnPosicion(primAux2++, vec.get(medAux++));
      }
      
      while (prim<=ult){
          vec.agregarEnPosicion(prim, arAux.get(prim));
          prim++;
      }
    }
}
