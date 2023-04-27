import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class DaoClientePJ {
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

    public boolean inserir(ClientePJ cli){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO tb_clientes_pj (cod_cli_pj, nome, cnpj)"
                + "VALUES (NULL, ? , ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            pst.setString(1, cli.getNome());
            pst.setString(2, cli.getCnpj());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int idCliente = 0;
            if(rs.next()){
                idCliente = rs.getInt(1);
                PreparedStatement pstEnd = conn.prepareStatement(
                  "INSERT INTO tb_enderecos_pj (cod_end, cod_cli_pj,"
                  + "rua, numero, bairro, cep)"
                  + "VALUES (NULL, ?, ?, ?, ?, ?);"  
                );

                pstEnd.setInt(1, idCliente);
                pstEnd.setString(2, cli.getEnderecoPJ().getRua());
                pstEnd.setInt(3, cli.getEnderecoPJ().getNumero());
                pstEnd.setString(4, cli.getEnderecoPJ().getBairro());
                pstEnd.setString(5, cli.getEnderecoPJ().getCep());
                pstEnd.executeUpdate();
                resultado = true;
                
            }

            
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }
    
    public ArrayList<ClientePJ> buscarTodos(){
        ArrayList<ClientePJ> resultados = new ArrayList<ClientePJ>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_clientes_pj as c, tb_enderecos_pj as e"
                +" WHERE c.cod_cli_pj = e.cod_cli_pj order by c.nome;"
                );

            while(rs.next()){
                ClientePJ cli = new ClientePJ();
                cli.setCodigoCLientePJ(rs.getInt("cod_cli_pj"));
                cli.setNome(rs.getString("nome"));
                cli.setCnpj(rs.getString("cnpj"));
               
                EnderecoPJ endPJ = new EnderecoPJ();
                endPJ.setCodigo(rs.getInt("cod_end"));
                endPJ.setRua(rs.getString("rua"));
                endPJ.setNumero(rs.getInt("numero"));
                endPJ.setBairro(rs.getString("bairro"));
                endPJ.setCep(rs.getString("cep"));

                cli.setEnderecoPJ(endPJ);
                resultados.add(cli);
            }           
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;
    }
    
    public ClientePJ buscarUm(int cod){
        ClientePJ cli = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_Clientes_pj WHERE cod_cli_pj = ? ");
            if(rs.next()){
                cli = new ClientePJ();
                cli.setCodigoCLientePJ(rs.getInt("codigo"));
                cli.setNome("nome");
                cli.setCnpj("cnpj");
                cli.getEnderecoPJ().
                cli.setModelo(rs.getString("modelo"));
                cli.setChassi(rs.getString("chassi"));a
                cli.setAno(rs.getInt("ano"));
            }           
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return cli;
    }
    // public int alterar(ClientePJ v){
    //     int qtde = 0;
    //     try {
    //         this.conectar();
    //         String comando = "UPDATE tb_ClientePJs SET "
    //             + "marca = '" + v.getMarca() + "' ,"
    //             + "modelo = '" + v.getModelo() + "' ,"
    //             + "chassi = '" + v.getChassi() + "' ,"
    //             + "ano = " + v.getAno()
    //             + " WHERE codigo = " + v.getCodigo() + ";";
    //         System.out.println(comando);
    //         st.executeUpdate(comando);
    //         qtde = st.getUpdateCount();
    //     } catch (Exception e) {
    //         System.out.println("Erro ao inserir registro: " + e.getMessage());
    //     }finally{
    //         this.desconectar();
    //     }
    //     return qtde;
    // }





    


    public int excluir (int cod){
        int qtde = 0;
        try {
            this.conectar();
            
            PreparedStatement pstEnd = conn.prepareStatement(
                "DELETE FROM tb_enderecos_pj WHERE cod_cli_pj = ?"
            );
            pstEnd.setInt(1, cod);
            pstEnd.executeUpdate();
            
            PreparedStatement pstCli = conn.prepareStatement(
                "DELETE FROM tb_clientes_pj WHERE cod_cli_pj = ?"
            );
            pstCli.setInt(1, cod);
            pstCli.executeUpdate();
            qtde = pstCli.getUpdateCount();    
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

}
