package com.iamincendium.spacetraders.api.result

import com.github.michaelbull.result.Result
import com.iamincendium.spacetraders.api.error.APIError

public typealias APIResult<T> = Result<T, APIError>
