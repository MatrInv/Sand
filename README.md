# FLISand
A graphical java application that simulates the fall of sand in 2D with a cellular automaton.
This work is greatly inspired by the paper "Ruchome Piaski v1.0" written by Pr Maciej Matyka from the Wrocławski university, in Poland.

http://www.ift.uni.wroc.pl/~maq/zajecia/wp2013/ruchome_piaski.pdf

Check out his work if you have some time.

## Compilation and running
You need jdk1.6 or 1.7 to compile and run the application.

	javac Main.java
	java Main

## How does it work ?
There are three types of elements SAND (in sanded color), WALLS (in black) and VOID (in white).  
You can generate those elements at your cursor position by holding mouse left, right or middle button and then dragging your cursor.

The left pannel gives you access to the buttons reset and play/pause. The third button gives you the possibility to choose the cellular automaton between ours and the Matika's one (the one you can find above in "Ruchome Piaski v1.0"). 

By default, the animation is paused. So, lets create some sand over the board and press "Play" or inversly.

## Authors
Augustin Giovinazzo & Eva D'Alessandro
