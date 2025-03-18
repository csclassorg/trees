public class RecursiveTree
{
	private static final int CANVAS_WIDTH = 800;
	private static final int CANVAS_HEIGHT = 800;
	private static final int LEFT_ANGLE = 30;
	private static final int RIGHT_ANGLE = 45;
	private static final double LEFT_LENGTH = 0.8;
	private static final double RIGHT_LENGTH = 0.75;
	private static final int MIN_LENGTH = 2;
	private Turtle turtle;
	public static void main(String[] args)
	{
		RecursiveTree tree = new RecursiveTree();
		tree.initialize();
		tree.drawTree(80);
	}
	
	public RecursiveTree()
	{
		turtle = new Turtle();
	}

	public void initialize()
	{
		Turtle.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		turtle.hide();
		turtle.speed(0.4);
		turtle.up();
		turtle.setPosition(0, CANVAS_HEIGHT*(-0.25), 90);
		turtle.down();
	}

	public void drawTree(int length)
	{
		turtle.width(Math.ceil(length/10.0));

		if (length < MIN_LENGTH)
		{
			return;
		}
		else
		{
			// Draw the left branch
			turtle.forward(length);
			turtle.left(LEFT_ANGLE);
			drawTree((int)(length * LEFT_LENGTH));
			
			// Draw the right branch
			turtle.right(LEFT_ANGLE + RIGHT_ANGLE);
			drawTree((int)(length * RIGHT_LENGTH));
			
			// Return to the original position
			turtle.left(RIGHT_ANGLE);
			turtle.backward(length);
		}
	}
}