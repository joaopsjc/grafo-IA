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
public class AEstrela {
    List<Aresta> abertos,fechados;
    Grafo problema;
    Grafo solucao;
    public AEstrela(Grafo problema) {
        abertos = new LinkedList<>();
        fechados = new LinkedList<>();
        this.problema = problema;
        solucao = new Grafo();
    }
    public void solucionar(String nomeA, String nomeB)
    {
        Nodo nodoInicial = problema.getNodo(nomeA);
        Nodo nodoFinal = problema.getNodo(nomeB);
        Aresta arestaMenor = new Aresta(0, 0, nodoInicial);
        abertos.add(arestaMenor);
        //Iterator<Aresta> abertosIterator = abertos.iterator();
        
        while(arestaMenor.getNodo() != nodoFinal)
        {
            Aresta proximaAresta = addFilhos(arestaMenor);
            fechados.add(arestaMenor);
            arestaMenor.getNodo().setFechado(true);
            arestaMenor = proximaAresta;
        }
    }
    //adiciona os nos filhos à lista de abertos
    private Aresta addFilhos(Aresta arestaPai)
    {
        List<Aresta> arestasFilhas = arestaPai.getNodo().getArestas();
        Iterator<Aresta> aresta = arestasFilhas.iterator();
        Aresta arestaMenor = null;
        
        while(aresta.hasNext())
        {
            Aresta arestaAtual = aresta.next();
            
            int novoPeso = arestaAtual.getPeso() + arestaPai.getPeso();
            int heuristica = arestaAtual.getHeuristica();
            Nodo nodo = arestaAtual.getNodo();
            Aresta novaAresta = new Aresta(novoPeso, heuristica,nodo);
            
            if(arestaMenor==null)
            {
                arestaMenor = novaAresta;
            }
            else if(arestaMenor.getPeso() + arestaMenor.getHeuristica() > novoPeso+heuristica)
            {
                arestaMenor = novaAresta;
            }
            
            if(!novaAresta.getNodo().isFechado() && !novaAresta.getNodo().isAberto() )
            {
                nodo.setAberto(true);
                abertos.add(novaAresta);
            }
            else if(!novaAresta.getNodo().isFechado() && novaAresta.getNodo().isAberto())
            {
                abertos.add(novaAresta);
            }
        }
        return arestaMenor;
    }
}
