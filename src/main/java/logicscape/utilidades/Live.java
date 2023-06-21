package logicscape.utilidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Live {
    private ImageView imagen; // Atributo para representar la imagen del personaje

    public Live(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
    }

    public ImageView getImagen() {
        return imagen;
    }
}

