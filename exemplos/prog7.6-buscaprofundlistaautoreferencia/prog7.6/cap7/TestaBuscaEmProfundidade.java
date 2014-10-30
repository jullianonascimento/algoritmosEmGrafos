package cap7;
import java.io.*;
import cap7.listaadj.autoreferencia.Grafo; // @{\it vide Programa~\ref{prog:estruturaslistaap}}@
public class TestaBuscaEmProfundidade {
  static BufferedReader in = new BufferedReader (
                             new InputStreamReader (System.in));
  public static Grafo.Aresta lerAresta () throws Exception {
    System.out.println ("Aresta:");
    System.out.print ("  V1:");
    int v1 = Integer.parseInt (in.readLine());
    System.out.print ("  V2:");
    int v2 = Integer.parseInt (in.readLine());
    System.out.print ("  Peso:");
    int peso = Integer.parseInt (in.readLine());
    return new Grafo.Aresta (v1, v2, peso);
  }
  public static void main (String[] args) throws Exception {
    System.out.print ("No. vertices:"); 
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    Grafo grafo = new Grafo (nVertices);
    for (int i = 0; i < nArestas; i++) {
      Grafo.Aresta a = lerAresta ();
      // @{\it Duas chamadas porque o grafo \'e n\~ao direcionado}@
      grafo.insereAresta (a.v1 (), a.v2 (), a.peso ());     
      grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
    }
    grafo.imprime ();
    BuscaEmProfundidade dfs = new BuscaEmProfundidade (grafo);
    dfs.buscaEmProfundidade ();
    for (int v = 0; v < grafo.numVertices(); v++) {
      System.out.println ("d["+v+"]:" + dfs.d (v) + " -- t["+v+"]:" + dfs.t (v) +
                          " -- antecessor["+v+"]:" + dfs.antecessor (v));
    }
  }
  
}
