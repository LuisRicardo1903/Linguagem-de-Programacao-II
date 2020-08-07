package gerenciamentoos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MySQL {

    private Connection c;

    public Connection getConnection() {
        return c;
    }

    public int conectar(String IP, String porta, String database, String usuario, String senha) {
        int conexao = 0;
        try {
            String url = "jdbc:mysql://" + IP + ":" + porta + "/" + database + "?user=" + usuario + "&password=" + senha;;
            System.out.println(url);
            c = (Connection) DriverManager.getConnection(url);
            System.out.println("Conectado!");
            conexao = 1;
        } catch (Exception e) {
        }
        return conexao;
    }

    public int inserir(OS os) {
        int resultado = 0;
        try {
            String query = "INSERT INTO servico (cliente, descricao, data, valor, situacao) "
                    + "values ('" + os.cliente + "', '" +  os.descricao + "', '" + os.data + "', '"
                    + os.valor + "', '" + os.situacao + "')";
            Statement st = (Statement) c.createStatement();
            resultado = st.executeUpdate(query);
        } catch (Exception e) {
        }
        return resultado;
    }

    public ResultSet consultar(String query) {
        ResultSet rs = null;
        try {
            Statement st = (Statement) c.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
        }
        return rs;
    }

    public int alterar(int id, OS os) {
        int resultado = 0;
        try {
            /*
            String query = "UPDATE Aluno SET nome='" + os.getNome() + "', "
                    + "matricula='" + aluno.getMatricula() + "' " + "WHERE id=" + id;
            Statement st = (Statement) c.createStatement();
            resultado = st.executeUpdate(query);
*/
        } catch (Exception e) {
        }
        return resultado;
    }

    public int excluir(int id) {
        int resultado = 0;
        try {
            String query = "DELETE FROM servico WHERE id=" + id;
            Statement st = (Statement) c.createStatement();
            resultado = st.executeUpdate(query);
        } catch (Exception e) {
        }
        return resultado;
    }

}
