package repository;
import database.DatabaseConnection;
import model.Genero;
import model.Pelicula;
import java.sql.*;
import java.util.*;

public class JdbcPeliculasVistas implements IPeliculasVistas {

    @Override
    public List<Pelicula> findVistasByUsuario(int usuarioId){
        List<Pelicula> lista=new ArrayList<>();
        try{
            Connection conn=DatabaseConnection.getConnection();
            String sql="SELECT p.* FROM peliculas p JOIN usuarios_peliculas_vistas upv ON p.id=upv.pelicula_id WHERE upv.usuario_id=?";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,usuarioId);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                lista.add(new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("anio")));
            }
        }catch(Exception e){ e.printStackTrace();}
        return lista;
    }
    @Override
    public List<Genero> findAllGeneros(){
        List<Genero> lista=new ArrayList<>();
        try{
            Connection conn=DatabaseConnection.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM generos");
            while(rs.next()){
                lista.add(new Genero(rs.getInt("id"),rs.getString("nombre")));
            }
        }catch(Exception e){ e.printStackTrace();}
        return lista;
    }
    
}
