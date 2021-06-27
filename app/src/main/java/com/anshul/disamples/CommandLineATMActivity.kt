package com.anshul.disamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.CommandProcessor
import com.anshul.disamples.atmdagger.di.CommandProcessorFactory


class CommandLineATMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    init {
        val commandProcessor: CommandProcessor = CommandProcessorFactory.create().commandProcessor()
        while (true) {
            val result = commandProcessor.process("deposit colin 2")
            if (result == Command.Status.INPUT_COMPLETED) {
                break
            }
        }
    }
}