/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSV {

    /*
     *Ecreve uma matriz no arquivo .csv 
     */
    public void escreveMatrizEmCSV(int[][] matriz, ArrayList nodes, String path) throws IOException {

        File file = new File(path);

        if (!file.exists()) {

            file.createNewFile();

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

       
                  
        //primeira iteração é apenas pra criar as colunas
        for(char i = 0; i < matriz.length; i++){
        
            writer.write(";");
            Node no = (Node) nodes.get(i);
            char letra = no.label;
            writer.write(letra);
            
        
        }
                
         writer.write("\n");
         
         
         //pra auxiliar a impressão
         String aux;
        
        //perrcorre a matriz pra imprimir os valores
        for (int i = 0; i < matriz.length; i++) {

            Node no = (Node) nodes.get(i);
            char letra = no.label;
            writer.write(letra);
            
            for (int j = 0; j < matriz.length; j++) {
                
                //considera que é uma matriz de incidencia, pode ser melhorado
                if(matriz[i][j] == 1){
                
                    aux = matriz[i][j] + ".0";
                    
                }else{
                
                    aux = "0";
                
                }

                writer.write(";" +aux);

            }
            writer.write("\n");
        }

        writer.close();

    }
}
