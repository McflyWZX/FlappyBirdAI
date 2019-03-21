package com.storm.gai;
import com.storm.StormGraph.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import java.util.*;

public class mainView extends DrawSurface
{

	long st;
	Bird tr;
	ArrayDeque<Pipe> ps;
	//Pipe ps[];
	int index = 0;
	Boolean isStart = false;
	mainView(Context co)
	{
		super(co);
	}
	
	@Override
	public void uInit()
	{
		// TODO: Implement this method
		tr = new Bird(new Vector2(2, 4), new Vector2(0.5f, 0.5f), Color.CYAN);
		tr.setIsVisible(1);
		tr.setVelocity(new Vector2(2, 0));
		this.gravity.setY(13f);
		this.setCameraVelocity(new Vector2(2, 0));
		Gconst.setMeterInWeight(6);
		st = System.currentTimeMillis();// ms
		ps = new ArrayDeque<Pipe>();
		//Gconst.frameT = 1 / 35;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO: Implement this method
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			tr.setVelocity(new Vector2(2, -7));
		}
		return true;
	}
	
	@Override
	public void onRun()
	{
		// TODO: Implement this method
		if(System.currentTimeMillis() - st >= 2500)
		{
			isStart = true;
			ps.addLast(new Pipe(new Vector2(cameraPosition.getX() + 7f, (float)(Math.random() * (Gconst.meterInHeight - 2) + 1))));
			if(++index == 3)
			{
				ps.removeFirst();
			}
			st = System.currentTimeMillis();
		}
		
		for(Pipe tp : ps)
		{
		
				if(tp.collisionCheck(0.5f, tr))
				{
					break;
				}		
			
		}
	}
	
	
}
