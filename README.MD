# Random C Syntax Generator

Randomly generates a syntactically correct C snippet. This short Java program generates C code using a set of production rules. 
<br>

<h4>Production Rules set used to define a subset of the C programming language. </h4>

<pre>
<b><'prog></b> ::= "int main() { <'stat_list> return 0; }"
<br>

<b><'stat_list></b> ::= <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp | <'stat_list> <'stat>
<br>

<b><'stat></b> ::= <'cmpd_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'if_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'iter_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'assgn_stat>
	&nbsp &nbsp &nbsp &nbsp &nbsp | <'decl_stat>
<br>

<b><'cmpd_stat></b> ::= { <'stat_list> }
<br>

<b><'if_stat></b> ::= if ( <'exp> ) <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| if ( <'exp> ) <'cmpd_stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| if ( <'exp> ) <'stat> else <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| if ( <'exp> ) <'cmpd_stat> else <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| if ( <'exp> ) <'stat> else <'cmpd_stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| if ( <'exp> ) <'cmpd_stat> else <'cmpd_stat>
<br>

<b><'iter_stat></b> ::= while ( <'exp> ) <'stat>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| while ( <'exp> ) <'cmpd_stat>
<br>

<b><'assgn_stat></b> ::= <'id> = <'exp> ;
<br>

<b><'decl_stat></b> ::= <'type> <'id> ;
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| <'type> <'assgn_stat>
<br>
<b><'exp></b> ::= <'exp> <'op> <'exp>
&nbsp &nbsp &nbsp &nbsp &nbsp | <'id>
&nbsp &nbsp &nbsp &nbsp &nbsp | <'const><'op> ::= + | - | * | /
<br>

<'type> ::= int
&nbsp &nbsp &nbsp &nbsp &nbsp | double
<br>

<'id> ::= <'char><'chardigit_seq>
<br>

<'const> ::= <'digit><'digit_seq>
<br>

<'char_digit_seq> ::= [empty]
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp | <'char><'char_digit_seq>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp | <'digit><'char_digit_seq>
<br>

<'digit_seq> ::= [empty]
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp| <'digit><'digit_seq>
<br>

<'char> ::= [A-Z] | [a-z] | _
<br>

<'digit> ::= [0-9]
</pre>