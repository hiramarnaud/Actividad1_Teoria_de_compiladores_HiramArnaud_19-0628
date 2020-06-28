package codigo;
import static codigo.Tokens.*;
%%
%caseless
%class Lexer
%type Tokens
L = (integer|char|real)
%{
	public String lexeme;
%}
%%
{L} {lexeme=yytext(); return Identificador;}
 . {return ERROR;}