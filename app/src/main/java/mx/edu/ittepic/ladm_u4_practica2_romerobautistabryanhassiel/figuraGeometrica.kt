package mx.edu.ittepic.ladm_u4_practica2_romerobautistabryanhassiel

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import java.util.*

class figuraGeometrica(){

    var x = 0f
    var y = 0f
    var tipo = 1 //1 Rectangulo 2 Circulo  3 Bitmao
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 5
    var incY = 5
    var bitmap : Bitmap?=null
    var s = MainActivity()

    constructor(x:Int,y:Int,radio:Int):this(){//constructor del circulo
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio=radio.toFloat()
        this.tipo = 2

        ancho = this.radio*2    //tratar el circulo como un cuadrado
        alto= ancho

    }

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            2->{
                c.drawCircle(x+radio,y+radio,radio,p)
            }
            3 ->{
                c.drawBitmap(bitmap!!,x,y,p)
            }
        }
    }

    fun rebote(ancho:Int, alto:Int, xs:Boolean, ys:Boolean,r:Boolean){
        if (ys) y-=incY
        else y+=incY
        if (xs) x+=incX
        else x-=incX
        if(r){
            x = 500f
            y = 500f
        }
    }
}