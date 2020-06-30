package com.dgdevelop.crashreporting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun divide(view: View) {
        val n1: Int = etNumber1.text.toString().toInt()
        val n2: Int = etNumber2.text.toString().toInt()

        try {
            tvResult.append((n1 / n2).toString())

        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException")
            Crashlytics.setString(TAG, "NumberFormatException")
            Crashlytics.log("Ocurrió un NumberFormatException")
            Crashlytics.log(Log.ERROR, TAG, "NumberFormatException Logcat")

            nfe.printStackTrace()
        } catch (e: NullPointerException) {
            e.printStackTrace()
            Crashlytics.log("Ocurrió un NullPointerException")
            Crashlytics.log(Log.ERROR, TAG, "NullPointerException Logcat")
        } catch (e: Exception) {
            Log.e(TAG, "Exception ${e.message}")
            e.printStackTrace()
            Crashlytics.setString(TAG, "Exception")
            Crashlytics.log("Ocurrió un Exception")
            Crashlytics.log(Log.ERROR, TAG, "Exception Logcat")
        }
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}