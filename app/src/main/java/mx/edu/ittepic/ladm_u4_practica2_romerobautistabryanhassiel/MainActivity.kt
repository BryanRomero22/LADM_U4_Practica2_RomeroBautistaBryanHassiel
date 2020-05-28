package mx.edu.ittepic.ladm_u4_practica2_romerobautistabryanhassiel

import android.content.Context
import android.hardware.*
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    var lienzo :Lienzo ?= null
    var x = 0.0
    var y = 0.0
    lateinit var sensorManager : SensorManager
    lateinit var sensorManager2 : SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager2 = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager2.registerListener(this,sensorManager2.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager2

        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)

        Hilo(this).start()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        x = event!!.values[0].toDouble()
        y = event!!.values[1].toDouble()
        //this.setTitle("x:${getX()}, y:${getY()}")
        lienzo!!.y2 = getY()
        lienzo!!.x2 = getX()
        this.setTitle("${event.values[0]}")
        if(event.values[0].toInt() == 0 ){
            lienzo!!.r = true
        }
        else lienzo!!.r = false

    }


    fun getX():Boolean{
        if (x<0) return true
        return false
    }

    fun getY():Boolean{
        if (y<0) return true
        return false
    }
}
