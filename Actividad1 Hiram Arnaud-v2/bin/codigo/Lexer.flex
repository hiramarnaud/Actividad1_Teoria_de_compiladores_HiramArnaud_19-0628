package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L = [a-zA-Z_]
W = [a-zA-Z0-9_]+
%{
	public String lexeme;
%}
%%
^{L}{W} {lexeme=yytext(); return Identificador;}
 . {return ERROR;}