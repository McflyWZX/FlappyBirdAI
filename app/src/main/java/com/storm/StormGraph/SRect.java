package com.storm.StormGraph;
import android.graphics.*;

public class SRect extends SBasicObject
{
	Vector2 feature;
	int color;
	public SRect(Vector2 po, Vector2 feature, int color)
	{
		super(po);
		this.feature = feature;
		this.color = color;
	}

	public void setColor(int color)
	{
		this.color = color;
	}

	public int getColor()
	{
		return color;
	}
	@Override
	public void draw(Canvas ca, Paint pa)
	{
		int sColor = pa.getColor();
		pa.setColor(color);
		if(isVisible == 1)
		{
			ca.drawRect(position.getX() - feature.getX() / 2, position.getY() - feature.getY() / 2,
						position.getX() + feature.getX() / 2, position.getY() + feature.getY() / 2,
						pa);
		}
		pa.setColor(sColor);
		// TODO: Implement this method
	}
	
}
