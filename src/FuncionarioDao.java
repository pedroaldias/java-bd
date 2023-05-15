import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private Connection conn;

    public FuncionarioDao() {
        this.conn = Connections.getConnection();
    }

    public void insert(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario" + "(ID, NAME, AGE, CITY)" + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, funcionario.getId());
            stmt.setString(2, funcionario.getName());
            stmt.setInt(3, funcionario.getAge());
            stmt.setString(4, funcionario.getCity());
            stmt.execute();
            stmt.close();
            conn.close();
            System.out.println("Insertion successful...");
        } catch (SQLException e) {
            System.out.println("Insertion failed..." + e.getMessage());
        }
    }

    public void query() {
        try (Connection conn = Connections.getConnection();) {
            String sql = "SELECT * FROM funcionario";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("ID")
                                + "\nNAME: " + rs.getString("NAME")
                                + "\nAGE: " + rs.getInt("AGE")
                                + "\nCITY: " + rs.getString("CITY")
                                + "\n--------------------------");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Query failed..." + e.getMessage());
        }
    }

    public List<Funcionario> getLista() {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("ID"));
                funcionario.setName(rs.getString("NAME"));
                funcionario.setAge(rs.getInt("AGE"));
                funcionario.setCity(rs.getString("CITY"));
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}