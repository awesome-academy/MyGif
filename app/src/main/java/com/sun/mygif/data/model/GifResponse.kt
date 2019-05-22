package com.sun.mygif.data.model

import org.json.JSONObject

private const val ID = "id"
private const val IMAGES = "images"
private const val DOWNSIZED_MEDIUM = "downsized_medium"
private const val TITLE = "title"
private const val SOURCE_TLD = "source_tld"
private const val WIDTH = "width"
private const val HEIGHT = "height"
private const val URL = "url"
private const val DATA = "data"

data class GifResponse(val data: Data) {
    constructor(jsonObject: JSONObject) : this(
        data = Data(jsonObject.getJSONObject(DATA))
    )

    data class Data(val id: String, val sourceTld: String, val title: String, val images: Image) {
        constructor(jsonObject: JSONObject) : this(
            id = jsonObject.getString(ID),
            sourceTld = jsonObject.getString(SOURCE_TLD),
            title = jsonObject.getString(TITLE),
            images = Image(jsonObject.getJSONObject(IMAGES))
        )

        data class Image(val downsizedMedium: DownsizedMedium) {
            constructor(jsonObject: JSONObject) : this(
                downsizedMedium = DownsizedMedium(jsonObject.getJSONObject(DOWNSIZED_MEDIUM))
            )

            data class DownsizedMedium(val width: String, val height: String, val url: String) {
                constructor(jsonObject: JSONObject) : this(
                    width = jsonObject.getString(WIDTH),
                    height = jsonObject.getString(HEIGHT),
                    url = jsonObject.getString(URL)
                )
            }
        }
    }
}
