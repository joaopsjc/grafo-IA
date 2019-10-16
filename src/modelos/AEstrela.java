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
        Aresta arestaMenor = new Aresta(0, nodoInicial);
        abertos.add(arestaMenor);//adiciona o inicial a lista de abertos
        
        while(arestaMenor.getNodo() != nodoFinal)
        {
            addFilhos(arestaMenor);//adiciona seus filhos a lista de abertos
            fechados.add(arestaMenor);//adiciona o elemento a lista de fechados
            abertos.remove(arestaMenor);//remove o elemento fechado da lista de abertos
            arestaMenor.getNodo().setFechado(true);//sinlizador de que o elemento está na lista de fechados
            arestaMenor.getNodo().setAberto(false);//sinlizador de que o elemento está na lista de fechados
            arestaMenor = abertos.get(0);//pega o primeiro elemento da lista(o de menor custo)
        }
    }
    //adiciona os nos filhos à lista de abertos na ordem ascendente
    private void addFilhos(Aresta arestaPai)
    {
        //pega todas os nós aos quais ele está conectado
        List<Aresta> arestasFilhas = arestaPai.getNodo().getArestas();
        Iterator<Aresta> arestasIterator = arestasFilhas.iterator();
        
        while(arestasIterator.hasNext())
        {
            Aresta arestaAtual = arestasIterator.next();
            
            
            //cria nova aresta para lista de abertos
            int novoPeso = arestaAtual.getPeso() + arestaPai.getPeso();// peso é igual ao pesso do pai + o do filho
            Nodo nodo = arestaAtual.getNodo();
            Aresta novaAresta = new Aresta(novoPeso,nodo);
 
            //pega posicao a qual ela será adicionada
            int posicaoAdicionar = findPosition(novaAresta);
            
            //se o nó não estiver na lista de fechados e não estiver na lista de abertos
            if(!novaAresta.getNodo().isFechado() && !novaAresta.getNodo().isAberto() )
            {
                abertos.add(posicaoAdicionar, novaAresta);
                nodo.setAberto(true);
            }
            // se o nó estiver na lista de aberto mas não está na lista de fechados
            else if(!novaAresta.getNodo().isFechado())
            //else if(!novaAresta.getNodo().isFechado() && novaAresta.getNodo().isAberto()) possuem a mesma funcionalidade neste contexto
            {
                int posicaoConcorrente = findEquals(novaAresta);
                //se o no antigo está em uma posicao maior, significa que ele custa mais que o novo e precisa ser removido
                //caso contrário, não faz nada
                if(posicaoConcorrente > posicaoAdicionar)
                {
                    //deleta antiga(PRECISA REMOVER ANTES DE ADICIONAR, OU deletará o nó incorreto)
                    abertos.remove(abertos.get(posicaoConcorrente));
                    //adiciona nova aos abertos
                    abertos.add(posicaoAdicionar, novaAresta);
                }
            }
        }
    }
    //acha a posição a qual o novo nó será adicionado
    private int findPosition(Aresta novaAresta)
    {
        Iterator<Aresta> arestasIterator = abertos.iterator();
        int posicaoAdicionar=0;
        while(arestasIterator.hasNext())
        {
            Aresta arestaAtual = arestasIterator.next();
            //se o nó atual tiver um custo menor e não for fechado
            if(!arestaAtual.getNodo().isFechado() && (arestaAtual.getNodo().getHeuristica()+arestaAtual.getPeso() > novaAresta.getNodo().getHeuristica()+novaAresta.getPeso()))
            {
                break;
            }
            posicaoAdicionar++;
        }
        return posicaoAdicionar;
    }
    //acha a posição repetida para escolher qual podar
    private int findEquals(Aresta novaAresta)
    {
        Iterator<Aresta> arestasIterator = abertos.iterator();
        int posicaoAdicionar=0;
        while(arestasIterator.hasNext())
        {
            Aresta arestaAtual = arestasIterator.next();
            if(arestaAtual.getNodo().equals(novaAresta.getNodo()))
            {
                break;
            }
            posicaoAdicionar++;
        }
        return posicaoAdicionar;
    }
}
