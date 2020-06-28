package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L = (10)
W = [0-9]{5}
%{
	public String lexeme;
%}
%%
{L}{W} {lexeme=yytext(); return Identificador;}
 . {return ERROR;}