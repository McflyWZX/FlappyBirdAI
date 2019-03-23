package com.storm.gai;
import com.storm.StormGraph.*;
import android.graphics.*;

public class Pipe
{
	float sH;
	final float holeR = 1f;
	SRect rUp, rDown;
	Vector2 centre;
	Boolean isInited;
	Pipe(Vector2 centre)
	{
		this.centre = centre;
		sH = Gconst.meterInHeight;
		rUp = new SRect(new Vector2(centre.getX(), (centre.getY() - holeR) / 2),
						new Vector2(1, centre.getY() - holeR), 0xff5dbe8a);
		rDown = new SRect(new Vector2(centre.getX(), (sH + centre.getY() + holeR) / 2),
						new Vector2(1, sH - centre.getY() - holeR), 0xff5dbe8a);
		rUp.setIsVisible(1);
		rDown.setIsVisible(1);
		rUp.setIsApplyToGravity(0);
		rDown.setIsApplyToGravity(0);
		isInited = true;
	}
	
	Pipe()
	{
		isInited = false;
		rUp = rDown = null;
	}
	
	boolean collisionCheck(float bL, Bird b)
    {
		Vector2 bP = b.getPosition();
        if((bP.getY() + bL / 2 > centre.getY() + holeR || bP.getY() - bL / 2 < centre.getY() - holeR) && Math.abs(bP.getX() - centre.getX()) <= bL / 2 + 0.5f)
        {
			b.setColor(Color.GRAY);
            return true;
        } else {
			b.setColor(0xfff17666);
			return false;
        }
    }

	@Override
	protected void finalize() throws Throwable
	{
		// TODO: Implement this method
		rUp = null;
		rDown = null;
		super.finalize();
	}
	
	
}
