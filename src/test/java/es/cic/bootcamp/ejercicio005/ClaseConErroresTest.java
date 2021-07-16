package es.cic.bootcamp.ejercicio005;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClaseConErroresTest {

	private ClaseConErrores cut;
	private String nombreFichero;
	
	@BeforeEach
	void setUp() throws IOException {
		this.cut = new ClaseConErrores();
		
		File fTemporal = File.createTempFile("hola", ".txt");
		nombreFichero = fTemporal.getAbsolutePath();
		try (PrintWriter pw = new PrintWriter(fTemporal)) {
			pw.print("Hola mundo");
		}
		
	}

	@Test
	void testMetodo1() {
		assertThrows(NoImplementadoException.class, 
				() -> cut.metodo1()
		);
	}

	@Test
	void testMetodo2() throws IOException {
		try (InputStream fis = ClaseConErroresTest.class.getResourceAsStream("/hola.txt")) {
			byte[] datos = new byte[64 * 1024];
			int cuantos;
			while ((cuantos = fis.read(datos)) != -1) {
				
			}
			
			cut.metodo2(true);		
		} catch (MotorException e) {
			e.printStackTrace();
			
			// Medidas correcticas o paliativas
			// Informo por ejemplo al usuario final del error, le pido disculpase
		} 
	}
	
	@Test
	void testMetodo2EncapsulandoElError() throws CocheException, IOException {
		assertThrows(CocheException.class, () -> {
			try {
				cut.metodo2(false);
				//while
			} catch (MotorException | IOException e) {
				throw new CocheException("El coche no arranca", e);
			}
		});
	}
	
	@Test
	void testMetodo2MotorExceptionSiProcesaTrue() throws IOException {
		assertThrows(MotorException.class, () -> cut.metodo2(true));
	}
	
}
