package Uebungsaufgaben.Uebung09.A3;

import java.awt.Color;

public class ImageFilterThreaded extends ImageFilter implements Runnable {
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color[][] result;
	private float[][] filter;

	public ImageFilterThreaded(int x1, int x2, int y1, int y2, Color[][] result, float[][] filter) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.result = result;
		this.filter = filter;
	}

	public ImageFilterThreaded() {
	}

	@Override
	protected Color[][] filterMatrix(float[][] filter) {
		Color[][] result = new Color[matrix.length][matrix[0].length];

		//Threads
		Thread threadLinksOben = new Thread(new ImageFilterThreaded(0, matrix.length/2, 0, matrix[0].length/2,result,filter));
		Thread threadLinksUnten = new Thread(new ImageFilterThreaded(0, matrix.length/2, matrix[0].length/2, matrix[0].length,result,filter));
		Thread threadRechtsOben = new Thread(new ImageFilterThreaded(matrix.length/2, matrix.length, 0, matrix[0].length/2,result,filter));
		Thread threadRechtsUnten = new Thread(new ImageFilterThreaded(matrix.length/2, matrix.length, matrix[0].length/2, matrix[0].length,result,filter));

		threadLinksOben.start();
		threadLinksUnten.start();
		threadRechtsOben.start();
		threadRechtsUnten.start();

		try {
			threadLinksOben.join();
			threadLinksUnten.join();
			threadRechtsOben.join();
			threadRechtsUnten.join();
		} catch (InterruptedException e) {
	//		e.printStackTrace();		// dieses ist keine Fehlersituation, 
							// sondern nur eine etwas "brutalere" Interrupt-Message
		}
		return result;

	}

	@Override
	public void run() {
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				filterPixel(result, x, y, filter);
			}
		}

	}
}
