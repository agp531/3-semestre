import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente {
    
    Scanner scanner;
    DaoCliente daoCliente;


    public GerenciadorCliente(){
        scanner = new Scanner(System.in);
        daoCliente = new DaoCliente();
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
        Cliente c = new Cliente();
        System.out.println("-------------------------");
        System.out.println("[Cadastro de Cliente]");
        System.out.println("Nome: ");
        c.setNome(scanner.nextLine()); 
        System.out.println("Cnh: ");
        c.setCnh(Integer.parseInt(scanner.nextLine())); 
        System.out.println("Telefone: ");
        c.setTelefone(scanner.nextLine());
         System.out.println("Endereco: ");
        c.setEndereco(scanner.nextLine());

        //passa o objeto para a camada model
        boolean inserido = daoCliente.inserir(c);
        if(inserido){
            System.out.println("Cliente inserido com sucesso.");
        }
    }
    
    public void buscarUm(){
        System.out.println("=================");
        System.out.println("Consulta de cliente");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Cliente c = daoCliente.buscarUm(codigo);
        if(c != null){
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cnh: " + c.getCnh());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Endereco: " + c.getEndereco());
        }else{
            System.out.println("Nenhum cliente encontrado..");
        }
        System.out.println("=================");
    }

    public void listarTodos(){
        ArrayList<Cliente> clientes = daoCliente.buscarTodos();
        System.out.println("=================");
        System.out.println("Clientes cadastrados");
        for(Cliente c : clientes){
            System.out.println("Código: " + c.getCodigo()
                + ", Nome: " + c.getNome()
                + ", Cnh: " + c.getCnh()
                + ", Telefone: " + c.getTelefone()
                + ", Endereco: : " + c.getEndereco());
        }
        System.out.println("=================");
    }

    public void excluir(){
        System.out.println("=================");
        System.out.println("Exclusao de clientes");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        int qtde = daoCliente.excluir(codigo);
        if(qtde > 0){
            System.out.println("Cliente excluido com sucesso!");
        }else{
            System.out.println("Nenhum cliente encontrado..");
        }
        System.out.println("=================");
    }



    public void alterar(){
       
        System.out.println("-------------------------");
        System.out.println("[Alteração de Veículo]");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Cliente c = daoCliente.buscarUm(codigo);
        if(c!=null){

            System.out.println("Dados do veiculo");
            System.out.println("[CODIGO: "+ c.getCodigo() + "]");

            System.out.println("[Nome: " + c.getNome() + "]");
            String nome = scanner.nextLine();
            if(!nome.isEmpty()){
                c.setNome(nome);
            }

            System.out.println("[Cnh: " + c.getCnh() + "]");
            String cnh = scanner.nextLine();
            if(!cnh.isEmpty()){
                c.setCnh(Integer.parseInt(cnh));
            }
            
            System.out.println("[Telefone: " + c.getTelefone() + "]");
            String telefone = scanner.nextLine();
            if(!telefone.isEmpty()){
                c.setTelefone(telefone);
            }
            
            System.out.println("[Endereco: " + c.getEndereco() + "]");
            String endereco = scanner.nextLine();
            if(!endereco.isEmpty()){
                c.setEndereco(endereco);
            }

            int qtdeAlterado = daoCliente.alterar(c);
            if(qtdeAlterado > 0){
                System.out.println("Cliente atualizado!");
            }

        }else{
            System.out.println("Cliente nao encontrado..");
        }

    }






}
