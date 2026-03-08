package repository;
import model.Usuario;

public interface ILogin {
    Usuario login(String nombre,String password) throws Exception;
}