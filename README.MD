# Random C Syntax Generator

Randomly generates a syntactically correct C snippet. This short Java program generates C code using a set of production rules. 
<br>

<h4>Production Rules set used to define a subset of the C programming language. </h4>

<br>

<pre>
<b><'prog></b> ::= "int main() { <'stat_list> return 0; }"
<br>
<b><'stat_list></b> ::= <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp | <'stat_list> <'stat>
<br>
<'stat> ::= <'cmpd_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'if_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'iter_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'assgn_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'decl_stat>
<br>
<'cmpd_stat> ::= { <'stat_list> }
<br>
<'if_stat> ::= if ( <'exp> ) <'stat>
	   | if ( <'exp> ) <'cmpd_stat>
 	   | if ( <'exp> ) <'stat> else <'stat>
	   | if ( <'exp> ) <'cmpd_stat> else <'stat>
	   | if ( <'exp> ) <'stat> else <'cmpd_stat>
	   | if ( <'exp> ) <'cmpd_stat> else <'cmpd_stat>
<br>
<'iter_stat> ::= while ( <'exp> ) <'stat>
	     | while ( <'exp> ) <'cmpd_stat>
<br>
<'assgn_stat> ::= <'id> = <'exp> ;
<br>
<'decl_stat> ::= <'type> <'id> ;
  	     | <'type> <'assgn_stat>
<br>
<'exp> ::= <'exp> <'op> <'exp>
       | <'id>
       | <'const><'op> ::= + | - | * | /
<br>
<'type> ::= int
	| double
<br>
<'id> ::= <'char><'chardigit_seq>
<br>
<'const> ::= <'digit><'digit_seq>
<br>
<'char_digit_seq> ::= [empty]
      		  | <'char><'char_digit_seq>
		  | <'digit><'char_digit_seq>
<br>
<'digit_seq> ::= [empty]
     	     | <'digit><'digit_seq>
<br>
<'char> ::= [A-Z] | [a-z] | _
<br>
<'digit> ::= [0-9]

</pre>