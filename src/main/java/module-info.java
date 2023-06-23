/**
 * 
 * @author Nelson Camacho
 *
 */
module AppLogicScape {
	requires javafx.controls;
	requires java.persistence;
	requires com.fasterxml.jackson.annotation;
	requires java.sql;
	
	opens logicscape to javafx.graphics, javafx.fxml;
}
