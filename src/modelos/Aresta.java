/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Andre William
 */
public class Aresta {
    int peso,heuristica;
    Nodo nodo;

    public Aresta(int peso, int heuristica, Nodo nodo) {
        this.peso = peso;
        this.heuristica = heuristica;
        this.nodo = nodo;
    }

    public Aresta(int peso, Nodo nodo) {
        this.peso = peso;
        this.nodo = nodo;
    }

    public int getPeso() {
        return peso;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public Nodo getNodo() {
        return nodo;
    }
    
}
