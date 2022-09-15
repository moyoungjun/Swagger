package com.example.doc

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import springfox.documentation.swagger.web.SwaggerResource
import springfox.documentation.swagger.web.SwaggerResourcesProvider

@Primary
@Configuration
class DefaultSwaggerResourceProvider:SwaggerResourcesProvider{
    override fun get(): MutableList<SwaggerResource> {
        try {
            val patternResolver = PathMatchingResourcePatternResolver()
            val resources = patternResolver.getResources("/static/*.yaml")
            if (resources.isEmpty()){
                return mutableListOf<SwaggerResource>()
            }
            return resources.map { resource ->
                val swaggerResource = SwaggerResource()
                swaggerResource.swaggerVersion="3"
                swaggerResource.name=resource.filename
                swaggerResource.location="/${resource.filename}"
                swaggerResource
            }.toMutableList()
        } catch (e:Exception){
            println(e)
            return mutableListOf()
        }
    }
}