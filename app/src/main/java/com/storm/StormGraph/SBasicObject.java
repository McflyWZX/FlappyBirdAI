package com.storm.StormGraph;
import android.graphics.*;

public abstract class SBasicObject implements Graphic
{
	int isVisible, isApplyToGravity;
	protected Vector2 position, velocity, acceleration;
	public SBasicObject(Vector2 po)
	{
		this.position = po;
		this.velocity = new Vector2();
		this.acceleration = new Vector2();
		DrawSurface.addObj(this);
	}

	
	public void setIsApplyToGravity(int isApplyToGravity)
	{
		this.isApplyToGravity = isApplyToGravity;
	}

	public int getIsApplyToGravity()
	{
		return isApplyToGravity;
	}
	
	public void setVelocity(Vector2 velocity)
	{
		this.velocity = velocity;
	}

	public Vector2 getVelocity()
	{
		return velocity;
	}

	public void setAcceleration(Vector2 acceleration)
	{
		this.acceleration = acceleration;
	}

	public Vector2 getAcceleration()
	{
		return acceleration;
	}

	public void setIsVisible(int isVisible)
	{
		this.isVisible = isVisible;
	}

	public int getIsVisible()
	{
		return isVisible;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public Vector2 getPosition()
	{
		return position;
	}

	@Override
	protected void finalize() throws Throwable
	{
		// TODO: Implement this method
		DrawSurface.delObj(this);
		super.finalize();
	}

	
	

}
