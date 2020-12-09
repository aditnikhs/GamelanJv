package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_kenong_pelog.*

class KenongPelogActivity : AppCompatActivity(), View.OnClickListener {
    private var soundPool: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private var kng2: Int = 0
    private var kng3: Int = 0
    private var kng5: Int = 0
    private var kng6: Int = 0
    private var kng7: Int = 0
    private var kng1hi: Int = 0
    private var ktk: Int = 0
    private var kpy: Int = 0

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
        setContentView(R.layout.activity_kenong_pelog)

        kenong2.setOnClickListener(this)
        kenong3.setOnClickListener(this)
        kenong5.setOnClickListener(this)
        kenong6.setOnClickListener(this)
        kenong7.setOnClickListener(this)
        kenong1hi.setOnClickListener(this)
        kethuk.setOnClickListener(this)
        kempyang.setOnClickListener(this)
        soundbuild()
        soundbuild2()
        soundbuild3()


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
            val intent = Intent(this,KenongSlendroActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }

    private fun soundbuild2() {
        soundPool2 = SoundPool.Builder()
            .build()
        ktk = soundPool2?.load(this, R.raw.ktkp, 1)!!
    }
    private fun soundbuild3() {
        soundPool3 = SoundPool.Builder()
            .build()
        kpy = soundPool3?.load(this, R.raw.kpyp, 1)!!
    }

    private fun soundbuild() {
        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        kng2 = soundPool?.load(this, R.raw.kp2, 1)!!
        kng3 = soundPool?.load(this, R.raw.kp3, 1)!!
        kng5 = soundPool?.load(this,R.raw.kp5,1)!!
        kng6 = soundPool?.load(this, R.raw.kp6, 1)!!
        kng7 = soundPool?.load(this, R.raw.kp7, 1)!!
        kng1hi = soundPool?.load(this,R.raw.kp1high,1)!!
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
                R.id.kenong2 -> soundPool?.play(kng2, 1f, 1f, 0, 0, 1f)
                R.id.kenong3 -> soundPool?.play(kng3, 1f, 1f, 0, 0, 1f)
                R.id.kenong5 -> soundPool?.play(kng5, 1f, 1f, 0, 0, 1f)
                R.id.kenong6 -> soundPool?.play(kng6, 1f, 1f, 0, 0, 1f)
                R.id.kenong7 -> soundPool?.play(kng7, 1f, 1f, 0, 0, 1f)
                R.id.kenong1hi -> soundPool?.play(kng1hi, 1f, 1f, 0, 0, 1f)
                R.id.kethuk -> soundPool2?.play(ktk, 1f, 1f, 0, 0, 1f)
                R.id.kempyang -> soundPool3?.play(kpy, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}