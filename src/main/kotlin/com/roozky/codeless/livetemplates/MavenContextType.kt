package com.roozky.codeless.livetemplates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class MavenContextType private constructor() : TemplateContextType("MAVEN", "Maven") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name == "pom.yml"
    }
}