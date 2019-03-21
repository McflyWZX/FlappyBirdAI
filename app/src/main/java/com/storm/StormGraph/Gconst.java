package com.storm.StormGraph;
import android.util.*;

public class Gconst
{
	final public static float frameT = 1 / 65f;//绘制帧数 Hz
	//public static float calcTime = 1 / 100f;//计算频率 Hz
	
	public static float meterInWidth = 100;
	public static float meterInHeight;
	public static float scaleSceern, sHeight, sWidth;

	public static void setMeterInWeight(int meterInWidth)
	{
		Gconst.meterInWidth = meterInWidth;
		scaleSceern = sWidth / meterInWidth;
		meterInHeight = sHeight / scaleSceern;
	}

	public static float getMeterInWeight()
	{
		return meterInWidth;
	}

	
	static void setScaleFactor(int height, int width)
	{
		sWidth = width;
		sHeight = height;
		scaleSceern = width / meterInWidth;
		meterInHeight = height / scaleSceern;
		//Log.i("PSconst", "weight:" + weight);
	}
}
