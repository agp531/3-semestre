import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LancaExcecao{
    public static void main(String[] args) throws Exception {
        LancaExcecao le = new LancaExcecao();
        le.lerArquivo();
    }

    public void lerArquivo() throws FileNotFoundException, IOException{
        String arqEntrada = "arq.txt";
        BufferedReader arq = new BufferedReader(new FileReader(arqEntrada));
        String linha;
        while((linha = arq.readLine()) != null){
            System.out.println(linha + "\n");
        }
        arq.close();
    }
}

