package com.anshul.disamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.CommandProcessor
import com.anshul.disamples.atmdagger.di.*
import com.anshul.disamples.atmdagger.di.CommandRouterFactory
import com.anshul.disamples.atmdagger.di.SystemOutModule
import com.anshul.disamples.atmdagger.di.UserCommandsModule
import dagger.Component


class CommandLineATMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    init {
        val commandProcessor: CommandProcessor = CommandProcessorFactory.create().commandProcessor()
        while (true){
            val result = commandProcessor.process("deposit colin 2")
            if (result == Command.Status.INPUT_COMPLETED){
                break
            }
        }
    }
}