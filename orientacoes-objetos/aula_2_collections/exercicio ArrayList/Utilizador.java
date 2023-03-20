import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilizador {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String opcao = "";
        while(!opcao.equals("3")){
            System.out.println("-----------------------------------");
            System.out.println("|       Assistência técnica       |");
            System.out.println("|[1] Cliente                      |");
            System.out.println("|[2] Orçamento                    |");
            System.out.println("|[3] Sair                         |");
            System.out.println("-----------------------------------");
    
                opcao = reader.readLine();
                switch(opcao){
                    case "1":
                        
                        break;
                    case "2":
                       
                        break;
                    default:
                        break;
                }
        }
    }
}
