package id.soewidiatmaka.gamelanjv

import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var btn4: Button? = null
    private var soundPool: SoundPool? = null
    var tak: Int = 0
    var dah: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        btn1 = findViewById<View>(R.id.button1) as Button
        btn2 = findViewById<View>(R.id.button2) as Button
        btn3 = findViewById<View>(R.id.button3) as Button
        btn4 = findViewById<View>(R.id.button4) as Button
        btn1!!.setOnClickListener(this)
        btn2!!.setOnClickListener(this)
        btn3!!.setOnClickListener(this)
        btn4!!.setOnClickListener(this)
        soundPool = SoundPool.Builder()
            .setMaxStreams(6)
            .build()
        tak = soundPool?.load(this,R.raw.dah,1)!!
        dah = soundPool?.load(this, R.raw.dah, 1)!!
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button3 -> soundPool?.play(tak, 1f, 1f, 0, 0, 1f)
            R.id.button4 -> soundPool?.play(dah, 1f, 1f, 0, 0, 1f)
        }
    }
}