module AppLogicScape {
	requires javafx.controls;
	requires java.persistence;
	requires com.fasterxml.jackson.annotation;
	
	opens logicscape to javafx.graphics, javafx.fxml;
}
