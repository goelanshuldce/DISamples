package com.anshul.disamples.atmdagger

/** Generic interface for multiple implementations of outputter.  */
internal fun interface Outputter {

    /** String inout to display  */
    fun output(output: String)
}