package principal;

import repository.RepositoryProvider;
import view.ViewLogin;

public class Principal {
	public static void main(String[] args){
		RepositoryProvider repo=new RepositoryProvider();
        new ViewLogin(repo);
    }
}
