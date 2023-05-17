import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoShow {
    
    private Connection conn;
    private Statement st;

    //conecta com o banco
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

    //desconecta do banco
    private void desconectar(){
        try {
            st .close();
            conn.close();
        }catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    //insere novo show no db
    public boolean inserir(Shows show){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO tb_shows (cod_show, artista, cache, data,"
                + "valorIngresso, quantidadePublico)"
                + "VALUES (NULL, ? , ?, ? , ? , ? )",
                Statement.RETURN_GENERATED_KEYS
            );
            
            pst.setString(1, show.getArtista());
            pst.setDouble(2, show.getCache());
            pst.setString(3, show.getData());
            pst.setDouble(4, show.getValorIngresso());
            pst.setInt(5, show.getQuatidadePublico());
            pst.executeUpdate();
            resultado = true;            
        } catch (Exception e) {
            System.out.println("Erro ao inserir show: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    //busca tdos os shows cadastrados no db.
    public ArrayList<Shows> buscarTodos(){
        ArrayList<Shows> resultados = new ArrayList<Shows>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_shows");

            while(rs.next()){
                Shows show = new Shows();
                show.setCodigo(rs.getInt("codigo"));
                show.setArtista(rs.getString("artista"));
                show.setCache(rs.getDouble("cache"));
                show.setData(rs.getString("data"));
                show.setValorIngresso(rs.getDouble("valorIngresso"));
                show.setQuatidadePublico(rs.getInt("quantidadePublico"));
            
                resultados.add(show);
            }           
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;
    }

    //consultar apenas um show pelo id 
    public Shows buscarUm(int cod){
        Shows show = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_shows WHERE codigo = " + cod + ";");
            if(rs.next()){
                show = new Shows();
                show.setCodigo(rs.getInt("codigo"));
                show.setArtista(rs.getString("artista"));
                show.setCache(rs.getDouble("cache"));
                show.setData(rs.getString("data"));
                show.setValorIngresso(rs.getDouble("valorIngresso"));
                show.setQuatidadePublico(rs.getInt("quantidadePublico"));
            }       
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return show;
    }

    //alterar os dados do show
    public int alterar(Shows s){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_shows SET "
                + "artista = '" + s.getArtista() + "' ,"
                + "cache = '" + s.getCache() + "' ,"
                + "data = '" + s.getData() + "' ,"
                + "valorIngresso = " + s.getValorIngresso() + "' ,"
                + "quantidadePublico = " + s.getQuatidadePublico()
                + " WHERE codigo = " + s.getCodigo() + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao alterar dados: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

    //excluir show da db;
    public int excluir (int cod){
        int qtde = 0;
        try {
            this.conectar();            
            PreparedStatement pstShow = conn.prepareStatement(
                "DELETE FROM tb_shows WHERE codigo = ?"
            );
            pstShow.setInt(1, cod);
            pstShow.executeUpdate();
            qtde = pstShow.getUpdateCount();    
        } catch (Exception e) {
            System.out.println("Erro ao excluir show: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

}
