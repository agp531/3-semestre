public class Cliente {
    private String nome;
    private String email;
    public static int qtdClientes;

    public Cliente(){
        qtdClientes++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
