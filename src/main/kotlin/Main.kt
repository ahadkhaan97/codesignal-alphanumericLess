fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun solution(s1: String, s2: String): Boolean {
    val tokens1 = tokenize(s1)
    val tokens2 = tokenize(s2)
    val minLength = minOf(tokens1.size, tokens2.size)
    for (i in 0 until minLength) {
        val token1 = tokens1[i]
        val token2 = tokens2[i]
        if (token1 != token2) {
            return compareTokens(token1, token2) < 0
        }
    }
    return tokens1.size < tokens2.size
}

fun tokenize(s: String): List<Token> {
    val tokens = mutableListOf<Token>()
    var i = 0
    while (i < s.length) {
        val c = s[i]
        if (c.isLetter()) {
            var j = i + 1
            while (j < s.length && s[j].isLetter()) {
                j++
            }
            tokens.add(Token.Letter(s.substring(i, j)))
            i = j
        } else if (c.isDigit()) {
            var j = i + 1
            while (j < s.length && s[j].isDigit()) {
                j++
            }
            tokens.add(Token.Number(s.substring(i, j)))
            i = j
        } else {
            i++
        }
    }
    return tokens
}

fun compareTokens(t1: Token, t2: Token): Int {
    return when {
        t1 is Token.Letter && t2 is Token.Letter -> t1.value.compareTo(t2.value)
        t1 is Token.Number && t2 is Token.Number -> t1.value.toInt().compareTo(t2.value.toInt())
        t1 is Token.Number -> -1
        t2 is Token.Number -> 1
        else -> 0
    }
}

sealed class Token {
    data class Letter(val value: String) : Token()
    data class Number(val value: String) : Token()
}