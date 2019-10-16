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
public class Grafo {
    List<Nodo> nodos;
    int quantNodos;

    public Grafo() {
        nodos = new LinkedList<>();
        quantNodos =0;
    }
    public boolean addNodo(String nome, int heuristica)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            if(nome.equals(nodo.getNome()))
            {
                return false;
            }
        }
        quantNodos++;
        nodos.add(new Nodo(nome,heuristica));
        return true;
    }
    public boolean removeNodo(String nome)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        Nodo nodoRemover=null;
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            
            if(nome.equals(nodo.getNome()))
            {
                nodoRemover = nodo;
            }
        }
        if(nodoRemover==null)
        {
            return false;
        }
        else
        {
            nodoAtual = nodos.iterator();
            while(nodoAtual.hasNext())
            {
                Nodo nodo = nodoAtual.next();
                nodo.removeAresta(nodoRemover);
            }
            quantNodos--;
            nodos.remove(nodoRemover);
            return true;
        }
        
    }

    public boolean addAresta(String nomeA,String nomeB, int peso, int Heuristica)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        Nodo nodoA=null,nodoB=null;
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            if(nomeA.equals(nodo.getNome()))
            {
                nodoA = nodo;
            }
            else if(nomeB.equals(nodo.getNome()))
            {
                nodoB = nodo;
            }
        }
        if(nodoA==null||nodoB==null)//se um dos dois nodos não existem, retorna que a operação foi incorreta
        {
            return false;
        }
        else
        {
            nodoA.addAresta(nodoB, peso);
            return true;
        }
    }
    public boolean removeAresta(String nomeA,String nomeB)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        Nodo nodoA=null,nodoB=null;
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            if(nomeA.equals(nodo.getNome()))
            {
                nodoA = nodo;
            }
            else if(nomeB.equals(nodo.getNome()))
            {
                nodoB = nodo;
            }
        }
        if(nodoA==null||nodoB==null)
        {
            return false;
        }
        else
        {
            nodoA.removeAresta(nodoB);
            return true;
        }
    }
    public List<Aresta> getArestas(String nome)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            if(nome.equals(nodo.getNome()))
            {
                return nodo.getArestas();
            }
        }
        return null;
    }
    public Nodo getNodo(String nome)
    {
        Iterator<Nodo> nodoAtual = nodos.iterator();
        while(nodoAtual.hasNext())
        {
            Nodo nodo = nodoAtual.next();
            if(nome.equals(nodo.getNome()))
            {
                return nodo;
            }
        }
        return null;
    }
    public List<Nodo> getListaNodo()
    {
        return nodos;
    }
}
