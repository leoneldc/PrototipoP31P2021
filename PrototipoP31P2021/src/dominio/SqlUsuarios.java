package dominio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SqlUsuarios extends Conexion {
     private static final String SQL_QUERY = "SELECT id, usuario, password, nombre FROM usuarios WHERE id = ?";
   
 public Usuarios query(Usuarios usuario) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("id");
                String nom = rs.getString("usuario");
                String contra = rs.getString("password");
                usuario = new Usuarios();
                usuario.setIdTipo(cod);
                usuario.setNombre(nom);
                usuario.setPassword(contra);
                
                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }

}
