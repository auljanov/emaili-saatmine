package event;

import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SentItemsBackButtonClickListener implements MouseListener {

	private Window window;

	public SentItemsBackButtonClickListener(Window window) {
		this.window = window;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.window.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
