package com.github.ahnfelt.react4s.samples.context

import com.github.ahnfelt.react4s._

case class ThemeInnerComponent() extends Component[NoEmit] {

    override def render(get : Get) =
        ThemeContext.consume(color =>
            E.h3(S.color(color), Text("Text in theme color"))
        )

}
