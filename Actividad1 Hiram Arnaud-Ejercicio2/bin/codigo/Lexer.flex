package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L = (a|b)
W = [a-z]*
%{
	public String lexeme;
%}
%%
{L}{W}{L} {lexeme=yytext(); return Identificador;}
 . {return ERROR;}