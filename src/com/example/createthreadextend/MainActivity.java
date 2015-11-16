package com.example.createthreadextend;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {
	public TextView textView;
	MyThread myThread = new MyThread();
	public Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);
			String string = textView.getText().toString();
			int num = Integer.parseInt(string);
			num = num - 1;
			string = Integer.toString(num);
			textView.setText(string);
		}

	};


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
	
	}
	
	protected void onStart() {
		myThread.start();
		}
	

 class MyThread extends Thread {

	public void run() {

		for (int i = 10; i > 0; i--) {
			try {
				Thread.sleep(1000);
				// handler.sendMessage(handler.obtainMessage());
				handler.sendMessage(handler.obtainMessage());

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

}
}
