/**
 * 
 * @author Nelson Camacho
 *
 */
module LogicScape {
	requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
	requires java.persistence;
	requires com.fasterxml.jackson.annotation;
	requires java.sql;
	
	opens logicscape to javafx.graphics, javafx.fxml;
}
