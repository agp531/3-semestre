import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CadAeroportos {

    public static HashMap<String,Aeroporto> aeroportos = new HashMap<String,Aeroporto>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        
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
            opcao = reader.readLine();

                switch(opcao){

                    case "1":
                        Aeroporto aeroporto = new Aeroporto();
                        System.out.println("| CADASTRO DE AEROPORTO |");
                        System.out.println("Insira o nome: ");
                        aeroporto.setNome(reader.readLine());
                        System.out.println("Informe cidade: ");
                        aeroporto.setNome(reader.readLine());
                        System.out.println("Informe a altitude: ");
                        aeroporto.setAltitude(Double.parseDouble(reader.readLine()));
                        System.out.println("Informe a sigla do Aeroporto: ");
                        String chave = reader.readLine();
                        aeroportos.put(chave,aeroporto);          
                    break;

                    case "2":
                        for(String key : aeroportos.keySet()){
                            System.out.println(key);
                        }
                    break;

                    case "3":
                        System.out.println("\t| REMOÇÃO DE AEROPORTO |");
                        System.out.println("Informe a sigla do Aeroporto que deseja remover: ");
                        String sigla = reader.readLine();
                        if(aeroportos.containsKey(sigla)){
                            aeroportos.remove(sigla);
                            System.out.println("Aeroporto removido com sucesso! ");
                        }                    
                    break;

                    case "4":
                        System.out.println("Informe a sigla do Aeroporto: ");
                        String siglaConsulta = reader.readLine(); 
                        if(aeroportos.containsKey(siglaConsulta)){
                            Aeroporto aux = aeroportos.get(siglaConsulta);
                            System.out.println("Nome: " + aux.getNome());
                            System.out.println("Cidade: " + aux.getCidade());
                            System.out.println("Altitude: " + aux.getAltitude());
                        }else{
                            System.out.println("Aeroporto não encontrado! ");
                        }
                    break;
                }

                



        }
    }
}
