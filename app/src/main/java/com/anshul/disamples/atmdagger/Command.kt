package com.anshul.disamples.atmdagger

/** Logic to process some user input.  */
internal interface Command {
    /**
     * String token that signifies this command should be selected (e.g.:
     * "deposit", "withdraw")
     */
//    fun key(): String

    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String>): Result

    /**
     * A command result, which has a [Status] and optionally a new [CommandRouter] that
     * will handle subsequent commands.
     */
    class Result private constructor(
        private val status: Status,
        private val nestedCommandRouter: CommandRouter?
    ) {
        fun status(): Status {
            return status
        }

        fun nestedCommandRouter(): CommandRouter? {
            return nestedCommandRouter
        }

        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID, null)
            }

            fun handled(): Result {
                return Result(Status.HANDLED, null)
            }

            fun inputCompleted(): Result {
                return Result(Status.INPUT_COMPLETED, null)
            }

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter?): Result {
                return Result(Status.HANDLED, nestedCommandRouter)
            }
        }

    }

    enum class Status {
        /** The command or its arguments were invalid. */
        INVALID,

        /** The command handled the input and no other commands should attempt to handle it. */
        HANDLED,

        /** The command handled the input and no further inputs should be submitted. */
        INPUT_COMPLETED
    }
}

