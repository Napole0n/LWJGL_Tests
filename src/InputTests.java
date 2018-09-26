import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.*;
 


public class InputTests {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	
	public InputTests() {
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.setTitle("Testes de input");
			Display.setFullscreen(true);
			Display.create();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	 //OpenGL init
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()) {
			//Rendering
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			//input handling
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				Display.destroy();
				System.exit(0);
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				
				int mouseX =  Mouse.getX();
				int mouseY = HEIGHT - Mouse.getY();
				
				glBegin(GL_QUADS);
				  glVertex2i(mouseX, mouseY);
				  glVertex2d(mouseX+200, mouseY);
				  glVertex2d(mouseX+200, mouseY+200);
				  glVertex2d(mouseX, mouseY+200);
				glEnd(); 
				
				System.out.println(Mouse.getDX());
				System.out.println(Mouse.getDY());
				
				
					
				
			}
			
			

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		
		
	}
   
	
	
	public static void main(String[] args) {
		
		
		new InputTests();
		
		
	}
}