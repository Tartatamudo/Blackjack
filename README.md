BlackJack:

Hay cartas, las cuales deben ir en un mazo, mazo que tiene el crupier en sus manos y el puede hacer lo que quiera con las cartas,
como entregarle las cartas al jugador, mezclar las cartas y el declara quien es ganador y quien no (basicamente el manda el juego). Por eso lo hice de esta manera
otra cosa, decidi separar al jugador real de los bots mediante un atributo especial para el jugador real 

BullsEye:

Caballos deben ir en una lista, parecido al tema cartas mazo de blakjack, por eso es practicamente igual
el como lo hice. Como no tengo claro quien es el que dirige el "juego" no le pongo nombre concreto a la clase de juego
y sin mas la llamo JuegoBullsEye. en esta clase hice lo mismo, separe los bots del jugador real. Al caballo gandor le di un atributo especial
pensando en seguir mi movimiento de separar al jugador de los bots, lo demas son solo metodos para hacer funcionar el juego

la id de los caballos es del 0 al 5 para no complicar las cosas.

Tema validadores y esas cosas no las implemente por lo que para que funcione el programa se debe poner lo que se pide.
Hice esto ya que a la hora de hacer las ventanas eso cambiaria y al siguiente dia de este pienso hacerlas, por lo que no le veo sentido a hacerlo

En el tema ventanas recurri a tener un atributo en practicamente todas las ventanas para pasar la informacion requerida, como lo era un jugador o un nombre. A la hora de hacer las ventanas
tuve algunos problemas conm el orden de estas, ya que se ponen de arriba a abajo y de izquierda a derecha en base a como añadas las variables al panel. pior lo que me dispuse a crear variables invisibles
para dejarlas en los lugares donde no queria tener una variable

En tema acciones de los botones tengo 3 ifs encadenados lo cual no me gusta, pero por las distintas posibilidades, como si se equivocan en poner el monto a apostar, o el id del caballo, pero solo esta en caso de que se equivoque de formato, no si se equivoca
de numero.

igual esta todo funcionando y ordenado lo mas posible, me falta mucho para comprender bien las ventanas