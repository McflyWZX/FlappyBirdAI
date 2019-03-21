package com.storm.StormGraph;

import java.math.*;
import android.util.*;

public class Vector2
{
	private float vx, vy;
	public Vector2(float x, float y)
	{
		vx = x;
		vy = y;
	}
	
	public Vector2()
	{
		vx = 0;
		vy = 0;
	}

	public void setX(float vx)
	{
		this.vx = vx;
	}

	public float getX()
	{
	return vx;
	}

	public void setY(float vy)
	{
	this.vy = vy;
	}

	public float getY()
	{
	return vy;
	}

	
	
	public Vector2 add(Vector2 v1)
	{
		return new Vector2(v1.vx + this.vx, v1.vy + this.vy);
	}
	
	public Vector2 scale(float scaleFactor)
	{
		return new Vector2(this.vx * scaleFactor, this.vy * scaleFactor);
	}
	
	public static float distance(Vector2 v1, Vector2 v2)
	{
		return (float)Math.sqrt(Math.pow(v1.vx - v2.vx, 2) + Math.pow(v1.vy - v2.vy, 2));
	}
	
	public static float distance2(Vector2 v1, Vector2 v2)
	{
		return (float)Math.pow(v1.vx - v2.vx, 2) + (float)Math.pow(v1.vy - v2.vy, 2);
	}
	
	public static float dx(Vector2 v1, Vector2 v2)
	{
		return v1.vx - v2.vx;
	}
	
	public static float dy(Vector2 v1, Vector2 v2)
	{
		return v1.vy - v2.vy;
	}
}
