package logicscape.utilidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * La clase Marciano representa un objeto que contiene la imagen de un marciano en el juego.
 */
public class Marciano {
    private ImageView imagen; // Atributo para representar la imagen del personaje

    /**
     * Construye un nuevo objeto Marciano con la imagen especificada.
     * @param rutaImagen La ruta de la imagen del marciano.
     */
    public Marciano(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
        this.imagen.setFitWidth(200); // Ajustar el ancho de la imagen según tus necesidades
        this.imagen.setFitHeight(200);
    }

    /**
     * Obtiene la imagen del marciano.
     * @return La imagen del marciano.
     */
    public ImageView getImagen() {
        return imagen;
    }
}
