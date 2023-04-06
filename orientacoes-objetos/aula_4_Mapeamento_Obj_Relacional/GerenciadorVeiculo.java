import java.util.Scanner;

public class GerenciadorVeiculo {
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = -1;
        while(opcao != 0){
            System.out.println("\n-------------------------");
            System.out.println("   | MENU PRINCIPAL |      ");
            System.out.println("[1] Cadastrar              ");
            System.out.println("[2] Consultar              ");
            System.out.println("[3] Alterar                ");
            System.out.println("[4] Excluir                ");
            System.out.println("[5] Listar todos           ");
            System.out.println("[0] Voltar ao menu anterior");
            System.out.println("\n-------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Erro.. informe um numero inteiro" + e.getMessage());
            }

            switch (opcao) {

                case 1:
                    this.cadastrar();
                    break;
                case 2:  
                    break;
                case 3:
                    
                    break; 
                case 4:
                    
                    break;                
                case 5:
                    
                    break;     
                case 6:
                    break;
            
                default:
                    System.out.println("Opcao Invalida.");
                    break;
            }
        }
    }

    public void cadastrar(){
        Veiculo v = new Veiculo();
        System.out.println("-------------------------");
        System.out.println("[Cadastro de Veículo]");
        System.out.println("Marca: ");
        v.setMarca(scanner.nextLine()); 
        System.out.println("Modelo: ");
        v.setModelo(scanner.nextLine()); 
        System.out.println("Chassi: ");
        v.setChassi(scanner.nextLine());
         System.out.println("Ano: ");
        v.setAno(Integer.parseInt(scanner.nextLine()));

        //passa o objeto para a camada model
        boolean inserido = daoVeiculo.inserir(v);
        if(inserido){
            System.out.println("Veiculo inserido com sucesso.");
        }
    }   

    public void consultar(){

    }
}
