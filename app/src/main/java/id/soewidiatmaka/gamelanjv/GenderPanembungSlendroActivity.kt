package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_gender_panembung_slendro.*

class GenderPanembungSlendroActivity : AppCompatActivity(),View.OnClickListener {
    private var soundPool: SoundPool? = null
    private var btn1: Int = 0
    private var btn2: Int = 0
    private var btn3: Int = 0
    private var btn4: Int = 0
    private var btn5: Int = 0
    private var btn6: Int = 0
    private var btn7: Int = 0
    private var isPlayingcek: Boolean? = true
    private var cek1:Boolean? = false
    private var cek2:Boolean? = false
    private var cek3:Boolean? = false
    private var cek4:Boolean? = false
    private var cek5:Boolean? = false
    private var cek6:Boolean? = false
    private var cek7:Boolean? = false

    // ADMOB INTERSTISIAL
    private lateinit var mInterstitialAd: InterstitialAd
    private fun adViewInit(){
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.UnitIdInterstisial)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object : AdListener(){
            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender_panembung_slendro)

        btnslenthem1.setOnClickListener(this)
        btnslenthem2.setOnClickListener(this)
        btnslenthem3.setOnClickListener(this)
        btnslenthem4.setOnClickListener(this)
        btnslenthem5.setOnClickListener(this)
        btnslenthem6.setOnClickListener(this)
        btnslenthem7.setOnClickListener(this)
        soundPool = SoundPool.Builder()
            .build()
        btn1 = soundPool?.load(this,R.raw.gss6low,1)!!
        btn2 = soundPool?.load(this, R.raw.gss1, 1)!!
        btn3 = soundPool?.load(this,R.raw.gss2,1)!!
        btn4 = soundPool?.load(this, R.raw.gss3, 1)!!
        btn5 = soundPool?.load(this,R.raw.gss5,1)!!
        btn6 = soundPool?.load(this, R.raw.gss6, 1)!!
        btn7 = soundPool?.load(this,R.raw.gss1high,1)!!

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }
            }
        }

        btn_home.setOnClickListener {
            adViewInit()
            soundPool?.release()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        btn_switch.setOnClickListener {
            soundPool?.release()
            val intent = Intent(this,GenderPanembungPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }
    override fun onBackPressed() {
        adViewInit()
        super.onBackPressed()
        soundPool?.release()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            window.decorView.apply {
                systemUiVisibility = hideSystemBars()
            }

        }
    }

    private fun hideSystemBars(): Int {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btnslenthem1 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                        cek1 = true
                        false
                    } else {
                        cek1 = if (cek1!!){
                            soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem2 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                        cek2 = true
                        false
                    } else {
                        cek2 = if (cek2!!){
                            soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem3 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                        cek3 = true
                        false
                    } else {
                        cek3 = if (cek3!!){
                            soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem4 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                        cek4 = true
                        false
                    } else {
                        cek4 = if (cek4!!){
                            soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem5 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                        cek5 = true
                        false
                    } else {
                        cek5 = if (cek5!!){
                            soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem6 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                        cek6 = true
                        false
                    } else {
                        cek6 = if (cek6!!){
                            soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btnslenthem7 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn7, 1f, 1f, 0, 0, 1f)
                        cek7 = true
                        false
                    } else {
                        cek7 = if (cek7!!){
                            soundPool?.play(btn7, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
                            stopPlaying()
                            soundPool?.play(btn7, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
            }
        }

    }

    // TAMBAH INI JUGA
    private fun stopPlaying (){
        isPlayingcek = true
        if (cek1!!){
            soundPool?.stop(btn1)
//            btn1 = soundPool?.load(this,R.raw.sps6low,1)!!
            cek1=false
        }
        else if (cek2!!){
            soundPool?.stop(btn2)
//            btn2 = soundPool?.load(this,R.raw.sps1,1)!!
            cek2=false
        }
        else if (cek3!!){
            soundPool?.stop(btn3)
//            btn3 = soundPool?.load(this,R.raw.sps2,1)!!
            cek3=false
        }
        else if (cek4!!){
            soundPool?.stop(btn4)
//            btn4 = soundPool?.load(this,R.raw.sps3,1)!!
            cek4=false
        }
        else if (cek5!!){
            soundPool?.stop(btn5)
//            btn5 = soundPool?.load(this,R.raw.sps5,1)!!
            cek5=false
        }else if (cek6!!){
            soundPool?.stop(btn6)
//            btn6 = soundPool?.load(this,R.raw.sps6,1)!!
            cek6=false
        }else if (cek7!!){
            soundPool?.stop(btn7)
//            btn7 = soundPool?.load(this,R.raw.sps1high,1)!!
            cek7=false
        }
    }
}