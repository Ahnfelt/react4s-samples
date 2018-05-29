package com.github.ahnfelt.react4s.samples.toggle

import com.github.ahnfelt.react4s._

case class ToggleButtonComponent(toggled : P[Boolean]) extends Component[Boolean] {

    override def render(get : Get) =
        E.div(
            ToggleCss,
            E.div(SliderCss, Tags.when(get(toggled), SliderToggledCss)),
            E.div(HandleCss, Tags.when(get(toggled), HandleToggledCss)),
            A.onLeftClick(_ => emit(!get(toggled)))
        )

}
