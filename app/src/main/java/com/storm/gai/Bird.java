package com.storm.gai;
import com.storm.StormGraph.*;
import android.graphics.*;
import com.storm.Neural.*;
import android.os.*;
import android.util.*;

public class Bird extends SRect
{
	NeuralSystem myBrain;
	Bird(Vector2 po, Vector2 feature, int color)
	{
		super(po, feature, color);
		this.setIsApplyToGravity(1);
		myBrain = new NeuralSystem();
		myBrain.addLayer(2);
		myBrain.addLayer(10);
		myBrain.addLayer(1);
	}
	
	void inPut(float h, float l)
	{
		myBrain.getInPut().get(0).setOutFromLastLayer(h / 7);
		myBrain.getInPut().get(1).setOutFromLastLayer(l / 4);
		float out = myBrain.caclOutPut().get(0).getOutFromLastLayer();
		if(out > 0.5)
		{
			this.velocity.setY(-7);
		}
		Log.i("Bbird" , "NeuralSystem out:" + out + ". Mybrian at:" + myBrain);
	}
	
	
	
}
