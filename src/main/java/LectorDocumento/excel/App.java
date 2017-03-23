package LectorDocumento.excel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import presentacion.Formulario;
import utils.ManejadorImagenes;


public class App {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		  //  Formulario form = new Formulario();   
		ManejadorImagenes manejador = new ManejadorImagenes();
		File file =new File("C:\\Users\\LogicStudio\\Documents\\inmobilizacioninfo2.png");
		
		  try {
			ImageIO.write(manejador.crearPNG(), "png", file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
