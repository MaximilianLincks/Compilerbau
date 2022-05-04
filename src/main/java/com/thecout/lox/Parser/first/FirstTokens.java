package com.thecout.lox.Parser.first;

import com.thecout.lox.Parser.Expr.Expr;
import com.thecout.lox.Scanner.Token;
import com.thecout.lox.Scanner.TokenType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.thecout.lox.Scanner.TokenType.*;


public enum FirstTokens {

    PRIMARY(TRUE, FALSE, NIL, NUMBER, STRING, IDENTIFIER, LEFT_PAREN, SUPER),
    CALL(List.of(PRIMARY.tokenTypes)),
    UNARY(BANG,MINUS);

    private final List<TokenType> tokenTypes;

    FirstTokens(TokenType... tokenTypes){
        this.tokenTypes = List.of(tokenTypes);
    }

    FirstTokens(List<List<TokenType>> firstTokens){
        this.tokenTypes = firstTokens.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public boolean containsTokenType(TokenType tokenType){
        return tokenTypes.contains(tokenType);
    }

}
