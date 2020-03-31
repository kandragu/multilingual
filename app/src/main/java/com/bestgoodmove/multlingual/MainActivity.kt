package com.bestgoodmove.multlingual

//import sun.jvm.hotspot.utilities.IntArray

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_chinese.setOnClickListener(View.OnClickListener {
            Helper.updateResources(this@MainActivity, "zh")

            recreate()
        })

        button_tamil.setOnClickListener(View.OnClickListener {
            //            Helper.setLocale(this@MainActivity, "zh")
            Helper.updateResources(this@MainActivity, "ta")

            recreate()
        })

        button_first.setOnClickListener(View.OnClickListener {
            //            Helper.setLocale(this@MainActivity, "zh")
            Helper.updateResources(this@MainActivity, "en")

            recreate()
        })

      //  Helper.updateResources1(this@MainActivity, "zh")
    }

    override fun attachBaseContext(context: Context) {
//        super.attachBaseContext(context.changeLocale("zh"))
        super.attachBaseContext(localeUpdateResources(context, "zh"));
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val primaryLocale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    val primaryLocale: Locale =  this.resources.configuration.locales[0]
//                    val locale = primaryLocale.displayName
//                    Log.d("tag", locale)
//                    val locale1 = Locale("zh")
//                    Locale.setDefault(locale1);
//                    val configuration: Configuration = this.getResources().getConfiguration()
//                    configuration.setLocale(locale1)

                    recreate();
                    return true;
                } else {
                    TODO("VERSION.SDK_INT < N")
                }

                return true;
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun Context.changeLocale(language:String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = this.resources.configuration
        config.setLocale(locale)
        return createConfigurationContext(config)
    }

    fun localeUpdateResources(context: Context, languageCode: String): Context? {
        var newContext: Context? = context
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources: Resources = context.resources
        val config = Configuration(resources.getConfiguration())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale)
            newContext = context.createConfigurationContext(config)
        } else {
            config.locale = locale
            resources.updateConfiguration(config, resources.getDisplayMetrics())
        }

        return newContext
    }
}
