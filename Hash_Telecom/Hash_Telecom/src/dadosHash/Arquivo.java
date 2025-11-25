/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dadosHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author laboratorio
 */
public class Arquivo {

    public HashMap<String,String> ler(String caminho){
        
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            
            HashMap<String,String> hashM = new HashMap<>();
            String[] spliT;
                    
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                linha = linha.replace(" ","");
                spliT = linha.split(";");
                hashM.put(spliT[0],spliT[1]);
            }
            
            if (hashM.isEmpty()) return null;
            
            return hashM;
            
        } catch (IOException e) {
            return null;
        }

    }

}

