package com.github.ahnfelt.react4s.samples.toggle

import com.github.ahnfelt.react4s._
import com.github.ahnfelt.react4s.samples.theme.Palette

object ToggleCss extends CssClass(
    S.position.relative(),
    S.display.inlineBlock(),
    S.cursor.pointer(),
    S.width.px(50),
    S.height.px(20),
    S.verticalAlign.middle()
)

object SliderCss extends CssClass(
    S.position.absolute(),
    S.top.px(6),
    S.left.px(5),
    S.width.px(40),
    S.height.px(7),
    S.borderRadius.px(7),
    S.backgroundColor(Palette.background),
    S.boxShadow("inset 0 1px 3px rgba(0, 0, 0, 0.6)"),
    S.transition("background-color 0.2s")
)

object HandleCss extends CssClass(
    S.position.absolute(),
    S.height.px(18),
    S.width.px(18),
    S.left.px(0),
    S.borderRadius.px(18),
    S.backgroundColor(Palette.background),
    S.boxShadow("0 1px 4px 1px rgba(0, 0, 0, 0.6)"),
    S.transition("left 0.2s")
)

object SliderToggledCss extends CssClass(
    S.backgroundColor(Palette.muted)
)

object HandleToggledCss extends CssClass(
    S.left.px(32)
)

