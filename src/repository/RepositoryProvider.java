package repository;

public class RepositoryProvider {
	private ILogin repoLogin;
	private IPeliculasVistas repoPeliculasVistas;
	private IPeliculasGenero repoPeliculasGenero;
	public ILogin getRepoUsuario() {
		return repoLogin;
	}
	
	public IPeliculasVistas getRepoPeliculasVistas() {
		return repoPeliculasVistas;
	}

	public IPeliculasGenero getRepoPeliculasGenero() {
		return repoPeliculasGenero;
	}
	
	public RepositoryProvider()
	{
		this.repoPeliculasGenero = new JdbcPeliculasGenero();
		this.repoPeliculasVistas = new JdbcPeliculasVistas();
		this.repoLogin = new JdbcLogin();
	}
	
	
}
