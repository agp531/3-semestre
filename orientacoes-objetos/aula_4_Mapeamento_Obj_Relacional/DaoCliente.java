import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCliente {

    private Connection conn;
    private Statement st;


    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar(){
        try {
            st .close();
            conn.close();
        }catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public boolean inserir(Cliente c){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_clientes VALUES(NULL,"
                + "'" + c.getNome() + "', '" + c.getCnh() + "', '"
                + c.getTelefone() + "', '" + c.getEndereco() + "');";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public int alterar(Cliente c){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_clientes SET "
                + "nome = '" + c.getNome() + "' ,"
                + "cnh = '" + c.getCnh() + "' ,"
                + "telefone = '" + c.getTelefone() + "' ,"
                + "endereco = " + c.getEndereco()
                + " WHERE codigo = " + c.getCodigo() + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

    public Cliente buscarUm(int cod){
        Cliente c = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes WHERE codigo = " + cod + ";");
            if(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setCnh(rs.getInt("cnh"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
            }           
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return c;
    }

    public ArrayList<Cliente> buscarTodos(){
        ArrayList<Cliente> resultados = new ArrayList<Cliente>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes ORDER BY nome;");
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setCnh(rs.getInt("cnh"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));

                resultados.add(c);
            }           
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;
    }

    public int excluir (int cod){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_clientes WHERE codigo = " + cod + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();    
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }


}
