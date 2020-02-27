package com.guet.flexbox.build

interface RenderNodeFactory<T : Any> {
    fun create(
            display: Boolean,
            attrs: AttributeSet,
            children: List<T>,
            other: Any?
    ): T
}