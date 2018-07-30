# Mandelbrot Render

The mandelbrot set, is a fractal that is defined over the field of complex numbers as follows.

A member, c, is a part of the set if and only if, the following sequence, let's call it the "Z sequence" (not a technical term) remains bounded for arbitrarily large numbers of c.

Z(n) = Z(n-1)^2 + c

We color members of this set black, and color the rest, based on how long it took for the Z-sequence to diverge (cross some arbitrary threshold.

From this simple formula, we get pretty elegant emergent behavior. This is why, it is almost a rite of passage for aspiring programmers. I sought to implement this engine is as little time as possible. I got just the set within 45 minutes, and added some of the UX and coloring in an additional 45 minutes or so. Here are some renders of different parts of the set.

![alt tag](https://github.com/rjhunjhunwala/Mandelbrot/blob/master/renders.png)

Click on different parts to move the field of view in that direction, and use the mouse-wheel to zoom.

It's worth acknowledging some limitations of this implementation. 

<ul>
<li>Floating point errors accumulate, resulting in lines not being as crisp as I'd like.</li>
<li>We cut iteration off, after a fixed (not too large) number of trials, and if it hasn't crossed the threshold, we assume it won't ever.</li>
<li>The color scheme I chose is jarring, I was pressed for time, and I'm not great with visual appeal.</li>
</ul>