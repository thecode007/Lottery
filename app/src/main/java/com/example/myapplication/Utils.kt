package com.example.myapplication

import android.content.Context
import android.os.Build

class Utils {

    companion object{
        private fun getLocale(context: Context): String {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales[0].toLanguageTag();
            } else {
                context.resources.configuration.locale.language;
            }

        }

        fun isGreek(context: Context):Boolean {
            return getLocale(context) == "el-GR" ||  getLocale(context) == "el-CY"
        }
    }


}
//