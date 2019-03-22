package com.storm.Neural;
import java.lang.reflect.*;
import java.util.*;

public class Neuron
{
	ArrayList<Neuron> toNext;
	
	float b, w, outFromLastLayer;//
	
	public Neuron()
	{
		b = w = outFromLastLayer = 0;
		toNext = new ArrayList<Neuron>();
	}
	
	Neuron(float b, float w)
	{
		this.b = b;
		this.w = w;
		outFromLastLayer = 0;
		toNext = new ArrayList<Neuron>();
	}

	public void setB(float b)
	{
		this.b = b;
	}

	public float getB()
	{
		return b;
	}

	public void setW(float w)
	{
		this.w = w;
	}

	public float getW()
	{
		return w;
	}

	public void addToOutFromLastLayer(float input)
	{
		this.outFromLastLayer += input;
	}
	
	public void setOutFromLastLayer(float outFromLastLayer)
	{
		this.outFromLastLayer = outFromLastLayer;
	}

	public float getOutFromLastLayer()
	{
		return outFromLastLayer;
	}
	
	void spread()
	{
		for(Neuron n : toNext)
		{
			n.addToOutFromLastLayer(this.outFromLastLayer * w);
		}
		this.outFromLastLayer = 0;
	}
	
	float sigmod(float x)
	{
		return (float)(Math.exp(x) / (Math.exp(x) + Math.exp(-x)));
	}
	
	void linkTo(Neuron n)
	{
		toNext.add(n);
	}
}
