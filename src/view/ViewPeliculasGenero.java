package view;

import model.Pelicula;
import model.Genero;
import model.Usuario;
import repository.RepositoryProvider;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewPeliculasGenero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaResultados = new JTable();
  
    private Usuario usuario;
    private Genero genero;
    private  RepositoryProvider repo;

    public ViewPeliculasGenero(Usuario usuario, Genero genero,RepositoryProvider repo) {
        this.usuario = usuario;
        this.genero = genero;

        this.repo=repo;

        setTitle("Películas de " + genero.getNombre() + " que no has visto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Películas de " + genero.getNombre()));
        panel.add(new JScrollPane(tablaResultados));

        getContentPane().add(panel);

        cargarPeliculas();

        setSize(782, 560);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarPeliculas() {
        List<Pelicula> lista = repo.getRepoPeliculasGenero().findNoVistasByGenero(usuario.getId(), genero.getId());
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Título", "Año"}, 0);
        for (Pelicula p : lista) {
            model.addRow(new Object[]{p.getId(), p.getTitulo(), p.getAnio()});
        }
        tablaResultados.setModel(model);
    }
}