package com.fomart.spx.core.model.domain.error

sealed class NetworkError : Error() {

    object NoInternet : NetworkError()

    data class HttpError(val code: Int, val message: String? = null) : NetworkError()

    object Timeout : NetworkError()

    data class ParsingError(val cause: Throwable? = null) : NetworkError()

    data class Unknown(val cause: Throwable? = null) : NetworkError()
}