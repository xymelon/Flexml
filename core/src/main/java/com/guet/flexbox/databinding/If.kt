package com.guet.flexbox.databinding

import android.content.Context
import com.guet.flexbox.data.LayoutNode
import com.guet.flexbox.data.RenderNode
import com.guet.flexbox.el.PropsELContext

internal object If : Declaration() {
    override val attributeSet: AttributeSet by create {
        bool("test")
    }

    override fun transform(
            c: Context,
            type: String,
            attrs: Map<String, Any>,
            data: PropsELContext,
            children: List<LayoutNode>,
            upperVisibility: Boolean
    ): List<RenderNode> {
        if (attrs.getValue("test") as Boolean) {
            return children.map {
                DataBindingUtils.bindNode(c, it, data, upperVisibility)
            }.flatten()
        }
        return emptyList()
    }
}