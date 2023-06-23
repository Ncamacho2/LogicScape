package logicscape.utilidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * La clase Live representa un objeto que contiene la imagen de un personaje en el juego.
 */
public class Live {
    private ImageView imagen; // Atributo para representar la imagen del personaje

    /**
     * Construye un nuevo objeto Live con la imagen especificada.
     * @param rutaImagen La ruta de la imagen del personaje.
     */
    public Live(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
    }

    /**
     * Obtiene la imagen del personaje.
     * @return La imagen del personaje.
     */
    public ImageView getImagen() {
        return imagen;
    }
}
