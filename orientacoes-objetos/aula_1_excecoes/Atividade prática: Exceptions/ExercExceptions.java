import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExercExceptions {
    public static void main(String[] args) {
        ExercExceptions ee = new ExercExceptions();
        ee.lerArquivo();
    }

    public void lerArquivo(){
        try{
            System.out.println("Digite o nome do arquivo [.CSV]: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String arqEntrada = reader.readLine();
            String linha;
            while((linha = arqEntrada) != null){
                System.out.println(linha + "\n");
            }
        }catch(Exception e1){
            System.out.println("Erro inesperado.");
            System.out.println("Descrição do erro: " + e1.getMessage());
        }

    }
}
