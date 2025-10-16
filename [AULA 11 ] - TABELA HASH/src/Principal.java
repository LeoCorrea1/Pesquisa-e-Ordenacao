
import java.util.HashSet;
import java.util.Scanner;

class Aluno{
    int matricula;
    String nome;

    public Aluno ( int matricula , String nome ) {
    this.matricula = matricula;
    this.nome = nome;
  }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.matricula;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return this.matricula == other.matricula;
    }


    
    
}

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        HashSet<Aluno> tabela = new HashSet<Aluno>();
        String nome;
        int matricula;
        int endereço;
        Aluno aluno;

        for ( int i =0 ; i < 5 ; i++){
            System.out.println("Nome :");
            nome = teclado.nextLine();
            
            System.out.println("matricula : ");
            matricula = teclado.nextInt();
            aluno = new Aluno (matricula,nome);
            
            int endereco = aluno.hashCode();

            if (!tabela.add(aluno)){
                System.out.println("Aluno ja inserido " + aluno + " Endereco " + endereco);
                
            } 
            else {
                System.out.println("Aluno : " + aluno + "Endereco : " + endereco);
            }
            
            teclado.nextLine() ;
        }
        System.out.println("monstrndo a tabela :");
        for ( Aluno item : tabela){
            System.out.println(item);
        }

        //        Random gerador = new Random();
//        HashSet<Integer> tabela = new HashSet<Integer>();
//        
//        for ( int i =0 ; i < 5 ; i++){
//            int numero = gerador.nextInt(20);
//            int endereco = (""+numero).hashCode();
//            System.out.println("Numero : " + numero + " Endereco : " + endereco);
//            
//            if (!tabela.add(numero)){
//                System.out.println("Numero ja inserido " +numero + " Endereco : " + endereco);
//                
//            }        
//        }
//        for ( Integer item : tabela){
//            System.out.println(item);
//        }

    }
    
}
