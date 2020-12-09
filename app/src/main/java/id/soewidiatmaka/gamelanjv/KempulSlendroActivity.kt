package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_kempul_slendro.*

class KempulSlendroActivity : AppCompatActivity(), View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var kp3: Int = 0
    private var kp5: Int = 0
    private var kp6: Int = 0
    private var kp1: Int = 0
    private var kp2: Int = 0
    private var soundPool2: SoundPool? = null
    private var gs1: Int = 0
    private var gs2: Int = 0
    private var gg: Int = 0

    // ADMOB INTERSTISIAL
    private lateinit var mInterstitialAd: InterstitialAd
    private fun adViewInit() {
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.UnitIdInterstisial)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kempul_slendro)

        kempul3.setOnClickListener(this)
        kempul5.setOnClickListener(this)
        kempul6.setOnClickListener(this)
        kempul1.setOnClickListener(this)
        kempul2.setOnClickListener(this)
        gswk1.setOnClickListener(this)
        gswk2.setOnClickListener(this)
        ggede.setOnClickListener(this)

        sounbuild1()
        soundbuild2()

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }
            }
        }

        btn_home.setOnClickListener {
            adViewInit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        btn_switch.setOnClickListener {
            val intent = Intent(this, KempulPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }

    override fun onBackPressed() {
        adViewInit()
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.apply {
                systemUiVisibility = hideSystemBars()
            }

        }
    }

    private fun hideSystemBars(): Int {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    private fun sounbuild1() {
        soundPool = SoundPool.Builder()
            .build()
        kp2 = soundPool?.load(this, R.raw.kps2, 1)!!
        kp3 = soundPool?.load(this, R.raw.kps3, 1)!!
        kp5 = soundPool?.load(this, R.raw.kps5, 1)!!
        kp6 = soundPool?.load(this, R.raw.kps6, 1)!!
        kp1 = soundPool?.load(this, R.raw.kps1, 1)!!
    }

    private fun soundbuild2() {
        soundPool2 = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        gs1 = soundPool2?.load(this, R.raw.gsws1, 1)!!
        gs2 = soundPool2?.load(this, R.raw.gsws2, 1)!!
        gg = soundPool2?.load(this, R.raw.ggede6, 1)!!
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.kempul1 -> soundPool?.play(kp1, 1f, 1f, 0, 0, 1f)
                R.id.kempul2 -> soundPool?.play(kp2, 1f, 1f, 0, 0, 1f)
                R.id.kempul3 -> soundPool?.play(kp3, 1f, 1f, 0, 0, 1f)
                R.id.kempul5 -> soundPool?.play(kp5, 1f, 1f, 0, 0, 1f)
                R.id.kempul6 -> soundPool?.play(kp6, 1f, 1f, 0, 0, 1f)
                R.id.gswk1 -> soundPool2?.play(gs1, 1f, 1f, 0, 0, 1f)
                R.id.gswk2 -> soundPool2?.play(gs2, 1f, 1f, 0, 0, 1f)
                R.id.ggede -> soundPool2?.play(gg, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}