package com.bestgoodmove.multlingual

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class Helper {
    companion object {

         fun updateResources(
            context: Context,
            language: String
        ) {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val res: Resources = context.resources
            val config = Configuration(res.getConfiguration())
            config.locale = locale
            res.updateConfiguration(config, res.getDisplayMetrics())
        }
    }
}