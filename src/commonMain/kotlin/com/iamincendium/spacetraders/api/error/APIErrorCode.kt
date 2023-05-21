package com.iamincendium.spacetraders.api.error

public sealed interface APIErrorCode {
    public val code: Int

    public enum class General(override val code: Int) : APIErrorCode {
        COOLDOWN_CONFLICT(4000),
        WAYPOINT_NO_ACCESS(4001),
    }

    public enum class Account(override val code: Int) : APIErrorCode {
        TOKEN_EMPTY(4100),
        TOKEN_MISSING_SUBJECT(4101),
        TOKEN_INVALID_SUBJECT(4102),
        MISSING_TOKEN_REQUEST(4103),
        INVALID_TOKEN_REQUEST(4104),
        INVALID_TOKEN_SUBJECT(4105),
        ACCOUNT_NOT_EXISTS(4106),
        AGENT_NOT_EXISTS(4107),
        ACCOUNT_HAS_NO_AGENT(4108),
        REGISTER_AGENT_EXISTS(4109),
    }

    public enum class Ship(override val code: Int) : APIErrorCode {
        NAVIGATE_IN_TRANSIT(4200),
        NAVIGATE_INVALID_DESTINATION(4201),
        NAVIGATE_OUTSIDE_SYSTEM(4202),
        NAVIGATE_INSUFFICIENT_FUEL(4203),
        NAVIGATE_SAME_DESTINATION(4204),
        SHIP_EXTRACT_INVALID_WAYPOINT(4205),
        SHIP_EXTRACT_PERMISSION(4206),
        SHIP_JUMP_NO_SYSTEM(4207),
        SHIP_JUMP_SAME_SYSTEM(4208),
        SHIP_JUMP_MISSING_MODULE(4210),
        SHIP_JUMP_NO_VALID_WAYPOINT(4211),
        SHIP_JUMP_MISSING_ANTIMATTER(4212),
        SHIP_IN_TRANSIT(4214),
        SHIP_MISSING_SENSOR_ARRAYS(4215),
        PURCHASE_SHIP_CREDITS(4216),
        SHIP_CARGO_EXCEEDS_LIMIT(4217),
        SHIP_CARGO_MISSING(4218),
        SHIP_CARGO_UNIT_COUNT(4219),
        SHIP_SURVEY_VERIFICATION(4220),
        SHIP_SURVEY_EXPIRATION(4221),
        SHIP_SURVEY_WAYPOINT_TYPE(4222),
        SHIP_SURVEY_ORBIT(4223),
        SHIP_SURVEY_EXHAUSTED(4224),
        SHIP_REFUEL_DOCKED(4225),
        SHIP_REFUEL_INVALID_WAYPOINT(4226),
        SHIP_MISSING_MOUNTS(4227),
        SHIP_CARGO_FULL(4228),
        SHIP_JUMP_FROM_GATE_TO_GATE(4229),
        WAYPOINT_CHARTED(4230),
        SHIP_TRANSFER_SHIP_NOT(4231),
        SHIP_TRANSFER_AGENT_CON(4232),
        SHIP_TRANSFER_SAME_SHIP_CON(4233),
        SHIP_TRANSFER_LOCATION_CON(4234),
        WARP_INSIDE_SYSTEM(4235),
        SHIP_NOT_IN_ORBIT(4236),
        SHIP_INVALID_REFINERY_GOOD(4237),
        SHIP_INVALID_REFINERY_TYPE(4238),
        SHIP_MISSING_REFINERY(4239),
        SHIP_MISSING_SURVEYOR(4240),
    }

    public enum class Contract(override val code: Int) : APIErrorCode {
        ACCEPT_CONTRACT_NOT_AUTHORIZED(4500),
        ACCEPT_CONTRACT_CONFLICT(4501),
        FULFILL_CONTRACT_DELIVERY(4502),
        CONTRACT_DEADLINE(4503),
        CONTRACT_FULFILLED(4504),
        CONTRACT_NOT_ACCEPTED(4505),
        CONTRACT_NOT_AUTHORIZED(4506),
        SHIP_DELIVER_TERMS(4508),
        SHIP_DELIVER_FULFILLED(4509),
        SHIP_DELIVER_INVALID_LOCATION(4510),
    }

    public enum class Market(override val code: Int) : APIErrorCode {
        MARKET_TRADE_INSUFFICIENT_CREDITS(4600),
        MARKET_TRADE_NO_PURCHASE(4601),
        MARKET_TRADE_NOT_SOLD(4602),
        MARKET_NOT_FOUND(4603),
        MARKET_TRADE_UNIT_LIMIT(4604),
    }

    public data class Unknown(override val code: Int): APIErrorCode
}

private val ERROR_CODE_TO_ENUM = buildList<APIErrorCode> {
    addAll(APIErrorCode.General.values())
    addAll(APIErrorCode.Account.values())
    addAll(APIErrorCode.Ship.values())
    addAll(APIErrorCode.Contract.values())
    addAll(APIErrorCode.Market.values())
}.associateBy { it.code }

internal fun APIErrorCode(code: Int): APIErrorCode = ERROR_CODE_TO_ENUM[code] ?: APIErrorCode.Unknown(code)
