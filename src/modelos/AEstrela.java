/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre William
 */
public class AEstrela {
    List<Nodo> abertos,fechados;
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
    }
}
