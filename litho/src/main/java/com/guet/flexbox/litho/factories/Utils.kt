package com.guet.flexbox.litho.factories

import android.graphics.Typeface
import android.text.Layout
import android.util.ArrayMap
import android.widget.ImageView
import com.facebook.litho.Component
import com.facebook.litho.widget.VerticalGravity
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaJustify
import com.facebook.yoga.YogaWrap
import com.guet.flexbox.enums.*
import java.util.*

private val mapToLithoEnums = ArrayMap<Class<*>, Map<*, Any>>()
        .apply {
            registerToLitho<FlexAlign> {
                for (value in enumValues<FlexAlign>()) {
                    it[value] = YogaAlign.valueOf(value.name)
                }
            }
            registerToLitho<FlexJustify> {
                for (value in enumValues<FlexJustify>()) {
                    it[value] = YogaJustify.valueOf(value.name)
                }
            }
            registerToLitho<FlexWrap> {
                for (value in enumValues<FlexWrap>()) {
                    it[value] = YogaWrap.valueOf(value.name)
                }
            }
            registerToLitho<Horizontal> {
                it[Horizontal.CENTER] = Layout.Alignment.ALIGN_CENTER
                it[Horizontal.LEFT] = Layout.Alignment.valueOf("ALIGN_LEFT")
                it[Horizontal.RIGHT] = Layout.Alignment.valueOf("ALIGN_RIGHT")
            }
            registerToLitho<ScaleType> {
                for (value in enumValues<ScaleType>()) {
                    it[value] = ImageView.ScaleType.valueOf(value.name)
                }
            }
            registerToLitho<TextStyle> {
                it[TextStyle.BOLD] = Typeface.BOLD
                it[TextStyle.NORMAL] = Typeface.NORMAL
            }
            registerToLitho<Vertical> {
                for (value in enumValues<Vertical>()) {
                    it[value] = VerticalGravity.valueOf(value.name)
                }
            }
        }

private inline fun <reified T : Enum<T>>
        ArrayMap<Class<*>, Map<*, Any>>.registerToLitho(
        action: (EnumMap<T, Any>) -> Unit
) {
    val map = EnumMap<T, Any>(T::class.java)
    action(map)
    this[T::class.java] = map
}

internal inline fun <reified T> Enum<*>.mapToLithoValue(): T {
    return mapToLithoEnums.getValue(this.javaClass)[this] as T
}

internal typealias Assignment<C, V> = C.(display: Boolean, other: Map<String, Any>, value: V) -> Unit

internal typealias AttributeAssignSet<C> = Map<String, Assignment<C, *>>

internal inline fun <T : Component.Builder<*>> create(
        crossinline action: AttrsAssignRegistry<T>.() -> Unit
): Lazy<AttributeAssignSet<T>> {
    return lazy {
        AttrsAssignRegistry<T>().apply(action).value
    }
}