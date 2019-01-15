package com.github.ahnfelt.react4s.samples.context

import com.github.ahnfelt.react4s._

import scala.scalajs.js
import scala.scalajs.js.timers.SetIntervalHandle

case class ThemeOuterComponent() extends Component[NoEmit] {

    override def render(get : Get) =
        E.div(
            Component(ThemeInnerComponent),
            ThemeContext.provide("blue", Component(ThemeInnerComponent))
        )

}
