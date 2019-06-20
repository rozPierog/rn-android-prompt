package com.rozpierog.prompt

import android.support.v7.app.AlertDialog
import android.text.SpannableStringBuilder
import android.widget.EditText
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.util.Collections.emptyMap

class Prompt(private val reactContext: ReactApplicationContext) :
        ReactContextBaseJavaModule(reactContext) {
    companion object {
        const val NAME = "Prompt"
    }

    override fun getName(): String = NAME

    override fun getConstants(): Map<String, Any>? = emptyMap()

    @ReactMethod
    fun prompt(title: String, defaultValue: String, promise: Promise) {
        val taskEditText = EditText(reactContext)
        if (defaultValue.isBlank()) {
            taskEditText.text = SpannableStringBuilder(defaultValue)
        }
        AlertDialog.Builder(reactContext)
                .setTitle(title)
                .setView(taskEditText)
                .setPositiveButton("OK"
                ) { _, _ ->
                    promise.resolve(taskEditText.text.toString())
                }
                .setNegativeButton("Cancel", null)
                .create()
                .show()
    }
}
