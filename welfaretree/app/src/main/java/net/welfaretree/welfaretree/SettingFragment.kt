package net.welfaretree.welfaretree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Switch
import net.welfaretree.welfaretree.R

class SettingFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_fragment)

        val receiveNotiLayout : RelativeLayout = findViewById(R.id.receiveNotiLayout)
        val switchReceiveNoti : Switch = findViewById(R.id.switchReceiveNoti)
    }
}