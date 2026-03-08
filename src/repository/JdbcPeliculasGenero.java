package repository;
import database.DatabaseConnection;
import model.Genero;
import model.Pelicula;

import java.sql.*;
import java.util.*;

public class JdbcPeliculasGenero implements IPeliculasGenero {

	@Override
    public List<Pelicula> findNoVistasByGenero(int usuarioId,int generoId){
        List<Pelicula> lista=new ArrayList<>();
        try{
            Connection conn=DatabaseConnection.getConnection();
            String sql="SELECT p.* FROM peliculas p JOIN generos_peliculas gp ON p.id=gp.pelicula_id WHERE gp.genero_id=? AND p.id NOT IN (SELECT pelicula_id FROM usuarios_peliculas_vistas WHERE usuario_id=?)";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,generoId);
            st.setInt(2,usuarioId);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                lista.add(new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("anio")));
            }
        }catch(Exception e){ e.printStackTrace();}
        return lista;
    }

	
}
