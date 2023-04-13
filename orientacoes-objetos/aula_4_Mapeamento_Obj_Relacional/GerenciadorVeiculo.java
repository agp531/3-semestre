import java.util.ArrayList;
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
                    this.buscarUm(); 
                    break;
                case 3:
                    this.alterar();
                    break; 
                case 4:
                    this.excluir();
                    break;                
                case 5:
                    this.listarTodos();
                    break;     
                case 0:
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

    public void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();
        System.out.println("=================");
        System.out.println("Veiculos cadastrados");
        for(Veiculo v : veiculos){
            System.out.println("Código: " + v.getCodigo()
                + ", Marca: " + v.getMarca()
                + ", Modelo: " + v.getModelo()
                + ", Chassi: " + v.getChassi()
                + ", Ano: : " + v.getAno());
        }
        System.out.println("=================");
    }
    
    public void excluir(){
        System.out.println("=================");
        System.out.println("Exclusao de veiculos");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        int qtde = daoVeiculo.excluir(codigo);
        if(qtde > 0){
            System.out.println("Veiculo excluido com sucesso!");
        }else{
            System.out.println("Nenhum veiculo encontrado..");
        }
        System.out.println("=================");
    }

    public void buscarUm(){
        System.out.println("=================");
        System.out.println("Consulta de veiculo");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo v = daoVeiculo.buscarUm(codigo);
        if(v != null){
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Chassi: " + v.getChassi());
            System.out.println("Ano: " + v.getAno());
        }else{
            System.out.println("Nenhum veiculo encontrado..");
        }
        System.out.println("=================");
    }

    public void alterar(){
       
        System.out.println("-------------------------");
        System.out.println("[Alteração de Veículo]");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo v = daoVeiculo.buscarUm(codigo);
        if(v!=null){

            System.out.println("Dados do veiculo");
            System.out.println("[CODIGO: "+ v.getCodigo() + "]");

            System.out.println("[Marca: " + v.getMarca() + "]");
            String marca = scanner.nextLine();
            if(!marca.isEmpty()){
                v.setModelo(marca);
            }

            System.out.println("[Modelo: " + v.getModelo() + "]");
            String modelo = scanner.nextLine();
            if(!modelo.isEmpty()){
                v.setModelo(modelo);
            }
            
            System.out.println("[Chassi: " + v.getChassi() + "]");
            String chassi = scanner.nextLine();
            if(!chassi.isEmpty()){
                v.setModelo(chassi);
            }
            
            System.out.println("[Ano: " + v.getAno() + "]");
            String ano = scanner.nextLine();
            if(!ano.isEmpty()){
                v.setAno(Integer.parseInt(ano));
            }

            int qtdeAlterado = daoVeiculo.alterar(v);
            if(qtdeAlterado > 0){
                System.out.println("Veiculo atualizado!");
            }

        }else{
            System.out.println("Veiculo nao encontrado..");
        }

    }
}
