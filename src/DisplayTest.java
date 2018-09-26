import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
 


public class DisplayTest {
	
	public DisplayTest() {
		
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("Meu primeiro Display");
			Display.create();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	 //OpenGL init
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()) {
			//Rendering
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			glBegin(GL_LINES);
			   glVertex2i(100,100);
			   glVertex2i(200,200);
			glEnd();
			
			glBegin(GL_QUADS);
			   glVertex2i(400,400); //cima esquerda
			   glVertex2i(500,400); //cima direita
			   glVertex2i(500,500); //baixo direita
			   glVertex2i(400,500); //baixo esquerda
			glEnd();   
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		
		
	}
   
	
	
	public static void main(String[] args) {
		
		
		new DisplayTest();
		
		
	}
}