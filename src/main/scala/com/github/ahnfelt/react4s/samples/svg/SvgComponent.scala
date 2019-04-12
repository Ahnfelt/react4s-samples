package com.github.ahnfelt.react4s.samples.svg

import com.github.ahnfelt.react4s._

import scala.scalajs.js
import scala.scalajs.js.timers.SetIntervalHandle

case class SvgComponent() extends Component[NoEmit] {

    val elapsed = State(0)

    var interval : Option[SetIntervalHandle] = None

    override def componentWillRender(get : Get) = {
        if(interval.isEmpty) interval = Some(js.timers.setInterval(1000) {
            elapsed.modify(_ + 1)
        })
    }

    override def componentWillUnmount(get : Get) =
        for(i <- interval) js.timers.clearInterval(i)

    override def render(get : Get) = {
        E("svg",
            A("viewBox", "0 0 40 40"),
            E("circle", A("cx", "20"), A("cy", "20"), A("r", "19"))
        )
    }

}
