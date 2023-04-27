// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorClientePJ {
    Scanner scanner;
    DaoClientePJ daoClientePJ;

    public GerenciadorClientePJ(){
        scanner = new Scanner(System.in);
        daoClientePJ = new DaoClientePJ();
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
                    // this.buscarUm(); 
                    break;
                case 3:
                    // this.alterar();
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
        ClientePJ cliPJ = new ClientePJ();
        System.out.println("-------------------------");
        System.out.println("[Cadastro de Cliente PJ]");
        System.out.println("Nome: ");
        cliPJ.setNome(scanner.nextLine()); 
        System.out.println("CNPJ: ");
        cliPJ.setCnpj(scanner.nextLine());

        EnderecoPJ endPJ = new EnderecoPJ();
        System.out.println("[Endereço]");
        System.out.println("Rua: ");
        endPJ.setRua(scanner.nextLine());
        System.out.println("Numero: ");
        endPJ.setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.println("Bairro: ");
        endPJ.setBairro(scanner.nextLine());
        System.out.println("CEP: ");
        endPJ.setCep(scanner.nextLine());

        cliPJ.setEnderecoPJ(endPJ);
        //passa o objeto para a camada model
        boolean inserido = daoClientePJ.inserir(cliPJ);
        if(inserido){
            System.out.println("ClientePJ inserido com sucesso.");
        }
    }

    public void listarTodos(){
        ArrayList<ClientePJ> resultado = daoClientePJ.buscarTodos();
        System.out.println("=================");
        System.out.println("Clientes PJ cadastrados");
        for(ClientePJ cli : resultado){
            System.out.println("Código: " + cli.getCodigoCLientePJ()
                + " Nome: " + cli.getNome()
                + " CNPJ: " + cli.getCnpj());

            System.out.println("      [Endereço] " + "\n"
                + "Rua: " + cli.getEnderecoPJ().getRua() + "\n"
                + "Numero: : " + cli.getEnderecoPJ().getNumero()+ "\n"
                + "Bairro: : " + cli.getEnderecoPJ().getBairro()+ "\n"
                + "CEP: : " + cli.getEnderecoPJ().getCep());
        }
        System.out.println("=================");
    }
    
    public void excluir(){
        System.out.println("=================");
        System.out.println("Exclusao de ClientePJs");
        System.out.println("Informe o codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        int qtde = daoClientePJ.excluir(codigo);
        if(qtde > 0){
            System.out.println("ClientePJ excluido com sucesso!");
        }else{
            System.out.println("Nenhum ClientePJ encontrado..");
        }
        System.out.println("=================");
    }

    // public void buscarUm(){
    //     System.out.println("=================");
    //     System.out.println("Consulta de ClientePJ");
    //     System.out.println("Informe o codigo: ");
    //     int codigo = Integer.parseInt(scanner.nextLine());
    //     ClientePJ v = DaoClientePJ.buscarUm(codigo);
    //     if(v != null){
    //         System.out.println("Marca: " + v.getMarca());
    //         System.out.println("Modelo: " + v.getModelo());
    //         System.out.println("Chassi: " + v.getChassi());
    //         System.out.println("Ano: " + v.getAno());
    //     }else{
    //         System.out.println("Nenhum ClientePJ encontrado..");
    //     }
    //     System.out.println("=================");
    // }

    // public void alterar(){
       
    //     System.out.println("-------------------------");
    //     System.out.println("[Alteração de Veículo]");
    //     System.out.println("Informe o codigo: ");
    //     int codigo = Integer.parseInt(scanner.nextLine());
    //     ClientePJ v = DaoClientePJ.buscarUm(codigo);
    //     if(v!=null){

    //         System.out.println("Dados do ClientePJ");
    //         System.out.println("[CODIGO: "+ v.getCodigo() + "]");

    //         System.out.println("[Marca: " + v.getMarca() + "]");
    //         String marca = scanner.nextLine();
    //         if(!marca.isEmpty()){
    //             v.setModelo(marca);
    //         }

    //         System.out.println("[Modelo: " + v.getModelo() + "]");
    //         String modelo = scanner.nextLine();
    //         if(!modelo.isEmpty()){
    //             v.setModelo(modelo);
    //         }
            
    //         System.out.println("[Chassi: " + v.getChassi() + "]");
    //         String chassi = scanner.nextLine();
    //         if(!chassi.isEmpty()){
    //             v.setModelo(chassi);
    //         }
            
    //         System.out.println("[Ano: " + v.getAno() + "]");
    //         String ano = scanner.nextLine();
    //         if(!ano.isEmpty()){
    //             v.setAno(Integer.parseInt(ano));
    //         }

    //         int qtdeAlterado = DaoClientePJ.alterar(v);
    //         if(qtdeAlterado > 0){
    //             System.out.println("ClientePJ atualizado!");
    //         }

    //     }else{
    //         System.out.println("ClientePJ nao encontrado..");
    //     }

    // }
}
