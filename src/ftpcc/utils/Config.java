package ftpcc.utils;

import java.awt.Dimension;

import javax.swing.ImageIcon;

/**
 * Class containing several (default) configuration parameters.
 * 
 * @author RWilmes
 * 
 */
public class Config {

	public static final Dimension GUI_MAIN_FRAME_SIZE = new Dimension(600, 400);

	public static final ImageIcon ICON_SETTINGS = IO
			.readImageIcon("img/settings_24x.png");
	public static final ImageIcon ICON_PROCESSING = IO
			.readImageIcon("img/processing_24x.png");
	public static final ImageIcon ICON_QUEUE = IO
			.readImageIcon("img/queue_24x.png");
	public static final ImageIcon ICON_DONE = IO
			.readImageIcon("img/done_24x.png");

}
