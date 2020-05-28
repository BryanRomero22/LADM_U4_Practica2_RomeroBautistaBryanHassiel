package mx.edu.ittepic.ladm_u4_practica2_romerobautistabryanhassiel

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat.*

class Lienzo(p:MainActivity): View(p){

    var puntero=p
    var circulo = figuraGeometrica(15,15,120)
    var s = MainActivity()
    var x2 = false
    var y2 = false
    var r = false

    override fun onDraw(c: Canvas){

        super.onDraw(c)

        var paint = Paint()

        c.drawColor(Color.BLACK)

        //Dibujando un círculo rojo con contorno blanco
        paint.color = Color.RED
        circulo.pintar(c,paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo.pintar(c,paint)
    }
    /*si yo quiero dibujar otra figura, como le hago para moverla si  crear mas variables?*/

    fun animarCirculo(){
        circulo.rebote(width,height,x2,y2,r)
        invalidate()
    }
}//como agregar imagenes al canvas