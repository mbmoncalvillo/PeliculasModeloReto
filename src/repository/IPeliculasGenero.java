package repository;
import model.Genero;
import model.Pelicula;

import java.util.List;

public interface IPeliculasGenero {
	 List<Pelicula> findNoVistasByGenero(int usuarioId,int generoId);
}