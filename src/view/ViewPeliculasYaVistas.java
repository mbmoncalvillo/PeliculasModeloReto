package view;

import model.Genero;
import model.Pelicula;
import model.Usuario;
import repository.JdbcPeliculasGenero;
import repository.JdbcPeliculasVistas;
import repository.RepositoryProvider;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewPeliculasYaVistas extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTable tablaVistas = new JTable();
    private  JComboBox<Genero> comboGeneros = new JComboBox<>();
    private  JButton btnSeleccionar = new JButton("Seleccionar");

    private  RepositoryProvider repo;
    private  Usuario usuario;

    public ViewPeliculasYaVistas(Usuario usuario,RepositoryProvider repo) {
        this.usuario = usuario;
        this.repo=repo;
        setTitle("Películas Vistas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Películas vistas:"));
        panel.add(new JScrollPane(tablaVistas));
        panel.add(new JLabel("Género:"));
        panel.add(comboGeneros);
        panel.add(btnSeleccionar);

        getContentPane().add(panel);

        cargarPeliculasVistas();
        cargarGeneros();

        btnSeleccionar.addActionListener(e -> abrirPeliculasGenero());

        setSize(720, 569);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarPeliculasVistas() {
        List<Pelicula> vistas = repo.getRepoPeliculasVistas().findVistasByUsuario(usuario.getId());
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Título", "Año"}, 0);
        for (Pelicula p : vistas) {
            model.addRow(new Object[]{p.getId(), p.getTitulo(), p.getAnio()});
        }
        tablaVistas.setModel(model);
    }

    private void cargarGeneros() {
        List<Genero> generos = repo.getRepoPeliculasVistas().findAllGeneros();
        comboGeneros.removeAllItems();
        for (Genero g : generos) {
            comboGeneros.addItem(g);
        }
    }

    private void abrirPeliculasGenero() {
        Genero seleccionado = (Genero) comboGeneros.getSelectedItem();
        if (seleccionado != null) {
            new ViewPeliculasGenero(usuario, seleccionado,repo);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un género");
        }
    }
}