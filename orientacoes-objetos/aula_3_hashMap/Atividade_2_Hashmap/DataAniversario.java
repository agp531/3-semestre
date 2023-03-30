import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class DataAniversario {
    BufferedReader reader;
    HashMap<String,ArrayList<String>> aniversarios;


    public static void main(String[] args) {
        
    }


    public void menu() throws IOException{
        String opcao = "";
        while(!opcao.equals("5")){
            System.out.println("-----------------------------------");
            System.out.println("|        Assistência técnica       |");
            System.out.println("| [1] Cadastrar Aeroporto          |");
            System.out.println("| [2] Listar Aeroportos            |");
            System.out.println("| [3] Remova um Aeroporto          |");
            System.out.println("| [4] Detalhes do Aeroporto        |");
            System.out.println("| [5] Sair                         |");
            System.out.println("-----------------------------------");

            System.out.println("Informe a opcao: ");
            opcao = this.reader.readLine();

            try {
                switch(opcao){
                    case "1":

                    break;

                    case "2":

                    break;

                    case "3":
                }
            } catch (Exception e) {
               System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
