package logicscape.utilidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Marciano {
    private ImageView imagen; // Atributo para representar la imagen del personaje

    public Marciano(String rutaImagen) {
        Image image = new Image(getClass().getResourceAsStream(rutaImagen));
        this.imagen = new ImageView(image);
        this.imagen.setFitWidth(200); // Ajustar el ancho de la imagen según tus necesidades
        this.imagen.setFitHeight(200);
    }

    public ImageView getImagen() {
        return imagen;
    }
}