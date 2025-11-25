/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dadosHash;

import java.util.HashMap;

/**
 *
 * @author laboratorio
 */
public class HashM {
    
    private HashMap<String,String> dados;

    public HashM(){};
    
    public HashM(HashMap<String,String> dados) {
        this.dados = dados;
    }
    
    public String buscar(String telefone){
        
        return dados.get(telefone);
        
    }
    
}
