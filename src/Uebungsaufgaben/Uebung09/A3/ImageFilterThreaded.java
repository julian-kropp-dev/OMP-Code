package Uebungsaufgaben.Uebung09.A3;

import java.awt.Color;

public class ImageFilterThreaded extends ImageFilter implements Runnable{

	@Override
	protected Color[][] filterMatrix(float[][] filter) {
		Color[][] result = new Color[matrix.length][matrix[0].length];

		//Threads
		Thread threadLinksOben = new Thread();
		Thread threadLinksUnten = new Thread();
		Thread threadRechtsOben = new Thread();
		Thread threadRechtsUnten = new Thread();

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
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public void run() {
		filterMatrix();

	}
}
