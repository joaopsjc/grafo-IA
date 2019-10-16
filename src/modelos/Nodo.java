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
 * @author João Pedro de Souza Jardim da Costa
 */
public class Nodo {
    int heuristica;
    String nome;
    boolean aberto, fechado;
    List<Aresta> arestas;
    
    public Nodo(String nome, int heuristica) {
        this.nome = nome;
        this.heuristica = heuristica;
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

    public int getHeuristica() {
        return heuristica;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
    public void addAresta(Nodo novoNodo,int peso)
    {
        Aresta novaAresta = new Aresta(peso,novoNodo);
        arestas.add(novaAresta);
    }

    public List<Aresta> getArestas() {
        return arestas;
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
