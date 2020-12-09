package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_gender_barung_slendro.*
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.*
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btn_home
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btn_switch
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender1
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender10
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender11
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender12
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender13
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender14
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender2
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender3
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender4
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender5
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender6
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender7
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender8
import kotlinx.android.synthetic.main.activity_gender_penerus_slendro.btngender9

class GenderPenerusSlendroActivity : AppCompatActivity(), View.OnClickListener {
    private var soundPool: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var btn1: Int = 0
    private var btn2: Int = 0
    private var btn3: Int = 0
    private var btn4: Int = 0
    private var btn5: Int = 0
    private var btn6: Int = 0
    private var btn7: Int = 0
    private var btn8: Int = 0
    private var btn9: Int = 0
    private var btn10: Int = 0
    private var btn11: Int = 0
    private var btn12: Int = 0
    private var btn13: Int = 0
    private var btn14: Int = 0
    private var isPlayingcek: Boolean? = true
    private var cek1:Boolean? = false
    private var cek2:Boolean? = false
    private var cek3:Boolean? = false
    private var cek4:Boolean? = false
    private var cek5:Boolean? = false
    private var cek6:Boolean? = false
    private var cek7:Boolean? = false
    private var cek8:Boolean? = false
    private var cek9:Boolean? = false
    private var cek10:Boolean? = false
    private var cek11:Boolean? = false
    private var cek12:Boolean? = false
    private var cek13:Boolean? = false
    private var cek14:Boolean? = false


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
        setContentView(R.layout.activity_gender_penerus_slendro)

        btngender1.setOnClickListener(this)
        btngender2.setOnClickListener(this)
        btngender3.setOnClickListener(this)
        btngender4.setOnClickListener(this)
        btngender5.setOnClickListener(this)
        btngender6.setOnClickListener(this)
        btngender7.setOnClickListener(this)
        btngender8.setOnClickListener(this)
        btngender9.setOnClickListener(this)
        btngender10.setOnClickListener(this)
        btngender11.setOnClickListener(this)
        btngender12.setOnClickListener(this)
        btngender13.setOnClickListener(this)
        btngender14.setOnClickListener(this)
        buildSoundPool()

        buildSoundPool2()

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }
                // TODO: The system bars are visible. Make any desired
            }
        }

        btn_home.setOnClickListener(){
            adViewInit()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        btn_switch.setOnClickListener(){
            val intent = Intent(this,GenderPenerusPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }
    override fun onBackPressed() {
        adViewInit()
        super.onBackPressed()
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
                R.id.btngender1 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                        cek1 = true
                        false
                    } else {
                        cek1 = if (cek1!!){
                            soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn1, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender2 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                        cek2 = true
                        false
                    } else {
                        cek2 = if (cek2!!){
                            soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn2, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender3 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                        cek3 = true
                        false
                    } else {
                        cek3 = if (cek3!!){
                            soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn3, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender4 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                        cek4 = true
                        false
                    } else {
                        cek4 = if (cek4!!){
                            soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn4, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender5 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                        cek5 = true
                        false
                    } else {
                        cek5 = if (cek5!!){
                            soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn5, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender6 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                        cek6 = true
                        false
                    } else {
                        cek6 = if (cek6!!){
                            soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool?.play(btn6, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender7 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn7, 1f, 1f, 0, 0, 1f)
                        cek7 = true
                        false
                    } else {
                        cek7 = if (cek7!!){
                            soundPool2?.play(btn7, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn7, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender8 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn8, 1f, 1f, 0, 0, 1f)
                        cek8 = true
                        false
                    } else {
                        cek8 = if (cek8!!){
                            soundPool2?.play(btn8, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn8, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender9 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn9, 1f, 1f, 0, 0, 1f)
                        cek9 = true
                        false
                    } else {
                        cek9 = if (cek9!!){
                            soundPool2?.play(btn9, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn9, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender10 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn10, 1f, 1f, 0, 0, 1f)
                        cek10 = true
                        false
                    } else {
                        cek10 = if (cek10!!){
                            soundPool2?.play(btn10, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn10, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender11 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn11, 1f, 1f, 0, 0, 1f)
                        cek11 = true
                        false
                    } else {
                        cek11 = if (cek11!!){
                            soundPool2?.play(btn11, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn11, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender12 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn12, 1f, 1f, 0, 0, 1f)
                        cek12 = true
                        false
                    } else {
                        cek12 = if (cek12!!){
                            soundPool2?.play(btn12, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn12, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender13 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn13, 1f, 1f, 0, 0, 1f)
                        cek13 = true
                        false
                    } else {
                        cek13 = if (cek13!!){
                            soundPool2?.play(btn13, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn13, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
                R.id.btngender14 -> {
                    isPlayingcek = if (isPlayingcek!!) {
                        soundPool2?.play(btn14, 1f, 1f, 0, 0, 1f)
                        cek14 = true
                        false
                    } else {
                        cek14 = if (cek14!!){
                            soundPool2?.play(btn14, 1f, 1f, 0, 0, 1f)
                            true

                        } else{
//                            stopPlaying()
                            soundPool2?.play(btn14, 1f, 1f, 0, 0, 1f)
                            true
                        }
                        false
                    }
                }
            }
        }
    }
    private fun buildSoundPool(){
        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .build()
        btn1 = soundPool?.load(this,R.raw.gss6,1)!!
        btn2 = soundPool?.load(this, R.raw.gbs1, 1)!!
        btn3 = soundPool?.load(this,R.raw.gbs2,1)!!
        btn4 = soundPool?.load(this, R.raw.gbs3, 1)!!
        btn5 = soundPool?.load(this,R.raw.gbs5,1)!!
        btn6 = soundPool?.load(this, R.raw.gbs6, 1)!!
    }
    private fun buildSoundPool2(){
        soundPool2 = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        btn7 = soundPool2?.load(this,R.raw.gbs1high,1)!!
        btn8 = soundPool2?.load(this,R.raw.gbs2high,1)!!
        btn9 = soundPool2?.load(this, R.raw.gbs3high, 1)!!
        btn10 = soundPool2?.load(this,R.raw.gbs5high,1)!!
        btn11 = soundPool2?.load(this, R.raw.gbs6high, 1)!!
        btn12 = soundPool2?.load(this,R.raw.gbs1sup,1)!!
        btn13 = soundPool2?.load(this, R.raw.gbs2sup, 1)!!
        btn14 = soundPool2?.load(this,R.raw.gbs3sup,1)!!
    }
}