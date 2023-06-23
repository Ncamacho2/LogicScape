package logicscape.utilidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * La clase Nivel representa un objeto que contiene la imagen de un nivel en el juego.
 */
public class Nivel {
    private ImageView imagen; // Atributo para representar la imagen del nivel

    /**
     * Construye un nuevo objeto Nivel con la imagen especificada.
     * @param rutaImagen La ruta de la imagen del nivel.
     */
    public Nivel(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
    }

    /**
     * Obtiene la imagen del nivel.
     * @return La imagen del nivel.
     */
    public ImageView getImagen() {
        return imagen;
    }
}
