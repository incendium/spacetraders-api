package com.iamincendium.spacetraders.api.error

import kotlinx.serialization.json.JsonObject


/**
 * Denotes an error that is returned from the server.
 *
 * @property code the error code returned by the server
 * @property extraData a JSON object returned by the server providing an extra context related to this error
 */
public sealed interface ServerError : HTTPError {
    public val code: Int
    public val extraData: JsonObject
}
