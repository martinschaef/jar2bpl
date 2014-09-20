

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Dictionary;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Attribute;

public class FalsePositive11 {

	public static final String TOP       = "top";
	public static final String TEXTTOP   = "texttop";
	public static final String MIDDLE    = "middle";
	public static final String ABSMIDDLE = "absmiddle";
	public static final String CENTER    = "center";
	public static final String BOTTOM    = "bottom";
	public static final String IMAGE_CACHE_PROPERTY = "imageCache";

	private static final String PENDING_IMAGE_SRC = "icons/ImagePendingHK.gif";
	private static final String MISSING_IMAGE_SRC = "icons/ImageMissingHK.gif";
	private static final int DEFAULT_WIDTH  = 32;
	private static final int DEFAULT_HEIGHT = 32;
	private static final int DEFAULT_BORDER = 1;
	
	private AttributeSet attr;
	private Element      fElement;
	private Image        fImage;
	private int          fHeight;
	private int          fWidth;
	private Container    fContainer;
	private Rectangle    fBounds;
	private Component    fComponent;
	private Point        fGrowBase; // base of drag while growing image
	private boolean      fGrowProportionally; // should grow be proportional?
	private boolean      bLoading; // set to true while the receiver is locked, to indicate the reciever is loading the image. This is used in imageUpdate.
	
	/*
	 * example from terpword.
	 * This example shows how the NullPointerAnalysis fails to show that $this 
	 * is always non-null 
	 */
	public void initialize(Element elem)
	{
		synchronized(this)
		{
			bLoading = true;
		}
		int width = 0;
		int height = 0;
		boolean customWidth = false;
		boolean customHeight = false;
		try
		{
			fElement = elem;
			// request image from document's cache
			AttributeSet attr = elem.getAttributes();

			// get height & width from params or image or defaults
			height = getIntAttr(HTML.Attribute.HEIGHT, -1);
			customHeight = (height > 0);

			width = getIntAttr(HTML.Attribute.WIDTH, -1);
			customWidth = (width > 0);

		}
		finally
		{
			synchronized(this)
			{
				bLoading = false; //NullnessAnaysis fails to show that $this is non-null
			}
		}
	}


	private int getIntAttr(Attribute height, int i) {
		// TODO Auto-generated method stub
		return 0;
	}


	private void waitForImage() throws InterruptedException{
		// TODO Auto-generated method stub
		
	}


	private String processSrcPath(String src) {
		// TODO Auto-generated method stub
		return null;
	}


	private boolean isURL() {
		// TODO Auto-generated method stub
		return false;
	}


	private Object getDocument() {
		// TODO Auto-generated method stub
		return null;
	}


	private URL getSourceURL() {
		// TODO Auto-generated method stub
		return null;
	}
}