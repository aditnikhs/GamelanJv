package id.soewidiatmaka.gamelanjv

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // AdMob Banner
        adViewBanner()

        // Hide Navigation Bar
        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }
                // TODO: The system bars are visible. Make any desired
            }
        }

        // About Popup
        iv_about.setOnClickListener {
            val intent = Intent(this, PopupAbout::class.java)
            startActivity(intent)
        }

        // Bonang
        btn_show_bonang.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_bonang_barung -> {
                        val intent = Intent(this@MainActivity, BonangBarungActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_bonang_penerus -> {
                        val intent = Intent(this@MainActivity,
                            BonangPenerusPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_bonang)
            popupMenu.show()
        }

        // Kendhang
        btn_show_kendhang.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_kendhang_kalih -> {
                        val intent = Intent(this, KendhangKalihActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_kendhang_ciblon -> {
                        val intent = Intent(this, KendhangCiblonActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_kendhang)
            popupMenu.show()
        }

        // SARON
        btn_show_saron.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_saron_panembung -> {
                        val intent = Intent(this, SaronPanembungPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_saron_barung -> {
                        val intent = Intent(this, SaronBarungPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_saron_penerus -> {
                        val intent = Intent(this, SaronPenerusPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_saron)
            popupMenu.show()
        }

        // GENDER
        btn_show_gender.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_gender_panembung -> {
                        val intent = Intent(this, GenderPanembungPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_gender_barung -> {
                        val intent = Intent(this, GenderBarungPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    R.id.menu_gender_penerus -> {
                        val intent = Intent(this, GenderPenerusPelogActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_gender)
            popupMenu.show()
        }

        // KENONG
        btn_show_kenong.setOnClickListener {
            val intent = Intent(this, KenongPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        // KEMPUL
        btn_show_kempul.setOnClickListener {
            val intent = Intent(this, KempulPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    // Back Navigation to EXIT
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }

    // HIDE NAVIGATION RELATED
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

    private fun adViewBanner (){
        // Banner Ads
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
}


