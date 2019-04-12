package com.github.ahnfelt.react4s.samples.svg

import com.github.ahnfelt.react4s._

case class SvgComponent() extends Component[NoEmit] {

    override def render(get : Get) = {
        E("svg",
            A("viewBox", "0 0 40 40"),
            E("circle", A("cx", "20"), A("cy", "20"), A("r", "15"))
        )
    }

}
