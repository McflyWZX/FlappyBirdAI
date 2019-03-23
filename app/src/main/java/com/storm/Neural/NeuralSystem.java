package com.storm.Neural;
import java.lang.reflect.*;
import java.util.*;

public class NeuralSystem
{
	ArrayDeque<ArrayList<Neuron>> layers;
	
	public NeuralSystem()
	{
		layers = new ArrayDeque<ArrayList<Neuron>>();
	}
	
	public ArrayList<Neuron> getInPut()
	{
		return layers.getFirst();
	}
	
	public ArrayList<Neuron> caclOutPut()
	{
		for(ArrayList<Neuron> layer : layers )
		{
			if(layer != layers.getLast())
			{
				for(Neuron n : layer)
				{
					n.spread();
				}
			}
		}
		return layers.getLast();
	}
	
	public void addLayer(int neurons)
	{
		if(layers.isEmpty())
		{
			ArrayList<Neuron> newL = new ArrayList<Neuron>();
			for(int i = 0; i < neurons; i++)
			{
				Neuron n = new Neuron((float)(Math.random() * 0.2 - 0.1), (float)(Math.random() * 0.2 - 0.1));
				newL.add(n);
			}
			layers.addLast(newL);
			
		} else {
			ArrayList<Neuron> newL = new ArrayList<Neuron>(),
						      lastL = layers.getLast();
			for(int i = 0; i < neurons; i++)
			{
				Neuron n = new Neuron((float)(Math.random() * 0.2 - 0.1), (float)(Math.random() * 0.2 - 0.1));
				for(Neuron lN : lastL)
				{
					lN.linkTo(n);
				}
				newL.add(n);
			}
			layers.addLast(newL);
		}
	}
}
