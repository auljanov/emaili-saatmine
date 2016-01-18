package event;

import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SentItemsPageBackButtonClickListener implements MouseListener {

	private Window window;

	public SentItemsPageBackButtonClickListener(Window mainpage) {
		this.window = mainpage; //link to the called object
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
