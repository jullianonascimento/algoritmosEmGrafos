/* TAD utilizado baseado no livro Projeto de Algoritmos do Nivio Ziviani
Cria grafo vazio
Insere nó
Insere aresta
Remove nó --- ainda não tem
Remove aresta
Existe aresta
Imprime nó
Imprime Matriz de Adjacencia
Imprime vizinhos de um nó
Imprime Lista de Adjacencia
Exporta para arquivo
Importa do arquivo ----- ainda não tem
 */

package example;

import java.io.IOException;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        // Lets create nodes as given as an example in the article
        Node nA = new Node('A');
        Node nB = new Node('B');
        Node nC = new Node('C');
        Node nD = new Node('D');
        Node nE = new Node('E');
        Node nF = new Node('F');

        // Create the graph, add nodes, create edges between nodes
        Graph g = new Graph();
        g.addNode(nA);
        g.addNode(nB);
        g.addNode(nC);
        g.addNode(nD);
        g.addNode(nE);
        g.addNode(nF);
        
        //g.criaGrafoVazio();
        //g.imprimeMatrizAdjacencia();

        g.connectNode(nA, nB);
        g.connectNode(nA, nC);
        g.connectNode(nA, nD);
        g.connectNode(nB, nE);
        g.connectNode(nB, nF);
        g.connectNode(nC, nF);
        
        //System.out.println(g.existeAresta(nA, nD));
        //g.vizinhos(nA);
        
        System.out.println("Matriz de Adjacencia -----");
        g.imprimeMatrizAdjacencia();
        System.out.println("Lista de Adjacencia -----");
        g.imprimeListaAjacencia();
        
        //g.removeAresta(nA, nD);
        //g.vizinhos(nA);
        
        CSV csv = new CSV();
        csv.escreveMatrizEmCSV(g.adjMatrix, g.nodes, "grafo3.csv");

        // Perform the traversal of the graph
        g.setRootNode(nA);
        System.out.println("BFS - Busca em Largura --------");
        g.bfs();
        
        System.out.println("\nDFS - Busca em Profundidade --------");
        g.dfs();
         
    }
}
