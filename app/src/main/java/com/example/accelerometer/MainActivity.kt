package com.example.accelerometer

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.hardware.Sensor
import android.hardware.SensorManager
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.view.View


class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager

    override fun onSensorChanged(event: SensorEvent?) {
        lblReadings.text = "X : ${event!!.values[0]}\n" +
                "Y : ${event.values[1]}\n" +
                "Z : ${event.values[2]}"
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )

        btnStart.setOnClickListener {


            if(btnStart.text == "Start"){
                btnStart.text = "Stop"
                lblTopic.visibility = View.VISIBLE
                lblReadings.visibility = View.VISIBLE

            }
            else {
                btnStart.text = "Start"
                lblTopic.visibility=View.INVISIBLE
                lblReadings.visibility=View.INVISIBLE
            }
        }
    }
}
