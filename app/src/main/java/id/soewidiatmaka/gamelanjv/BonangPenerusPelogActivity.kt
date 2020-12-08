package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_bonang_penerus_pelog.*

class BonangPenerusPelogActivity : AppCompatActivity(),View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var bb2: Int = 0
    private var bb3: Int = 0
    private var bb4: Int = 0
    private var bb5: Int = 0
    private var bb6: Int = 0
    private var bb7: Int = 0
    private var bb1hi: Int = 0
    private var bb2hi: Int = 0
    private var bb3hi: Int = 0
    private var bb4hi: Int = 0
    private var bb5hi: Int = 0
    private var bb6hi: Int = 0
    private var bb7hi: Int = 0
    private var bb1su: Int = 0

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
        setContentView(R.layout.activity_bonang_penerus_pelog)

        bpp2.setOnClickListener(this)
        bpp3.setOnClickListener(this)
        bpp4.setOnClickListener(this)
        bpp5.setOnClickListener(this)
        bpp6.setOnClickListener(this)
        bpp7.setOnClickListener(this)
        bpp1hi.setOnClickListener(this)
        bpp2hi.setOnClickListener(this)
        bpp3hi.setOnClickListener(this)
        bpp4hi.setOnClickListener(this)
        bpp5hi.setOnClickListener(this)
        bpp6hi.setOnClickListener(this)
        bpp7hi.setOnClickListener(this)
        bpp1su.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .build()
        bb2 = soundPool?.load(this, R.raw.bbp2high, 1)!!
        bb3 = soundPool?.load(this, R.raw.bbp3high, 1)!!
        bb4 = soundPool?.load(this, R.raw.bbp4high, 1)!!
        bb5 = soundPool?.load(this, R.raw.bbp5high, 1)!!
        bb6 = soundPool?.load(this, R.raw.bbp6high, 1)!!
        bb7 = soundPool?.load(this, R.raw.bbp7high, 1)!!
        bb1hi = soundPool?.load(this, R.raw.bbp1sup, 1)!!
        bb2hi = soundPool?.load(this, R.raw.bbp2sup, 1)!!
        bb3hi = soundPool?.load(this, R.raw.bbp3sup, 1)!!
        bb4hi = soundPool?.load(this, R.raw.bbp4sup, 1)!!
        bb5hi = soundPool?.load(this, R.raw.bbp5sup, 1)!!
        bb6hi = soundPool?.load(this, R.raw.bbp6sup, 1)!!
        bb7hi = soundPool?.load(this, R.raw.bbp7sup, 1)!!
        bb1su = soundPool?.load(this, R.raw.bbp1hyp, 1)!!

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
            val intent = Intent(this,BonangPenerusSlendroActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
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
                R.id.bpp2 -> soundPool?.play(bb2, 1f, 1f, 0, 0, 1f)
                R.id.bpp3 -> soundPool?.play(bb3, 1f, 1f, 0, 0, 1f)
                R.id.bpp4 -> soundPool?.play(bb4, 1f, 1f, 0, 0, 1f)
                R.id.bpp5 -> soundPool?.play(bb5, 1f, 1f, 0, 0, 1f)
                R.id.bpp6 -> soundPool?.play(bb6, 1f, 1f, 0, 0, 1f)
                R.id.bpp7 -> soundPool?.play(bb7, 1f, 1f, 0, 0, 1f)
                R.id.bpp1hi -> soundPool?.play(bb1hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp2hi -> soundPool?.play(bb2hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp3hi -> soundPool?.play(bb3hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp4hi -> soundPool?.play(bb4hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp5hi -> soundPool?.play(bb5hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp6hi -> soundPool?.play(bb6hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp7hi -> soundPool?.play(bb7hi, 1f, 1f, 0, 0, 1f)
                R.id.bpp1su -> soundPool?.play(bb1su, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}