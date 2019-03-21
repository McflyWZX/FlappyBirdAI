package com.storm.StormGraph;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.view.SurfaceHolder.*;
import javax.security.auth.callback.*;
import com.storm.StormGraph.*;
import android.util.*;
import java.util.*;

public abstract class DrawSurface extends SurfaceView implements Callback, Runnable
{
	Canvas c;
	SurfaceHolder holder; 
	Boolean isRunning;
	Boolean isDrawGrid = false;
	long T, t, tfps, FPS, dt;
	protected Vector2 gravity = new Vector2(0, 0f), cameraPosition = new Vector2(0, 0), cameraVlocity = new Vector2(0, 0);  
	Paint paint;  
	
	static ArrayList<Graphic> graphic = new ArrayList<Graphic>();
	static ArrayList<SBasicObject> objs = new ArrayList<SBasicObject>();


    public DrawSurface(Context context)
	{  
        super(context);  

        init(); //初始化,设置生命周期回调方法  
	}  

	public abstract void uInit();

    private void init()
	{  

        holder = getHolder();  
        holder.addCallback(this); //设置Surface生命周期回调  
		isRunning = false;  

		paint = new Paint();  
		paint.setColor(Color.YELLOW);  
		//paint.setStyle(Paint.Style.STROKE);  
		paint.setAntiAlias(true);
        //thread = new LoopThread(holder, getContext());  

    }  

    @Override  
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{  
    }  

    @Override  
    public void surfaceCreated(SurfaceHolder holder)
	{  

        isRunning = true;  
        
		Gconst.setScaleFactor(this.getHeight(), this.getWidth());
		uInit();
		new Thread(this).start();  
    }  

    @Override  
    public void surfaceDestroyed(SurfaceHolder holder)
	{  
        isRunning = false;
        /*try {  
		 thread.join();  
		 } catch (InterruptedException e) {  
		 e.printStackTrace();  
		 }  */
    }  

	@Override
	public abstract boolean onTouchEvent(MotionEvent event);

	public abstract void onRun();

	public static void addObj(SBasicObject obj)
	{
		objs.add(obj);
		graphic.add(obj);
	}

	public static void delObj(SBasicObject obj)
	{
		objs.add(obj);
		graphic.remove(obj);
	} 

	@Override  
	public void run()
	{  

		//c = null;  
		t = System.currentTimeMillis();

		while (isRunning)
		{  

			try
			{  
				synchronized (holder)
				{  
					T = System.currentTimeMillis();
					Log.i("farme", "帧开始");
					dt = System.currentTimeMillis() - 
						tfps++;
					if (T - t > 1000)
					{
						FPS = tfps;
						tfps = 0;
						t = System.currentTimeMillis();
					}
					c = holder.lockCanvas(null);  
					onRun();
					doDraw(c);  
					
					Log.i("farme", "帧结束");
					dt = System.currentTimeMillis() - T;
					//通过它来控制帧数执行一次绘制后休息50ms  
					Thread.sleep((int)Math.max(((Gconst.frameT * 1000) - dt), 0));  
					//Thread.sleep(0);
				}  
			}
			catch (InterruptedException e)
			{  
				e.printStackTrace();  
			}
			finally
			{  
				holder.unlockCanvasAndPost(c);  
			}  

		}  

	}  
	public void setCameraVelocity(Vector2 cVelocity)
	{
		cameraVlocity = cVelocity;
	}
	
	public void doDraw(Canvas c)
	{  

		//这个很重要，清屏操作，清楚掉上次绘制的残留图像  
		c.drawColor(Color.BLACK);  
		
		paint.setColor(Color.RED);
		c.drawText("FPS:" + FPS + "; meterInWeigh" + Gconst.meterInWidth, 80, 70, paint);
		
		c.scale(Gconst.scaleSceern, Gconst.scaleSceern);
		
		cameraPosition = cameraPosition.add(cameraVlocity.scale(Gconst.frameT));
		c.translate(-cameraPosition.getX(), -cameraPosition.getY());
		
		paint.setTextSize(40);
		paint.setStrokeWidth(5);
		
		
		if (isDrawGrid)drawGrid(c);
		
		for (SBasicObject obj: objs)
		{
			if(obj.getIsApplyToGravity() == 1)
			{
				obj.velocity = obj.velocity.add(obj.acceleration.add(gravity).scale(Gconst.frameT));
			} else {
				obj.velocity = obj.velocity.add(obj.acceleration);
			}
			obj.position = obj.position.add(obj.velocity.scale(Gconst.frameT));
		}
		
		for (Graphic obj: graphic)
		{
			obj.draw(c, paint);
		}
		  
		
	}  

	void drawGrid(Canvas c)
	{
		//绘制 Grid
		paint.setStrokeWidth(1);
		paint.setColor(Color.WHITE);
		for (int i = 0; i <= Gconst.meterInHeight; i++)
		{
			c.drawLine(0, i * (1 + Gconst.scaleSceern), Gconst.scaleSceern * Gconst.meterInWidth, i * (Gconst.scaleSceern + 1), paint);
		}
		for (int i = 0; i <= Gconst.meterInWidth; i++)
		{
			c.drawLine(i * (1 + Gconst.scaleSceern), 0, i * (Gconst.scaleSceern + 1), Gconst.scaleSceern * Gconst.meterInHeight, paint);
		}

	}



    
}
