package com.roozky.codeless.livetemplates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.roozky.codeless.CodelessBundle

private const val CONTEXT_TYPE = "MAVEN"

class MavenContextType private constructor() :
    TemplateContextType(CONTEXT_TYPE, CodelessBundle.message("live.templates.context.maven")) {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name == "pom.yml"
    }
}