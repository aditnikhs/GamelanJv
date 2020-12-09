package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_bonang_barung_slendro.*

class BonangBarungSlendroActivity : AppCompatActivity(), View.OnClickListener {
    private var soundPool: SoundPool? = null
    private var bb1: Int = 0
    private var bb2: Int = 0
    private var bb3: Int = 0
    private var bb5: Int = 0
    private var bb6: Int = 0
    private var bb1hi: Int = 0
    private var bb2hi: Int = 0
    private var bb3hi: Int = 0
    private var bb5hi: Int = 0
    private var bb6hi: Int = 0
    private var bb1su: Int = 0
    private var bb2su: Int = 0

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
        setContentView(R.layout.activity_bonang_barung_slendro)

        bbs1.setOnClickListener(this)
        bbs2.setOnClickListener(this)
        bbs3.setOnClickListener(this)
        bbs5.setOnClickListener(this)
        bbs6.setOnClickListener(this)
        bbs1hi.setOnClickListener(this)
        bbs2hi.setOnClickListener(this)
        bbs3hi.setOnClickListener(this)
        bbs5hi.setOnClickListener(this)
        bbs6hi.setOnClickListener(this)
        bbs1su.setOnClickListener(this)
        bbs2su.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        bb1 = soundPool?.load(this,R.raw.bbs1,1)!!
        bb2 = soundPool?.load(this, R.raw.bbs2, 1)!!
        bb3 = soundPool?.load(this, R.raw.bbs3, 1)!!
        bb5 = soundPool?.load(this,R.raw.bbs5,1)!!
        bb6 = soundPool?.load(this, R.raw.bbs6, 1)!!
        bb1hi = soundPool?.load(this,R.raw.bbs1high,1)!!
        bb2hi = soundPool?.load(this, R.raw.bbs2high, 1)!!
        bb3hi = soundPool?.load(this, R.raw.bbs3high, 1)!!
        bb5hi = soundPool?.load(this,R.raw.bbs5high,1)!!
        bb6hi = soundPool?.load(this, R.raw.bbs6high, 1)!!
        bb1su = soundPool?.load(this,R.raw.bbs1sup,1)!!
        bb2su = soundPool?.load(this, R.raw.bbs2sup, 1)!!

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
            val intent = Intent(this,BonangBarungActivity::class.java)
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
                R.id.bbs1 -> soundPool?.play(bb1, 1f, 1f, 0, 0, 1f)
                R.id.bbs2 -> soundPool?.play(bb2, 1f, 1f, 0, 0, 1f)
                R.id.bbs3 -> soundPool?.play(bb3, 1f, 1f, 0, 0, 1f)
                R.id.bbs5 -> soundPool?.play(bb5, 1f, 1f, 0, 0, 1f)
                R.id.bbs6 -> soundPool?.play(bb6, 1f, 1f, 0, 0, 1f)
                R.id.bbs1hi -> soundPool?.play(bb1hi, 1f, 1f, 0, 0, 1f)
                R.id.bbs2hi -> soundPool?.play(bb2hi, 1f, 1f, 0, 0, 1f)
                R.id.bbs3hi -> soundPool?.play(bb3hi, 1f, 1f, 0, 0, 1f)
                R.id.bbs5hi -> soundPool?.play(bb5hi, 1f, 1f, 0, 0, 1f)
                R.id.bbs6hi -> soundPool?.play(bb6hi, 1f, 1f, 0, 0, 1f)
                R.id.bbs1su -> soundPool?.play(bb1su, 1f, 1f, 0, 0, 1f)
                R.id.bbs2su -> soundPool?.play(bb2su, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}