module AppLogicScape {
	requires javafx.controls;
	requires java.persistence;
	requires com.fasterxml.jackson.annotation;
	requires java.sql;
	requires org.mockito;
	
	opens logicscape to javafx.graphics, javafx.fxml;
}
