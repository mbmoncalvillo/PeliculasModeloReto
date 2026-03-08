package repository;
import database.DatabaseConnection;
import model.Usuario;
import java.sql.*;

public class JdbcLogin implements ILogin {
	final String SQL="SELECT * FROM usuarios WHERE nombre=? AND password=?";
     
    @Override
    public Usuario login(String nombre,String password) throws Exception {
        Usuario usuario=null;
    	try (Connection conn=DatabaseConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SQL))
        {
            st.setString(1,nombre);
            st.setString(2,password);
            try (ResultSet rs = st.executeQuery())
            {
	            if(rs.next()){
	            	usuario = new Usuario(rs.getInt("id"),rs.getString("nombre"),rs.getString("password"));
	            }
            }
        }
        return usuario;
    }
}