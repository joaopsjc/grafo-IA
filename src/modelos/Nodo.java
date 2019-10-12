/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre William
 */
public class Nodo {
    String nome;
    boolean aberto, fechado;
    List<Aresta> arestas;
    
    public Nodo(String nome) {
        this.nome = nome;
        aberto = false;
        fechado = false;
        arestas = new LinkedList<>();
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return fechado;
    }

    public String getNome() {
        return nome;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
    public void addAresta(Nodo novoNodo,int peso, int Heuristica)
    {
        Aresta novaAresta = new Aresta(peso, Heuristica, novoNodo);
        arestas.add(novaAresta);
    }
    
    public boolean removeAresta(Nodo nodoRemover)
    {
        Iterator<Aresta> arestaAtual = arestas.iterator();
        while(arestaAtual.hasNext())
        {
            Aresta aresta = arestaAtual.next();
            if(nodoRemover.equals(aresta.getNodo()))
            {
                arestas.remove(aresta);
                return true;
            }
        }
        return false;
    }
    public boolean containsAresta(Nodo nodoContido)
    {
        Iterator<Aresta> arestaAtual = arestas.iterator();
        while(arestaAtual.hasNext())
        {
            Aresta aresta = arestaAtual.next();
            if(nodoContido.equals(aresta.getNodo()))
            {
                return true;
            }
        }
        return false;
    }
}
