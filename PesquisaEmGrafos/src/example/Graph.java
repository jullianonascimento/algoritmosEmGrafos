package example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Graph {

    public Node rootNode;
    public ArrayList nodes = new ArrayList();
    public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
    int size;

    public void setRootNode(Node n) {
        this.rootNode = n;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    public void addNode(Node n) {
        nodes.add(n);
    }
    
    /*public void removeNode(Node n){
        nodes.remove(n);
    }*/

    public void criaGrafoVazio(){
        size = nodes.size();
        adjMatrix = new int[size][size];
    }
    
    // This method will be called to make connect two nodes
    public void connectNode(Node start, Node end) {
        if (adjMatrix == null) {
            criaGrafoVazio();
        }

        int startIndex = nodes.indexOf(start);
        int endIndex = nodes.indexOf(end);
        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;
    }
    
    public void removeAresta(Node i, Node j){
        int indiceI = nodes.indexOf((Node)i);
        int indiceJ = nodes.indexOf((Node)j);
        if (existeAresta(i,j)){
            adjMatrix[indiceI][indiceJ] = 0;
            adjMatrix[indiceJ][indiceI] = 0;
        }
    }

    private Node getUnvisitedChildNode(Node n) {

        int index = nodes.indexOf(n);
        int j = 0;
        while (j < size) {
            if (adjMatrix[index][j] == 1
                    && ((Node) nodes.get(j)).visited == false) {
                return (Node) nodes.get(j);
            }
            j++;
        }
        return null;
    }

    // BFS traversal of a tree is performed by the bfs() function
    public void bfs() {

        // BFS uses Queue data structure
        Queue q = new LinkedList();
        q.add(this.rootNode);
        printNode(this.rootNode);
        rootNode.visited = true;
        while (!q.isEmpty()) {
            Node n = (Node) q.remove();
            Node child = null;
            while ((child = getUnvisitedChildNode(n)) != null) {
                child.visited = true;
                printNode(child);
                q.add(child);
            }
        }
        // Clear visited property of nodes
        clearNodes();
    }

    // DFS traversal of a tree is performed by the dfs() function
    public void dfs() {
        // DFS uses Stack data structure
        Stack s = new Stack();
        s.push(this.rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
            Node n = (Node) s.peek();
            Node child = getUnvisitedChildNode(n);
            if (child != null) {
                child.visited = true;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        // Clear visited property of nodes
        clearNodes();
    }

    // Utility methods for clearing visited property of node
    private void clearNodes() {
        int i = 0;
        while (i < size) {
            Node n = (Node) nodes.get(i);
            n.visited = false;
            i++;
        }
    }

    // Utility methods for printing the node's label
    private void printNode(Node n) {
        System.out.print(n.label + " ");
    }

    public int[][] getMat() {
        return adjMatrix;
    }
    
    public ArrayList getNodes(){
        return nodes;
    }
    
    public void imprimeMatrizAdjacencia(){
        System.out.print("  ");
        for(int i = 0; i < size; i++){
            Node no = (Node)nodes.get(i);
            char letra = no.label;
            System.out.print(letra + " ");
        }
        System.out.println("");
        
        for (int i = 0; i < size; i++) {
            Node no = (Node)nodes.get(i);
            char letra = no.label;
            System.out.print(letra + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public void imprimeListaAjacencia(){
        for (int i = 0; i < size; i++) {
            Node inicio = (Node)nodes.get(i);
            vizinhos(inicio);
        }
    }
    
    public void vizinhos(Node n){
        System.out.print(n.label+": ");
        for (int j = 0; j < size; j++) { 
            Node p = (Node) nodes.get(j);
            if (existeAresta(n, p)){ // dado um vertice i, verificamos se há aresta entre ele e todos os outros vertices existentes
                System.out.print(p.label+ " ");
            }
        }
        System.out.println("-");
    }
    
    public boolean existeAresta(Node i, Node j){
        int indiceI = nodes.indexOf((Node)i);
        int indiceJ = nodes.indexOf((Node)j);
        if (adjMatrix[indiceI][indiceJ] == 0) // se o elemento é zero não existe aresta
            return false;
        else
            return true;
    }
    
    
    
}
