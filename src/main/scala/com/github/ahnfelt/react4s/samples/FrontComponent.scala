package com.github.ahnfelt.react4s.samples

import com.github.ahnfelt.react4s._
import com.github.ahnfelt.react4s.samples.theme._
import com.github.ahnfelt.react4s.samples.uppercase.UppercaseComponent

case class FrontComponent() extends Component[NoEmit] {

    override def render(get : Get) : Element = {
        E.div(
            E.h1(HeadingCss,
                Text("React4s: Component based UI")
            ),
            E.p(
                Text("React4s is a component based library for writing webapps in Scala, with React.js on the inside. "),
                Text("The components are self-contained and composable, and rendering is specified as a pure function. "),
            ),
            E.div(SpacerCss),
            E.p(
                S.fontWeight.bold(),
                S.paddingLeft.px(10),
                Text("Try me: "),
                Component(UppercaseComponent)
            ),
            Component(CodeComponent, """
case class UppercaseComponent() extends Component[NoEmit] {

    val text = State("Hello!")

    override def render(get : Get) = {
        E.span(
            E.input(A.value(get(text)), A.onChangeText(text.set)),
            Text(" = " + get(text).toUpperCase)
        )
    }

}
            """, true),
            E.div(SpacerCss),
            E.h1(HeadingCss,
                Text("No macros, no implicits, no boilerplate")
            ),
            E.p(
                Text("For the sake of simplicity, React4s uses no macros and no implicits. "),
                Text("It's still concise though - check out the examples and compare them to similar libraries, for Scala or otherwise. "),
            ),
            E.h1(HeadingCss,
                Text("TodoMVC in 139 lines")
            ),
            E.p(
                Text("Including persistence and routing. "),
                E.a(LinkCss, A.href("http://www.react4s.org/todomvc/"), Text("Live version")),
                Text(" and "),
                E.a(LinkCss, A.href("https://github.com/Ahnfelt/react4s-todomvc/blob/master/src/main/scala/com/github/ahnfelt/react4s/todomvc/TodoApp.scala"), Text("source code")),
                Text("."),
            ),
            E.h1(HeadingCss,
                Text("Performance by default")
            ),
            E.p(
                Text("Without shouldComponentUpdate(), React.js recreates the entire virtual DOM for every event - eg. every letter you type in a text field - which leads to input lag. "),
                Text("In plain React.js, the solution is to memoize callbacks, which leads to awkward, unidiomatic code. "),
            ),
            E.p(
                Text("In React4s, there are no callbacks to memoize. "),
                Text("React4s takes advantage of immutability and structural equality to implement shouldComponentUpdate() automatically. "),
                Text("No code required. "),
            ),
            E.p(
                Text("This means that only the relevant path from the root of the view to the updated branch is recomputed. "),
                Text("When the view is balanced, the speedup is exponential: O(log(n)) instead of O(n). "),
            ),
            E.img(
                A.src("https://docs.google.com/drawings/d/e/2PACX-1vQSI9gpc-jRngqNwtsw6lUFgx-NmK4uycVeMXgiF5w_OPqH_gv9YUJ8GFQjl2zqN7TV8JJ9MyY72mlb/pub?w=915&h=424"),
                S.maxWidth.px(600),
                CodeCss,
            ),
            E.h1(HeadingCss,
                Text("No callback props - just emit()")
            ),
            E.p(
                Text("React4s has an Elm/Redux-like emit() system. That means that the props are always the input, and emit() is always the output - instead of props being both input and, via callbacks, output as in plain React.js. "),
            ),
            E.img(
                A.src("https://docs.google.com/drawings/d/e/2PACX-1vTLVj6Y71iTEvr8FA2eqyPx3xIHgnoZwhebw3aJ5qBsvzKPrBQVW14dxiX2PP_RpB23vCkwNko_DxC2/pub?w=1000"),
                S.maxWidth.px(600),
                CodeCss,
            ),
            E.p(
                Text("Instead of updating state locally, you can choose to emit() a message to the parent component, telling it how to update the model for the inner component. "),
                Text("Using this, you have the option of making your entire view pure, and only have state at the very top of your view. "),
                Text("Or you can mix and match. "),
            ),
            E.h1(HeadingCss,
                Text("Simple lifecycle, declarative effects")
            ),
            E.p(
                Text("In React4s, the lifecycle starts with your constructor, where you can set up state and attachables. "),
                Text("Then componentWillRender() and render() will be called. These two methods are called in that order every time the state is updated or props change. "),
                Text("Finally componentWillUnmount() is called just before the component is removed from the DOM. "),
            ),
            E.img(
                A.src("https://docs.google.com/drawings/d/e/2PACX-1vR3Ws7vf5_8OUwKHm0H3It1rWi7J1UBFveyfa0M-roVSk9s6fBTuIscfKZpNDczI4iMZXTZtEWvj3Ol/pub?w=1028&h=898"),
                S.maxWidth.px(600),
                CodeCss,
            ),
            E.p(
                Text("You can factor out code that deals with setting up and tearing down AJAX, timers, global event listeners and so on into Attachables, which can be declarative and reusable. "),
                Text("One example is the included Loader, which declaratively loads data from any source that can provide a Future, and resolves race conditions. "),
            ),
            E.img(
                A.src("https://docs.google.com/drawings/d/e/2PACX-1vQWwDd7SIzwgCgRyWASlPGSsfn9hgnG48SFUJcKSCCaCc_usFniMFvQT0M20fHZV9coPvK4NKISJug6/pub?w=984&amp;h=461"),
                S.maxWidth.px(600),
                CodeCss,
            ),
            E.h1(HeadingCss,
                Text("CSS support with automatic namespacing")
            ),
            E.p(
                Text("You can define CSS classes directly in Scala, and they will be automatically be added to the DOM on use. "),
                Text("They will receive a hash suffix to avoid collisions with classes of the same name in other packages, eg. MyCssClass-ab12cd34. "),
            ),
            E.p(
                Text("In this way, you can put your CSS classes next to the components that need them. "),
                Text("Pseudo-selectors like :hover and :active are supported, as well as media queries, animations and more. "),
            ),
            E.h1(HeadingCss,
                Text("Small codebase, no dependencies")
            ),
            E.p(
                Text("React4s is only ~1k lines of code, and has no dependencies beyond React.js. "),
                Text("It's lightweight, easy to fork, and contributions are very welcome. "),
            ),
            E.h1(HeadingCss,
                Text("Getting started")
            ),
            E.p(
                Text("Check out the examples and the minimal project section on the left hand side menu. "),
            ),
            E.div(SpacerCss),
            E.div(SpacerCss),
        )
    }

}

object HeadingCss extends CssClass(
    S.margin.px(0),
    S.fontSize.px(25),
    S.fontWeight("normal"),
    S.color(Palette.accent),
    Css.selector(":not(:first-child)",
        S.paddingTop.px(20)
    )
)
