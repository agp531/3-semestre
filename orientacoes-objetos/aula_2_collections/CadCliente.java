import java.util.ArrayList;
import java.util.Iterator;

public class CadCliente {
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Allan");
        c1.setEmail("asdasd@asdasd.com");
        c1.setCpf("123456");
        lista.add(c1); 

        Cliente c2 = new Cliente();
        c2.setNome("Ana");
        c2.setEmail("asdasd@asdasd.com");
        c2.setCpf("12555");
        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Pedro");
        c3.setEmail("asd@asdasd.com");
        c3.setCpf("112312");
        lista.add(c3);

        System.out.println("Percorrendo a lita: ");
        Iterator<Cliente> it = lista.iterator();
        // lista.iterator() devolve um ponteiro para o iniciio da lista
        while(it.hasNext()){
            Cliente cli = it.next(); // pega o proximo elemento da lista
            System.out.println("Cliente: " + cli.getNome() + "\n"
                + "CPF: " + cli.getCpf() + "\n");
        }

        //remover um item da lista
        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("123456");
        Iterator<Cliente> itRemover = lista.iterator();
        while(itRemover.hasNext()){
            if(itRemover.next().getCpf().equals(cliRemover.getCpf())){
                System.out.println("Removendo cliente..");
                itRemover.remove();
            }    
        }

        for(Cliente cli : lista){
            System.out.println(cli.getNome());
        }

        for(Cliente cli : lista){
            System.out.println(cli.getNome());
            if(cli.getCpf().equals("12555")){
                lista.remove(cli);
            }
        }

        for(Cliente cli : lista){
            System.out.println(cli.getNome());
        }

        
    }
}