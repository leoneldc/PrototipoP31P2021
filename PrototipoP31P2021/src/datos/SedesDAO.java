/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class SedesDAO {
    private static final String SQL_SELECT = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes";
    private static final String SQL_INSERT = "insert into sedes values(?,?,?)";
    private static final String SQL_DELETE = "delete from sedes where codigo_sede = ?";  
    private static final String SQL_UPDATE = "UPDATE sedes SET nombre_sede=?, estatus_sede=? WHERE codigo_sede=?";
    private static final String SQL_QUERY = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes WHERE codigo_sede = ?";
   
    
    public List<Sedes> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sedes sedes = null;
        List<Sedes> sede = new ArrayList<Sedes>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estado_sede = rs.getString("estatus_sede");
                
                sedes = new Sedes();
                sedes.setCodigo(codigo_sede);
                sedes.setNombre(nombre_sede);
                sedes.setEstatus(estado_sede);
                
                
                sede.add(sedes);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return sede;
    }
    public int insert(Sedes sedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sedes.getCodigo());
            stmt.setString(2, sedes.getNombre());
            stmt.setString(3, sedes.getEstatus());
//            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int delete(Sedes sedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, sedes.getCodigo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int update(Sedes sedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sedes.getNombre());
            stmt.setString(2, sedes.getEstatus());
            stmt.setString(3, sedes.getCodigo());
            rows = stmt.executeUpdate();
            System.out.println( stmt);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    public Sedes query(Sedes sedes) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, sedes.getCodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estado_sede = rs.getString("estatus_sede");
                sedes = new Sedes();
                sedes.setCodigo(codigo_sede);
                sedes.setNombre(nombre_sede);
                sedes.setEstatus(estado_sede);
                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sedes;
    }
}
