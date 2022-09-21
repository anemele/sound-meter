package com.js.soundmeter.ui.noise

import android.os.Bundle
import com.js.soundmeter.R
import com.js.soundmeter.ui.base.BaseFragmentActivity

class MeasureNoiseActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_fragment)

        addView(MeasureNoiseFragment())
    }
}