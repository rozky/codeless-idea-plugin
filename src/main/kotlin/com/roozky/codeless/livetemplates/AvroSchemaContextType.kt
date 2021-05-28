package com.roozky.codeless.livetemplates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class AvroSchemaContextType private constructor() : TemplateContextType("AVRO_SCHEMA", "Avro Schema") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name.endsWith(".avsc")
    }
}