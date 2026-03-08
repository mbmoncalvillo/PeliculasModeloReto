package view;

import model.Usuario;

import repository.RepositoryProvider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewLogin extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField userField = new JTextField(10);
    private  JPasswordField passField = new JPasswordField(10);
    private  JButton loginBtn = new JButton("Login");

    private  RepositoryProvider repo;

    public ViewLogin(RepositoryProvider repo) {
        this.repo=repo;
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Usuario:"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(loginBtn);

        add(panel);

        loginBtn.addActionListener(this);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doLogin(){
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        Usuario usuario=null;
        try {
        	usuario = repo.getRepoUsuario().login(user, pass);
        	if (usuario==null)
   			 JOptionPane.showMessageDialog(this, "Login incorrecto");
   		else {
               // Abrimos segunda ventana
               new ViewPeliculasYaVistas(usuario,repo);
               dispose();
           } 
        }
        
        catch (Exception exception)
		{
			JOptionPane.showMessageDialog(this,(String)exception.getMessage(),"Error al acceder a la BD",JOptionPane.INFORMATION_MESSAGE,null);
			
			return; //System.exit(0);
		}
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()== loginBtn)
			doLogin();
			
		
	}
}

