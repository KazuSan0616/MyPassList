package com.nagomiya.mypasslist.db

import com.nagomiya.mypasslist.entity.PassEntity
import org.jetbrains.anko.db.MapRowParser

class PasswordRowParser:MapRowParser<PassEntity> {
    override fun parseRow(columns: Map<String, Any?>): PassEntity {
        return  PassEntity(
                (columns["_id"] as Long).toInt(),
                columns["title"] as String,
                columns["uid"] as String,
                columns["password"] as String
        )

    }

}