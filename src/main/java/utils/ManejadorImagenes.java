package utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ManejadorImagenes {
	
	
	
	public BufferedImage crearPNG() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 100, 100);
        
        // Aquí deberíamos introducir el código que queramos pintar.
        g2.dispose();
        return bufferedImage;
}
	
	
	
	
	
	
	
	

}
