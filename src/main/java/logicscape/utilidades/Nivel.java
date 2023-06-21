package logicscape.utilidades;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Nivel {
    private ImageView imagen; // Atributo para representar la imagen del personaje

    public Nivel(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
    }

    public ImageView getImagen() {
        return imagen;
    }
}
