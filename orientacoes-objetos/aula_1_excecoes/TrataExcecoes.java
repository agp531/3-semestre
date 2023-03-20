import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoes {
    public static void main(String[] args) {
        TrataExcecoes tr1 = new TrataExcecoes();
        tr1.lerArquivo();
    }

    public void lerArquivo(){
        try{
            String arqEntrada = "arqaa.txt";
            BufferedReader arq = new BufferedReader(new FileReader(arqEntrada));
            String linha;
            while((linha = arq.readLine()) != null){
                System.out.println(linha + "\n");
            }
            arq.close();
        }catch(FileNotFoundException exp1){
            System.out.println("Arquivo não encontrado " + exp1.getMessage());
        }catch(IOException exp2){
            System.out.println("Erro de leitura de arquivo");   
        }catch(Exception exp3){
            System.out.println("Erro inesperado.");
            System.out.println("Descrição do erro: " + exp3.getMessage());
        }finally{//Executado sempre
            System.out.println("Encerrando");
        }
        
    }
}
