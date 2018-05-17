package com.github.ahnfelt.react4s.samples.toggle

import com.github.ahnfelt.react4s._

case class ToggleButtonComponent(toggled : P[Boolean]) extends Component[Boolean] {

    override def render(get : Get) =
        E.div(
            ToggleCss,
            E.div(SliderCss, SliderToggledCss.when(get(toggled))),
            E.div(HandleCss, HandleToggledCss.when(get(toggled))),
            A.onLeftClick(_ => emit(!get(toggled)))
        )

}
