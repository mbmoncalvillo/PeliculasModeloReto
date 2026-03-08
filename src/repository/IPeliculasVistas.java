package repository;
import model.Genero;
import model.Pelicula;
import java.util.List;

public interface IPeliculasVistas {
    List<Pelicula> findVistasByUsuario(int usuarioId);
   
	List<Genero> findAllGeneros();
}