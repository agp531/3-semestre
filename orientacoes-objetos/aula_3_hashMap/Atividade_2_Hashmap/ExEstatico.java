public class ExEstatico {
    
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNome("Nicole");
        System.out.println("Quantidada de clientes = " + c1.qtdClientes);

        Cliente c2 = new Cliente();
        c2.setNome("Allan");
        System.out.println("Quantidada de clientes = " + c2.qtdClientes);

        System.out.println("quantida de clientes = " + c1.qtdClientes);
        System.out.println("quantida de clientes = " + Cliente.qtdClientes);

    }
}
