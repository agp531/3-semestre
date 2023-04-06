import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }

    public void menuPrincipal(){
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        while(opcao != 0){
            System.out.println("\n------------------------");
            System.out.println("   | MENU PRINCIPAL |     ");
            System.out.println("[1] Gerenciar Veiculos    ");
            System.out.println("[2] Gerenciar Cliente     ");
            System.out.println("[0] Sair                  ");
            System.out.println("\n------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Erro.. informe um numero inteiro" + e.getMessage());
            }

            switch (opcao) {

                case 1:
                    GerenciadorVeiculo aux = new GerenciadorVeiculo();
                    aux.menu();
                    break;  
                
                case 2:
                    
                    break;
                
                case 0:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opcao Invalida.");
                    break;
            }
        }
    }
}
